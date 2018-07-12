package com.struts.forms;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class NoticeForm extends ActionForm {
	
	private static final long serialVersionUID = 2055895427002620981L;

	protected String id = null;

	protected String sender = null;

	protected String title = null;

	protected String content = null;

	protected String sendtime = null;
	
	protected String isread = null;

	public String getIsread() {
		return isread;
	}

	public void setIsread(String isread) {
		this.isread = isread;
	}

	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
		ActionErrors errors = new ActionErrors();
		String queryString = arg1.getQueryString();
		if (queryString.equalsIgnoreCase("method=insert")
				|| queryString.equalsIgnoreCase("method=update")) {
			if (title == null || title.equals("")) {
				errors.add("title", new ActionMessage("notice.error.title"));
			}

			if (content == null || content.equals("")) {
				errors.add("content", new ActionMessage("notice.error.content"));
			}
		}
		arg1.setAttribute("noticeFormBean", this);
		return errors;
	}

	public String getSendtime() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");			
		sendtime = f.format(new Date());
		return sendtime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
