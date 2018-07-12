package com.struts.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.actions.DispatchAction;

import com.struts.util.Constants;

public class BaseAction extends DispatchAction {
	
	/**
	 * get username from session
	 * @param request
	 * @return
	 */
	protected String getUsername(HttpServletRequest request) {
		return (String) request.getSession().getAttribute(
				Constants.USERNAME_KEY);
	}
	
	/**
	 * check if user is timeout
	 * @param request
	 * @return
	 */
	protected boolean isTimeout(HttpServletRequest request) {
		if (request.getSession().getAttribute(Constants.USERNAME_KEY) == null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * save object in session
	 * @param request
	 * @param key
	 * @param obj
	 */
	protected void setSession(HttpServletRequest request, String key, Object obj) {
		request.getSession().setAttribute(key, obj);
	}
	
	/*
	 * check if obj exists in session
	 */
	protected boolean isExistSession(HttpServletRequest request, String key) {
		if (request.getSession().getAttribute(key) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * get object from session
	 * @param request
	 * @param key
	 * @return
	 */
	protected Object getSession(HttpServletRequest request, String key) {
		return request.getSession().getAttribute(key);
	}
}
