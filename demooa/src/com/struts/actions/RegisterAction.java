package com.struts.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.hibernate.beans.User;
import com.hibernate.dao.UserDAO;
import com.struts.forms.RegisterForm;
import com.struts.util.Change;
import com.struts.util.Constants;
import com.struts.util.MD5;

public class RegisterAction extends DispatchAction {

	protected UserDAO userDAO;

	Logger log = Logger.getLogger(this.getClass());

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionForward forward = mapping.findForward(Constants.FAILURE_KEY);
		return (forward);
	}

	public ActionForward register(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionMessages messages = new ActionMessages();
		ActionForward forward = new ActionForward();
		RegisterForm registerForm = (RegisterForm) form;

		try {
			// if exist
			boolean isExist = isExist(request, registerForm);

			if (isExist) {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"register.message.failed"));
			} else {
				insert(request, registerForm);
				log.info("User " + registerForm.getUsername() + " register.");
			}

		} catch (Exception e) {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"register.message.failed"));

		}

		// If a message is required, save the specified key(s)
		// into the request for use by the <struts:errors> tag.

		if (!messages.isEmpty()) {
			saveErrors(request, messages);
			request.setAttribute("registerFormBean", registerForm);
			forward = mapping.findForward(Constants.FAILURE_KEY);
		} else {
			forward = mapping.findForward(Constants.SUCCESS_KEY);
		}

		// Finish with
		return (forward);
	}

	private boolean isExist(HttpServletRequest request,
			RegisterForm registerForm) {
		if (getUserDAO().isExist(registerForm.getUsername())) {
			return true;
		} else {
			return false;
		}
	}

	private void insert(HttpServletRequest request, RegisterForm registerForm) {
		MD5 myMd5=new MD5();
		String encodePwd=myMd5.getMD5ofStr(registerForm.getPassword1());
		User user = new User();
		user.setUsername(registerForm.getUsername());
		user.setPassword(encodePwd);
		user.setEmail(registerForm.getEmail().toString());
		user.setUserid("1");
		user.setAccessTime(0);
		user.setFoundTime(Change.datetostr(new Date()));
		user.setIslogging("false");
		getUserDAO().insertUser(user);
	}
}
