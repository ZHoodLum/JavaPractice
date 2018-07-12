package com.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.hibernate.beans.Schedule;
import com.hibernate.dao.ScheduleDAO;
import com.struts.forms.PageForm;
import com.struts.forms.ScheduleForm;
import com.struts.util.Constants;
import com.struts.util.Pager;

public class ScheduleAction extends BaseAction {

	protected ScheduleDAO scheduleDAO;

	Logger log = Logger.getLogger(this.getClass());

	public ScheduleDAO getScheduleDAO() {
		return scheduleDAO;
	}

	public void setScheduleDAO(ScheduleDAO scheduleDAO) {
		this.scheduleDAO = scheduleDAO;
	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String username = getUsername(request);
		
		PageForm pageForm = (PageForm) form;
		
		// get pager
		Pager pager = scheduleDAO.findPagerByUsername(username, pageForm
				.getPageSize(), pageForm.getPageNo());
		
		// set scheduleList
		request.setAttribute("scheduleList", pager.getResultList());
		
		// set pager
		request.setAttribute("pager", pager);
		
		// save session
		setSession(request, Constants.PAGER_SCHEDULE, pageForm);
		
		ActionForward forward = mapping.findForward(Constants.LIST_KEY);
		return (forward);
	}
	
	public ActionForward back(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String username = getUsername(request);
		
		PageForm pageForm = (PageForm)getSession(request, Constants.PAGER_SCHEDULE);
		
		// get pager
		Pager pager = scheduleDAO.findPagerByUsername(username, pageForm
				.getPageSize(), pageForm.getPageNo());
		
		// set scheduleList
		request.setAttribute("scheduleList", pager.getResultList());
		
		// set pager
		request.setAttribute("pager", pager);
		
		// save session
		setSession(request, Constants.PAGER_SCHEDULE, pageForm);
		
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
		ScheduleForm scheduleForm = (ScheduleForm) form;
		String username = getUsername(request);		
		
		// insert object
		Schedule schedule = new Schedule();
		schedule.setUsername(username);
		schedule.setYear(new Integer(scheduleForm.getYear()));
		schedule.setMonth(new Integer(scheduleForm.getMonth()));
		schedule.setDay(new Integer(scheduleForm.getDay()));
		schedule.setPlan(scheduleForm.getPlan());
		scheduleDAO.insert(schedule);
		
		// save messages
		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"schedule.message.add.success"));
		saveErrors(request, messages);
		
		// get pageform from session
		PageForm pageForm = (PageForm)getSession(request, Constants.PAGER_SCHEDULE);
		
		// get pager form list page
		Pager pager = scheduleDAO.findPagerByUsername(username, pageForm
				.getPageSize(), pageForm.getPageNo());
		request.setAttribute("scheduleList", pager.getResultList());
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
					"schedule.message.edit.notexist"));
			saveErrors(request, messages);
			return mapping.findForward(Constants.LIST_KEY);
		} else {
			// get object
			Schedule schedule = scheduleDAO.findById(id);
			if (schedule == null) {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"schedule.message.edit.notexist"));
				saveErrors(request, messages);
				return mapping.findForward(Constants.LIST_KEY);
			}
			
			// save form object
			ScheduleForm scheduleForm = new ScheduleForm();
			scheduleForm.setId(schedule.getId().toString());
			scheduleForm.setUsername(schedule.getUsername());
			scheduleForm.setYear(schedule.getYear().toString());
			scheduleForm.setMonth(schedule.getMonth().toString());
			scheduleForm.setDay(schedule.getDay().toString());
			scheduleForm.setPlan(schedule.getPlan());
			
			// save in request
			request.setAttribute("scheduleFormBean", scheduleForm);

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
					"schedule.message.edit.notexist"));
			saveErrors(request, messages);
			return mapping.findForward(Constants.LIST_KEY);
		} else {
			// get object
			Schedule schedule = scheduleDAO.findById(id);
			if (schedule == null) {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"schedule.message.edit.notexist"));
				saveErrors(request, messages);
				return mapping.findForward(Constants.LIST_KEY);
			}
			
			// save form object
			ScheduleForm scheduleForm = new ScheduleForm();
			scheduleForm.setId(schedule.getId().toString());
			scheduleForm.setUsername(schedule.getUsername());
			scheduleForm.setYear(schedule.getYear().toString());
			scheduleForm.setMonth(schedule.getMonth().toString());
			scheduleForm.setDay(schedule.getDay().toString());
			scheduleForm.setPlan(schedule.getPlan());
			
			// save in request
			request.setAttribute("scheduleFormBean", scheduleForm);

			return mapping.findForward(Constants.EDIT_KEY);
		}
	}

	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionMessages messages = new ActionMessages();
		ScheduleForm scheduleForm = (ScheduleForm) form;
		Schedule schedule = new Schedule();
		String username = getUsername(request);
		
		// update object
		schedule.setId(new Integer(scheduleForm.getId()));
		schedule.setUsername(username);
		schedule.setYear(new Integer(scheduleForm.getYear()));
		schedule.setMonth(new Integer(scheduleForm.getMonth()));
		schedule.setDay(new Integer(scheduleForm.getDay()));
		schedule.setPlan(scheduleForm.getPlan());
		scheduleDAO.update(schedule);
		
		// save messages
		messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"schedule.message.edit.success"));
		saveErrors(request, messages);
		
		// get pageForm from session
		PageForm pageForm = (PageForm)getSession(request, Constants.PAGER_SCHEDULE);
		
		// get pager form list page
		Pager pager = scheduleDAO.findPagerByUsername(username, pageForm
				.getPageSize(), pageForm.getPageNo());
		request.setAttribute("scheduleList", pager.getResultList());
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
					"schedule.message.edit.notexist"));
		} else {
			// delete object
			scheduleDAO.delete(id);
			
			// save messages
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"schedule.message.delete.success"));

			String username = getUsername(request);
			
			// get pageForm from session
			PageForm pageForm = (PageForm)getSession(request, Constants.PAGER_SCHEDULE);
			
			// get pager form list page
			Pager pager = scheduleDAO.findPagerByUsername(username, pageForm
					.getPageSize(), pageForm.getPageNo());
			request.setAttribute("scheduleList", pager.getResultList());
			request.setAttribute("pager", pager);
		}
		saveErrors(request, messages);
		return mapping.findForward(Constants.LIST_KEY);
	}
}
