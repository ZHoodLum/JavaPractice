package com.struts.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginForm extends ActionForm {

	private static final long serialVersionUID = -8028907637588473959L;

	protected String username = null;

	protected String password = null;
	
	protected String email=null;
	
	protected String valcode=null;
	
	protected String userid=null;
	
	protected String islogging=null;

	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
		ActionErrors errors = new ActionErrors();
		if (username == null || username.equals("")) {
			errors.add("username", new ActionMessage(
					"login.error.username"));
		}
		if (password == null || password.equals("")) {
			errors.add("password", new ActionMessage(
					"login.error.password"));
		}
		if (valcode==null || valcode.equals("")){
			errors.add("valcode", new ActionMessage(
			"login.error.valcode"));
		}
		arg1.setAttribute("loginFormBean", this);
		return errors;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getValcode() {
		return valcode;
	}

	public void setValcode(String valcode) {
		this.valcode = valcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getIslogging() {
		return islogging;
	}

	public void setIslogging(String islogging) {
		this.islogging = islogging;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}
