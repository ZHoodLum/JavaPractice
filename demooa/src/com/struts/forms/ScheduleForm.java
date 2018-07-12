package com.struts.forms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.struts.util.RegExpression;

public class ScheduleForm extends ActionForm {

	private static final long serialVersionUID = 3903289838409303062L;

	protected String id = null;

	protected String username = null;

	protected String year = null;

	protected String month = null;

	protected String day = null;

	protected String plan = null;

	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
		ActionErrors errors = new ActionErrors();
		String queryString = arg1.getQueryString();
		if (queryString.equalsIgnoreCase("method=insert")
				|| queryString.equalsIgnoreCase("method=update")) {
			Pattern p_year = Pattern.compile(RegExpression.REG_year);
			Matcher m_year = p_year.matcher(year);
			if (!m_year.find()) {
				errors.add("year", new ActionMessage("schedule.error.year"));
			}

			Pattern p_month = Pattern.compile(RegExpression.REG_month);
			Matcher m_month = p_month.matcher(month);
			if (!m_month.find()) {
				errors.add("month", new ActionMessage("schedule.error.month"));
			}

			Pattern p_day = Pattern.compile(RegExpression.REG_day);
			Matcher m_day = p_day.matcher(day);
			if (!m_day.find()) {
				errors.add("day", new ActionMessage("schedule.error.day"));
			}

			if (plan == null || plan.equals("")) {
				errors.add("plan", new ActionMessage("schedule.error.plan"));
			}
		}
		arg1.setAttribute("scheduleFormBean", this);
		return errors;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
