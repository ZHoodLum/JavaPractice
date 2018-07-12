package com.struts.forms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.struts.util.RegExpression;

public class AddressForm extends ActionForm {

	private static final long serialVersionUID = -9064004131486821122L;
	
//	定义表中字段对应的类属性
	private String name;
	private String mobile;
	private String email;
	private String postcode;
	private String id;
	private String sex;
	private String qq;
	private String company;
	private String address;
	
//	添加get和set方法
	public String getId() {
		return id;
	}

	public void setId(String string) {
		this.id = string;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
		ActionErrors errors = new ActionErrors();
		String queryString = arg1.getQueryString();
		if (queryString.equalsIgnoreCase("method=insert")
				|| queryString.equalsIgnoreCase("method=update")) {
			//check name
			if (name == null || name.equals("")) {
				errors.add("name", new ActionMessage("address.error.name"));
			}
			
			//check mobile
			if (mobile != null && !mobile.equals("")) {
				Pattern p_mobile = Pattern.compile(RegExpression.REG_mobile);
				Matcher m_mobile = p_mobile.matcher(mobile);
				if (!m_mobile.find()) {
					errors.add("mobile", new ActionMessage("address.error.mobile"));
				}
			}
			
			//check email
			if (email != null && !email.equals("")) {
				Pattern p_email = Pattern.compile(RegExpression.REG_email);
				Matcher m_email = p_email.matcher(email);
				if (!m_email.find()) {
					errors.add("email", new ActionMessage("address.error.email"));
				}
			}
			
			//check postcode
			if (postcode != null && !postcode.equals("")) {
				Pattern p_postcode = Pattern.compile(RegExpression.REG_postcode);
				Matcher m_postcode = p_postcode.matcher(postcode);
				if (!m_postcode.find()) {
					errors.add("postcode", new ActionMessage("address.error.postcode"));
				}
			}
		}
		arg1.setAttribute("addressFormBean", this);
		return errors;
	}
}
