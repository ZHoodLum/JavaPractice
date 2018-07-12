package com.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.hibernate.beans.Worklog;
import com.hibernate.dao.WorklogDAO;
import com.struts.forms.PageForm;
import com.struts.forms.WorklogForm;
import com.struts.util.Constants;
import com.struts.util.Pager;

public class WorklogAction extends BaseAction {

	protected WorklogDAO worklogDAO;

	Logger log = Logger.getLogger(this.getClass());

	public WorklogDAO getWorklogDAO() {
		return worklogDAO;
	}

	public void setWorklogDAO(WorklogDAO worklogDAO) {
		this.worklogDAO = worklogDAO;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String username = getUsername(request);
		
		PageForm pageForm = (PageForm) form;
		
		// get pager
		Pager pager = worklogDAO.findPagerByUsername(username, pageForm
				.getPageSize(), pageForm.getPageNo());
		
		// set worklogList
		request.setAttribute("worklogList", pager.getResultList());
		
		// set pager
		request.setAttribute("pager", pager);
		
		// save session
		setSession(request, Constants.PAGER_WORKLOG, pageForm);
		
		ActionForward forward = mapping.findForward(Constants.LIST_KEY);
		return (forward);
	}
	
	public ActionForward back(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String username = getUsername(request);
		
		PageForm pageForm = (PageForm)getSession(request, Constants.PAGER_WORKLOG);
		
		// get pager
		Pager pager = worklogDAO.findPagerByUsername(username, pageForm
				.getPageSize(), pageForm.getPageNo());
		
		// set worklogList
		request.setAttribute("worklogList", pager.getResultList());
		
		// set pager
		request.setAttribute("pager", pager);
		
		// save session
		setSession(request, Constants.PAGER_WORKLOG, pageForm);
		
		ActionForward forward = mapping.findForward(Constants.LIST_KEY);
		return (forward);
	}

	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = mapping.findForward(Constants.ADD_KEY);
		return (forward);
	}

	public ActionForward insert(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionMessages messages = new ActionMessages();
		WorklogForm worklogForm = (WorklogForm) form;
		String username = getUsername(request);		
		
		// insert object
		Worklog worklog = new Worklog();
		worklog.setUsername(username);
		worklog.setYear(new Integer(worklogForm.getYear()));
		worklog.setMonth(new Integer(worklogForm.getMonth()));
		worklog.setDay(new Integer(worklogForm.getDay()));
		worklog.setTitle(worklogForm.getTitle());
		worklog.setDescription(worklogForm.getDescription());
		worklog.setLogtime(worklogForm.getLogtime());
		worklogDAO.insert(worklog);
		
		// save messages
		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"worklog.message.add.success"));
		saveErrors(request, messages);
		
		// get pageform from session
		PageForm pageForm = (PageForm)getSession(request, Constants.PAGER_WORKLOG);
		
		// get pager form list page
		Pager pager = worklogDAO.findPagerByUsername(username, pageForm
				.getPageSize(), pageForm.getPageNo());
		request.setAttribute("worklogList", pager.getResultList());
		request.setAttribute("pager", pager);

		return mapping.findForward(Constants.LIST_KEY);
	}
	
	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionMessages messages = new ActionMessages();
		String id = request.getParameter("id");
		
		if (id == null) {
			// id not exist, save messages
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"worklog.message.edit.notexist"));
			saveErrors(request, messages);
			return mapping.findForward(Constants.LIST_KEY);
		} else {
			// get object
			Worklog worklog = worklogDAO.findById(id);
			if (worklog == null) {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"worklog.message.edit.notexist"));
				saveErrors(request, messages);
				return mapping.findForward(Constants.LIST_KEY);
			}
			
			// save form object
			WorklogForm worklogForm = new WorklogForm();
			worklogForm.setId(worklog.getId().toString());
			worklogForm.setUsername(worklog.getUsername());
			worklogForm.setYear(worklog.getYear().toString());
			worklogForm.setMonth(worklog.getMonth().toString());
			worklogForm.setDay(worklog.getDay().toString());
			worklogForm.setTitle(worklog.getTitle());
			worklogForm.setDescription(worklog.getDescription());
			worklogForm.setLogtime(worklog.getLogtime());
			
			// save in request
			request.setAttribute("worklogFormBean", worklogForm);

			return mapping.findForward(Constants.VIEW_KEY);
		}
	}

	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionMessages messages = new ActionMessages();
		String id = request.getParameter("id");
		
		if (id == null) {
			// id not exist, save messages
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"worklog.message.edit.notexist"));
			saveErrors(request, messages);
			return mapping.findForward(Constants.LIST_KEY);
		} else {
			// get object
			Worklog worklog = worklogDAO.findById(id);
			if (worklog == null) {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"worklog.message.edit.notexist"));
				saveErrors(request, messages);
				return mapping.findForward(Constants.LIST_KEY);
			}
			
			// save form object
			WorklogForm worklogForm = new WorklogForm();
			worklogForm.setId(worklog.getId().toString());
			worklogForm.setUsername(worklog.getUsername());
			worklogForm.setYear(worklog.getYear().toString());
			worklogForm.setMonth(worklog.getMonth().toString());
			worklogForm.setDay(worklog.getDay().toString());
			worklogForm.setTitle(worklog.getTitle());
			worklogForm.setDescription(worklog.getDescription());
			worklogForm.setLogtime(worklog.getLogtime());
			
			// save in request
			request.setAttribute("worklogFormBean", worklogForm);

			return mapping.findForward(Constants.EDIT_KEY);
		}
	}

	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionMessages messages = new ActionMessages();
		WorklogForm worklogForm = (WorklogForm) form;
		Worklog worklog = new Worklog();
		String username = getUsername(request);
		
		// update object
		worklog.setId(new Integer(worklogForm.getId()));
		worklog.setUsername(username);
		worklog.setYear(new Integer(worklogForm.getYear()));
		worklog.setMonth(new Integer(worklogForm.getMonth()));
		worklog.setDay(new Integer(worklogForm.getDay()));
		worklog.setTitle(worklogForm.getTitle());
		worklog.setDescription(worklogForm.getDescription());
		worklog.setLogtime(worklogForm.getLogtime());
		worklogDAO.update(worklog);
		
		// save messages
		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"worklog.message.edit.success"));
		saveErrors(request, messages);
		
		// get pageForm from session
		PageForm pageForm = (PageForm)getSession(request, Constants.PAGER_WORKLOG);
		
		// get pager form list page
		Pager pager = worklogDAO.findPagerByUsername(username, pageForm
				.getPageSize(), pageForm.getPageNo());
		request.setAttribute("worklogList", pager.getResultList());
		request.setAttribute("pager", pager);

		ActionForward forward = mapping.findForward(Constants.LIST_KEY);
		return (forward);
	}

	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionMessages messages = new ActionMessages();

		String id = request.getParameter("id");
		if (id == null) {
			// if id not exist
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"worklog.message.edit.notexist"));
		} else {
			// delete object
			worklogDAO.delete(id);
			
			// save messages
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"worklog.message.delete.success"));

			String username = getUsername(request);
			
			// get pageForm from session
			PageForm pageForm = (PageForm)getSession(request, Constants.PAGER_WORKLOG);
			
			// get pager form list page
			Pager pager = worklogDAO.findPagerByUsername(username, pageForm
					.getPageSize(), pageForm.getPageNo());
			request.setAttribute("worklogList", pager.getResultList());
			request.setAttribute("pager", pager);
		}
		saveErrors(request, messages);
		return mapping.findForward(Constants.LIST_KEY);
	}
}
