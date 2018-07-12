package com.struts.forms;

import org.apache.struts.action.ActionForm;

import com.struts.util.Constants;

public class PageForm extends ActionForm {

	private static final long serialVersionUID = 219028730349872490L;

	protected int pageSize = Constants.pageSize;
	
	protected int pageNo = Constants.pageNo;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}	
}
