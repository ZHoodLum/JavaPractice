package com.struts.forms;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.struts.util.RegExpression;

public class WorklogForm extends ActionForm {

	private static final long serialVersionUID = -6097073658043518959L;

	protected String id = null;

	protected String username = null;

	protected String year = null;

	protected String month = null;

	protected String day = null;

	protected String title = null;

	protected String description = null;

	protected String logtime = null;

	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
		ActionErrors errors = new ActionErrors();
		String queryString = arg1.getQueryString();
		if (queryString.equalsIgnoreCase("method=insert")
				|| queryString.equalsIgnoreCase("method=update")) {
			Pattern p_year = Pattern.compile(RegExpression.REG_year);
			Matcher m_year = p_year.matcher(year);
			if (!m_year.find()) {
				errors.add("year", new ActionMessage("worklog.error.year"));
			}

			Pattern p_month = Pattern.compile(RegExpression.REG_month);
			Matcher m_month = p_month.matcher(month);
			if (!m_month.find()) {
				errors.add("month", new ActionMessage("worklog.error.month"));
			}

			Pattern p_day = Pattern.compile(RegExpression.REG_day);
			Matcher m_day = p_day.matcher(day);
			if (!m_day.find()) {
				errors.add("day", new ActionMessage("worklog.error.day"));
			}

			if (title == null || title.equals("")) {
				errors.add("title", new ActionMessage("worklog.error.title"));
			}

			if (description == null || description.equals("")) {
				errors.add("description", new ActionMessage("worklog.error.description"));
			}
		}
		arg1.setAttribute("worklogFormBean", this);
		return errors;
	}

	public String getLogtime() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");			
		logtime = f.format(new Date());
		return logtime;
	}

	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	
}
