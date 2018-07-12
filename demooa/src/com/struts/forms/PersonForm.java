package com.struts.forms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.struts.util.RegExpression;

public class PersonForm extends ActionForm{

	private static final long serialVersionUID = -9064004131486821122L;

	protected String id = null;
	
	protected String username = null;
	
	protected String userid=null;

	protected String password1 = null;
	
	protected String password2 = null;
	
	protected String truename=null;
	
	protected String email=null;
	
	protected String address=null;
	
	protected String telphone=null;
	
	protected String sex=null;
	
	protected String job=null;
	
	protected String branch=null;
	
	protected String accessTime=null;
	
	protected String foundTime=null;
	
	protected String islogging=null;
	
	protected String myupdate=null;
	
	public String getMyupdate() {
		return myupdate;
	}

	public void setMyupdate(String myupdate) {
		this.myupdate = myupdate;
	}

	public String getIslogging() {
		return islogging;
	}

	public void setIslogging(String islogging) {
		this.islogging = islogging;
	}

	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
		ActionErrors errors = new ActionErrors();		
		String queryString = arg1.getQueryString();
		if (queryString.equalsIgnoreCase("method=insert")) {
			if (username == null || username.equals("")) {
				errors.add("username", new ActionMessage(
						"person.error.username"));
			}
			if (password1 == null
					|| password1.equals("")) {
				errors.add("password1", new ActionMessage(
						"person.error.password1"));
			}
			if (password2 == null
					|| !password2.equals(password1)) {
				errors.add("password2", new ActionMessage(
						"person.error.password2"));
			}
			
			if (truename == null
					|| truename.equals("")) {
				errors.add("truename", new ActionMessage(
						"person.error.truename"));
			}
			
			Pattern pattern = Pattern.compile(RegExpression.REG_email);
			Matcher m = pattern.matcher(email);
			if(!m.find()) {
				errors.add("email", new ActionMessage(
				"person.error.email"));
			}
		}
		arg1.setAttribute("personFormBean", this);
		return errors;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	};

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(String accessTime) {
		this.accessTime = accessTime;
	}

	public String getFoundTime() {
		return foundTime;
	}

	public void setFoundTime(String foundTime) {
		this.foundTime = foundTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
}
