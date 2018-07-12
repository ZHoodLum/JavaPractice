package com.struts.util;

public class Constants {
	// session username
	public final static String USERNAME_KEY = "username";
	public final static String ACCESSTIME_KEY="accesstime";
	public final static String TRUENAME_KEY="truename";
	public final static String USERID_KEY="userid";
	public final static String SYSTEMMANAGER="系统管理员";
	public final static String NORMALUSER="普通用户";
	public final static String ISLOGGING="islogging";
	public final static String JOB_KEY="job";
	public final static String SMSCOUNT="smscount";
	public final static String NOTICECOUNT="noticecount";
	public final static String MEETINGCOUNT="meetingcount";
	public final static String YES="是";
	public final static String NO="否";
	public final static String PLEASElOGIN="您还没有登录！！！";
	//public final static String LASTTIME="lasttime";
	//public final static String CURRENTTIME="currenttime";

	// struts mapping
	public final static String SUCCESS_KEY = "success";
	public final static String FAILURE_KEY = "failure";
	public final static String LOGOUT_KEY = "logout";

	public final static String INDEX_KEY = "index";
	public final static String LIST_KEY = "list";
	public final static String ADD_KEY = "add";
	public final static String EDIT_KEY = "edit";
	public final static String VIEW_KEY = "view";
	public final static String DOWNLOAD_KEY = "download";
	public final static String UP_KEY="up";
	public final static String WELCOME_KEY="mywelcome";
	
	// pager default parameters
	public final static int pageSize = 25;
	public final static int pageNo =1;
	public static final int MAXLENGTH=2*1024*1024;
	
	// pager session
	public final static String PAGER_ADDRESS = "pager_address";
	public final static String PAGER_UPFILE="pager_upfile";
	public final static String PAGER_PERSON="pager_person";
	public final static String PAGER_SCHEDULE = "pager_schedule";
	public final static String PAGER_WORKLOG = "pager_worklog";
	public final static String PAGER_SMS = "pager_sms";
	public final static String PAGER_NOTICE = "pager_notice";
	public final static String PAGER_MEETING = "pager_meeting";

}
