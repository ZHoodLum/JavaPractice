package com.struts.actions;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.hibernate.beans.Address;
import com.hibernate.dao.AddressDAO;
import com.struts.forms.AddressForm;
import com.struts.forms.PageForm;
import com.struts.util.Constants;
import com.struts.util.Pager;

public class AddressAction extends BaseAction {

	protected AddressDAO addressDAO;

	Logger log = Logger.getLogger(this.getClass());

	public AddressDAO getAddressDAO() {
		return addressDAO;
	}

	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}
	
	protected void timeout(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PrintWriter out=response.getWriter();
		out.print("<script type="+"text/javascript"+">alert('"+Constants.PLEASElOGIN+"');window.location.href='../index.do';</script>");
	    System.out.println("ÏÂÏß"); 
	}
	
	public ActionForward back(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String username = getUsername(request);
		
		if (isTimeout(request)) {
			//timeout(request,response);
		    return mapping.findForward(Constants.INDEX_KEY);
		}
		
		PageForm pageForm = (PageForm)getSession(request, Constants.PAGER_ADDRESS);
		
		// get pager
		Pager pager = addressDAO.findPagerByUsername(username, pageForm
				.getPageSize(), pageForm.getPageNo());
		
		// set addressList
		request.setAttribute("addressList", pager.getResultList());
		
		// set pager
		request.setAttribute("pager", pager);
		
		// save session
		setSession(request, Constants.PAGER_ADDRESS, pageForm);
		
		ActionForward forward = mapping.findForward(Constants.LIST_KEY);
		return (forward);
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (isTimeout(request)) {
			//timeout(request,response);
		    return mapping.findForward(Constants.INDEX_KEY);
		}
		String username = getUsername(request);
		
		PageForm pageForm = (PageForm) form;
		
		// get pager
		Pager pager = addressDAO.findPagerByUsername(username, pageForm
				.getPageSize(), pageForm.getPageNo());
		
		// set addressList
		request.setAttribute("addressList", pager.getResultList());
		
		// set pager
		request.setAttribute("pager", pager);
		
		// save session
		setSession(request, Constants.PAGER_ADDRESS, pageForm);
		
		ActionForward forward = mapping.findForward(Constants.LIST_KEY);
		return (forward);
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (isTimeout(request)) {
		    return mapping.findForward(Constants.INDEX_KEY);
		}
		ActionForward forward = mapping.findForward(Constants.ADD_KEY);
		return (forward);
	}

	public ActionForward insert(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (isTimeout(request)) {
		    return mapping.findForward(Constants.INDEX_KEY);
		}
		ActionMessages messages = new ActionMessages();
		AddressForm addressForm = (AddressForm) form;
		String username = getUsername(request);
		
		// check if exists
		boolean b = addressDAO.isExist(username, addressForm.getName());
		if (!b) {
			// insert object
			Address address = new Address();
			address.setUsername(username);
			address.setName(addressForm.getName());
			address.setSex(addressForm.getSex());
			address.setMobile(addressForm.getMobile());
			address.setEmail(addressForm.getEmail());
			address.setQq(addressForm.getQq());
			address.setCompany(addressForm.getCompany());
			address.setAddress(addressForm.getAddress());
			address.setPostcode(addressForm.getPostcode());
			addressDAO.insert(address);
			
			// save messages
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"address.message.add.success"));
			saveErrors(request, messages);
			
			// get pageform from session
			PageForm pageForm = (PageForm)getSession(request, Constants.PAGER_ADDRESS);
			
			// get pager form list page
			Pager pager = addressDAO.findPagerByUsername(username, pageForm
					.getPageSize(), pageForm.getPageNo());
			request.setAttribute("addressList", pager.getResultList());
			request.setAttribute("pager", pager);

			return mapping.findForward(Constants.LIST_KEY);
		} else {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"address.message.add.failed"));
			saveErrors(request, messages);

			request.setAttribute("addressFormBean", addressForm);

			return mapping.findForward(Constants.ADD_KEY);
		}
	}
	
	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (isTimeout(request)) {
		    return mapping.findForward(Constants.INDEX_KEY);
		}
		ActionMessages messages = new ActionMessages();
		String id = request.getParameter("id");
		
		if (id == null) {
			// id not exist, save messages
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"address.message.edit.notexist"));
			saveErrors(request, messages);
			return mapping.findForward(Constants.LIST_KEY);
		} else {
			// get object
			Address address = addressDAO.findById(id);
			if (address == null) {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"address.message.edit.notexist"));
				saveErrors(request, messages);
				return mapping.findForward(Constants.LIST_KEY);
			}
			
			// save form object
			AddressForm addressForm = new AddressForm();
			addressForm.setId(address.getId().toString());
			addressForm.setName(address.getName());
			addressForm.setSex(address.getSex());
			addressForm.setMobile(address.getMobile());
			addressForm.setEmail(address.getEmail());
			addressForm.setQq(address.getQq());
			addressForm.setCompany(address.getCompany());
			addressForm.setAddress(address.getAddress());
			addressForm.setPostcode(address.getPostcode());
			
			// save in request
			request.setAttribute("addressFormBean", addressForm);

			return mapping.findForward(Constants.VIEW_KEY);
		}
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (isTimeout(request)) {
		    return mapping.findForward(Constants.INDEX_KEY);
		}
		ActionMessages messages = new ActionMessages();
		String id = request.getParameter("id");
		
		if (id == null) {
			// id not exist, save messages
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"address.message.edit.notexist"));
			saveErrors(request, messages);
			return mapping.findForward(Constants.LIST_KEY);
		} else {
			// get object
			Address address = addressDAO.findById(id);
			if (address == null) {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"address.message.edit.notexist"));
				saveErrors(request, messages);
				return mapping.findForward(Constants.LIST_KEY);
			}
			
			// save form object
			AddressForm addressForm = new AddressForm();
			addressForm.setId(address.getId().toString());
			addressForm.setName(address.getName());
			addressForm.setSex(address.getSex());
			addressForm.setMobile(address.getMobile());
			addressForm.setEmail(address.getEmail());
			addressForm.setQq(address.getQq());
			addressForm.setCompany(address.getCompany());
			addressForm.setAddress(address.getAddress());
			addressForm.setPostcode(address.getPostcode());
			
			// save in request
			request.setAttribute("addressFormBean", addressForm);

			return mapping.findForward(Constants.EDIT_KEY);
		}
	}

	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (isTimeout(request)) {
		    return mapping.findForward(Constants.INDEX_KEY);
		}
		ActionMessages messages = new ActionMessages();
		AddressForm addressForm = (AddressForm) form;
		Address address = new Address();
		String username = getUsername(request);
		
		// update object
		address.setId(new Integer(addressForm.getId()));
		address.setUsername(username);
		address.setName(addressForm.getName());
		address.setSex(addressForm.getSex());
		address.setMobile(addressForm.getMobile());
		address.setEmail(addressForm.getEmail());
		address.setQq(addressForm.getQq());
		address.setCompany(addressForm.getCompany());
		address.setAddress(addressForm.getAddress());
		address.setPostcode(addressForm.getPostcode());
		addressDAO.update(address);
		
		// save messages
		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"address.message.edit.success"));
		saveErrors(request, messages);
		
		// get pageForm from session
		PageForm pageForm = (PageForm)getSession(request, Constants.PAGER_ADDRESS);
		
		// get pager form list page
		Pager pager = addressDAO.findPagerByUsername(username, pageForm
				.getPageSize(), pageForm.getPageNo());
		request.setAttribute("addressList", pager.getResultList());
		request.setAttribute("pager", pager);

		ActionForward forward = mapping.findForward(Constants.LIST_KEY);
		return (forward);
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (isTimeout(request)) {
		    return mapping.findForward(Constants.INDEX_KEY);
		}
		ActionMessages messages = new ActionMessages();

		String id = request.getParameter("id");
		if (id == null) {
			// if id not exist
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"address.message.edit.notexist"));
		} else {
			// delete object
			addressDAO.delete(id);
			
			// save messages
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"address.message.delete.success"));

			String username = getUsername(request);
			
			// get pageForm from session
			PageForm pageForm = (PageForm)getSession(request, Constants.PAGER_ADDRESS);
			
			// get pager form list page
			Pager pager = addressDAO.findPagerByUsername(username, pageForm
					.getPageSize(), pageForm.getPageNo());
			request.setAttribute("addressList", pager.getResultList());
			request.setAttribute("pager", pager);
		}
		saveErrors(request, messages);
		return mapping.findForward(Constants.LIST_KEY);
	}
}
