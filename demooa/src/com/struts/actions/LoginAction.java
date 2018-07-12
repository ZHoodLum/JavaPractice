package com.struts.actions;

import java.util.Date;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.actions.DispatchAction;

import com.hibernate.beans.User;
import com.hibernate.dao.UserDAO;
import com.struts.forms.LoginForm;
import com.struts.util.Change;
import com.struts.util.Constants;
import com.struts.util.MD5;
import com.struts.util.CheckStr;
import com.struts.util.UserInfoList;
import com.struts.util.UserInfoTrace;

public class LoginAction extends DispatchAction {

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

		ActionMessages messages = new ActionMessages();
		ActionForward forward = new ActionForward();
		LoginForm loginForm = (LoginForm) form;

		try {
			// get parameters
			String username = loginForm.getUsername();
			HttpSession session = request.getSession();
			boolean b=false;
			String checkcode=(String)session.getAttribute("checkcode");
			if(checkcode.equals(loginForm.getValcode()))
			{
				b=true;
			}
			// invalidate the original session if exists
			if (session != null) {
				session.invalidate();
			}

			// create a new session for the user
			session = request.getSession(true);

			// login
			boolean isValid = valid(request, loginForm);
			if (isValid==true && b==true) {
				User user = userDAO.findByUsername(username);
				user.setAccessTime(user.getAccessTime()+1);
				user.setIslogging("true");
				userDAO.updateUser(user);
				//Sms sms=smsDAO.findById(user.getId().toString());
				//Notice notice=noticeDAO.findById(user.getId().toString());
				//Meeting meeting=meetingDAO.findById(user.getId().toString());
				//int smsCount=smsDAO.getCount(username,"false");
				//int noticeCount=noticeDAO.getCount("false");
				//int meetingCount=meetingDAO.getCount("false");
				session.setAttribute(Constants.USERNAME_KEY, username);
				session.setAttribute(Constants.ACCESSTIME_KEY, user.getAccessTime().toString());
				session.setAttribute(Constants.TRUENAME_KEY, user.getTruename());
				session.setAttribute(Constants.JOB_KEY, user.getJob());
				//session.setAttribute(Constants.LASTTIME, Change.datetostr(new Date()));
				//session.setAttribute(Constants.SMSCOUNT, Change.inttostr(smsCount));
				//session.setAttribute(Constants.NOTICECOUNT, Change.inttostr(noticeCount));
				//session.setAttribute(Constants.MEETINGCOUNT, Change.inttostr(meetingCount));
				String userid=null;
				if(user.getUserid().equals("0"))
				{
					userid=Constants.SYSTEMMANAGER;
				}
				else if(user.getUserid().equals("1"))
				{
					userid=Constants.NORMALUSER;
				}
				session.setAttribute(Constants.USERID_KEY, userid);
				session.removeAttribute("checkcode");

				log.info("User " + username + " login.");
			}
			else if(isValid==true && b==false)
			{
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"login.message.valcode"));
			}
			else if(isValid==false && b==true)
			{
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"login.message.failed"));
			}

		} catch (Exception e) {
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"login.message.failed"));

		}

		// If a message is required, save the specified key(s)
		// into the request for use by the <struts:errors> tag.

		if (!messages.isEmpty()) {
			saveErrors(request, messages);
			request.setAttribute("loginFormBean", loginForm);
			forward = mapping.findForward(Constants.FAILURE_KEY);
		} else {
			forward = mapping.findForward(Constants.SUCCESS_KEY);
		}

		// Finish with
		return (forward);
	}
	private boolean valid(HttpServletRequest request, LoginForm loginForm) 
	{
		MD5 myMd5=new MD5();
		String decodePwd=myMd5.getMD5ofStr(loginForm.getPassword());
		CheckStr check=new CheckStr();
		String username=check.dostring(loginForm.getUsername());
		if (getUserDAO().isValid(username,decodePwd)) {
			return true;
		} else {
			return false;
		}
	}
	/*
	public Vector getUsers(HttpServletRequest request, String username)
	{
		HttpSession session = request.getSession();
		UserInfoList list=UserInfoList.getInstance();
		UserInfoTrace ut=new UserInfoTrace();
		String name=request.getParameter("username");
		boolean b=false;
		if(list.getList().size()!=0)
		{
			for(int i=0;i<list.getList().size();i++)
			{
				if(!name.equals(list.getList().elementAt(i)))
				{
					System.out.println("此用户名已存在！！！");
					b=true;
					break;
				}
				else
				{
					b=false;
				}
			}
		}
		if(!b)
		{
			ut.setUser(name);
			session.setAttribute("list",ut);
			list.addUserInfo(ut.getUser());
		}
		//session.setMaxInactiveInterval(10);
		Vector vector=list.getList();
		return vector;
	}*/
}
