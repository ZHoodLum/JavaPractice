package com.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.hibernate.beans.User;
import com.hibernate.dao.UserDAO;
import com.struts.forms.PersonForm;
import com.struts.forms.PageForm;
import com.struts.util.Change;
import com.struts.util.Constants;
import com.struts.util.MD5;
import com.struts.util.Pager;

public class PersonAction extends BaseAction {

	protected UserDAO personDAO;

	Logger log = Logger.getLogger(this.getClass());

	public UserDAO getUserDAO() {
		return personDAO;
	}

	public void setUserDAO(UserDAO personDAO) {
		this.personDAO = personDAO;
	}
	
	public ActionForward back(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (isTimeout(request)) {
		    return mapping.findForward(Constants.INDEX_KEY);
		}
		
		PageForm pageForm = (PageForm)getSession(request, Constants.PAGER_PERSON);
		
		// get pager
		Pager pager = personDAO.findPagerAllUser(pageForm
				.getPageSize(), pageForm.getPageNo());
		
		// set personList
		request.setAttribute("personList", pager.getResultList());
		
		// set pager
		request.setAttribute("pager", pager);
		
		// save session
		setSession(request, Constants.PAGER_PERSON, pageForm);
		
		ActionForward forward = mapping.findForward(Constants.LIST_KEY);
		return (forward);
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (isTimeout(request)) {
		    return mapping.findForward(Constants.INDEX_KEY);
		}
		
		PageForm pageForm = (PageForm) form;
		
		// get pager
		Pager pager = personDAO.findPagerAllUser(pageForm
				.getPageSize(), pageForm.getPageNo());
		
		// set personList
		request.setAttribute("personList", pager.getResultList());
		
		// set pager
		request.setAttribute("pager", pager);
		
		// save session
		setSession(request, Constants.PAGER_PERSON, pageForm);
		
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
		PersonForm personForm = (PersonForm) form;
		String username = personForm.getUsername();
		
		// check if exists
		boolean b = personDAO.isExist(username);
		if (!b) {
			// insert object
			User person = new User();
			person.setUsername(username);
			person.setPassword(personForm.getPassword1());
			person.setTruename(personForm.getTruename());
			person.setSex(personForm.getSex());
			person.setJob(personForm.getJob());
			person.setTelphone(personForm.getTelphone());
			person.setEmail(personForm.getEmail());
			person.setBranch(personForm.getBranch());
			person.setAddress(personForm.getAddress());
			person.setAccessTime(0);
			person.setUserid("1");
			person.setIslogging("false");
			person.setFoundTime(Change.datetostr(new Date()));
			personDAO.insertUser(person);
			
			// save messages
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"person.message.add.success"));
			saveErrors(request, messages);
			
			// get pageform from session
			PageForm pageForm = (PageForm)getSession(request, Constants.PAGER_PERSON);
			
			// get pager form list page
			Pager pager = personDAO.findPagerAllUser(pageForm
					.getPageSize(), pageForm.getPageNo());
			request.setAttribute("personList", pager.getResultList());
			request.setAttribute("pager", pager);

