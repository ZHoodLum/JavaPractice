package com.struts.actions;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.hibernate.beans.User;
import com.hibernate.dao.UserDAO;
import com.struts.util.Constants;
import com.struts.util.UserInfoList;
import com.struts.util.UserInfoTrace;

public class LogoutAction extends DispatchAction {

	protected UserDAO userDAO;

	Logger log = Logger.getLogger(this.getClass());

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward();

		// invalidate the original session if exists
		HttpSession session = request.getSession(false);
		String username = (String)session.getAttribute(Constants.USERNAME_KEY);
		if (session != null) {
			User user = userDAO.findByUsername(username);
			//user.setIslogging("false");
			userDAO.updateUser(user);
			log.info("User " + username + " delete.");
			session.removeAttribute(Constants.USERNAME_KEY);
			session.invalidate();
		}
		else if(session == null)
		{
			forward = mapping.findForward(Constants.LOGOUT_KEY);
		}
		
		log.info("User " + username + " logout.");

		forward = mapping.findForward(Constants.LOGOUT_KEY);

		// Finish with
		return (forward);
	}
}