			return mapping.findForward(Constants.LIST_KEY);
		} else {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"person.message.add.failed"));
			saveErrors(request, messages);

			request.setAttribute("personFormBean", personForm);

			return mapping.findForward(Constants.ADD_KEY);
		}
	}
	
	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (isTimeout(request)) {
		    return mapping.findForward(Constants.INDEX_KEY);
		}
		HttpSession session = request.getSession();
		ActionMessages messages = new ActionMessages();
		String username =request.getParameter("username");
		if (username == null) {
			// id not exist, save messages
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"person.message.edit.notexist"));
			saveErrors(request, messages);
			return mapping.findForward(Constants.LIST_KEY);
		} else {
			// get object
			User person = personDAO.findByUsername(username);
			if (person == null) {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"person.message.edit.notexist"));
				saveErrors(request, messages);
				return mapping.findForward(Constants.LIST_KEY);
			}
			
			// save form object
			PersonForm personForm = new PersonForm();
			personForm.setId(person.getId().toString());
			personForm.setUsername(person.getUsername());
			personForm.setPassword1(person.getPassword());
			personForm.setPassword2(person.getPassword());
			personForm.setTruename(person.getTruename());
			personForm.setSex(person.getSex());
			personForm.setTelphone(person.getTelphone());
			personForm.setEmail(person.getEmail());
			personForm.setJob(person.getJob());
			personForm.setBranch(person.getBranch());
			personForm.setAddress(person.getAddress());
			personForm.setAccessTime(person.getAccessTime().toString());
			personForm.setFoundTime(person.getFoundTime());
			String userid=null;
			if(person.getUserid().equals("0"))
			{
				userid=Constants.SYSTEMMANAGER;
			}
			else if(person.getUserid().equals("1"))
			{
				userid=Constants.NORMALUSER;
			}
			personForm.setUserid(userid);
			personForm.setIslogging(person.getIslogging());
			
			// save in request
			request.setAttribute("personFormBean", personForm);

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
		String username = request.getParameter("username");
		HttpSession session = request.getSession();
		
		if (username == null) {
			// id not exist, save messages
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"person.message.edit.notexist"));
			saveErrors(request, messages);
			return mapping.findForward(Constants.LIST_KEY);
		} else {
			// get object
			User person = personDAO.findByUsername(username);
			if (person == null) {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"person.message.edit.notexist"));
				saveErrors(request, messages);
				return mapping.findForward(Constants.LIST_KEY);
			}
			
			// save form object
			PersonForm personForm = new PersonForm();
			personForm.setId(person.getId().toString());
			personForm.setUsername(person.getUsername());
			personForm.setPassword1(person.getPassword());
			personForm.setPassword2(person.getPassword());
			personForm.setTruename(person.getTruename());
			personForm.setSex(person.getSex());
			personForm.setTelphone(person.getTelphone());
			personForm.setEmail(person.getEmail());
			personForm.setJob(person.getJob());
			personForm.setBranch(person.getBranch());
			personForm.setAddress(person.getAddress());
			personForm.setAccessTime(person.getAccessTime().toString());
			personForm.setFoundTime(person.getFoundTime());
			session.setAttribute("password", person.getPassword());
			String userid=null;
			if(person.getUserid().equals("0"))
			{
				userid=Constants.SYSTEMMANAGER;
			}
			else if(person.getUserid().equals("1"))
			{
				userid=Constants.NORMALUSER;
			}
			personForm.setUserid(userid);
			personForm.setIslogging(person.getIslogging());
			String my=null;
			if(request.getParameter("update").equals("my"))
			{
				my="my";
			}
			else
			{
				my="person";
			}
			personForm.setMyupdate(my);
			
			// save in request
			request.setAttribute("personFormBean", personForm);

			return mapping.findForward(Constants.EDIT_KEY);
		}
	}

	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (isTimeout(request)) {
		    return mapping.findForward(Constants.INDEX_KEY);
		}
		HttpSession session = request.getSession();
		ActionMessages messages = new ActionMessages();
		PersonForm personForm = (PersonForm) form;
		String my=personForm.getMyupdate();
		User person = new User();
		MD5 myMd5=new MD5();
		String encodePwd=null;
		encodePwd=myMd5.getMD5ofStr(personForm.getPassword1());
		// update object
		person.setId(new Integer(personForm.getId()));
		person.setUsername(personForm.getUsername());
		person.setPassword(encodePwd);
		person.setTruename(personForm.getTruename());
		person.setSex(personForm.getSex());
		person.setTelphone(personForm.getTelphone());
		person.setEmail(personForm.getEmail());
		person.setJob(personForm.getJob());
		person.setBranch(personForm.getBranch());
		person.setAddress(personForm.getAddress());
		person.setAccessTime(Change.strtoint(personForm.getAccessTime()));
		person.setFoundTime(personForm.getFoundTime());
		person.setUserid(personForm.getUserid());
		person.setIslogging(personForm.getIslogging());
		personDAO.updateUser(person);
		
		// save messages
		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"person.message.edit.success"));
		saveErrors(request, messages);
		ActionForward forward=new ActionForward();
		if(my.equals("person"))
		{
			// get pageForm from session
			PageForm pageForm = (PageForm)getSession(request, Constants.PAGER_PERSON);
			
			// get pager form list page
			Pager pager = personDAO.findPagerAllUser(pageForm
					.getPageSize(), pageForm.getPageNo());
			request.setAttribute("personList", pager.getResultList());
			request.setAttribute("pager", pager);

			forward = mapping.findForward(Constants.LIST_KEY);
		}
		else
		{
			forward = mapping.findForward(Constants.WELCOME_KEY);
		}
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
					"person.message.edit.notexist"));
		} else {
			// delete object
			personDAO.deleteUser(id);
			
			// save messages
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"person.message.delete.success"));
			
			// get pageForm from session
			PageForm pageForm = (PageForm)getSession(request, Constants.PAGER_PERSON);
			
			// get pager form list page
			Pager pager = personDAO.findPagerAllUser(pageForm
					.getPageSize(), pageForm.getPageNo());
			request.setAttribute("personList", pager.getResultList());
			request.setAttribute("pager", pager);
		}
		saveErrors(request, messages);
		return mapping.findForward(Constants.LIST_KEY);
	}
}
