<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<html:html locale = "true"/> 
<%String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title><bean:message key="schedule_edit.page.title" /></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is demo">
<link rel="stylesheet" type="text/css" href="styles.css">
</head>

<body>
<%
  if(session.getAttribute("username")==null){
	  response.sendRedirect(path+"/error.jsp");
  }
  else{
%>
<TABLE width="815" valign="top">
<tr>
<td width="809" class="td" valign="top">
<TABLE width="809" class="position">
	<TR>
		<TD><bean:message key="schedule_edit.page.position" /></TD>
		<TD align="right"><a href="schedule.do?method=back"><bean:message
			key="schedule_edit.page.back" /></a></TD>
		<TD width="20"></TD>
	</TR>
</TABLE>
<form name="form1" action="schedule_edit.do?method=update" method="post">
<b><html:errors property="org.apache.struts.action.GLOBAL_MESSAGE" /></b>

<logic:present name="scheduleFormBean">
	<html:hidden property="id" name="scheduleFormBean"/>
</logic:present>
<logic:notPresent name="scheduleFormBean">
	<input type="hidden" name="id">
</logic:notPresent>
		
<TABLE border="0" width="809">
	<TR>
		<TD><bean:message key="schedule.page.year" /></TD>
		<TD><logic:present name="scheduleFormBean">
			<html:text property="year" name="scheduleFormBean" maxlength="4"/>
		</logic:present> <logic:notPresent name="scheduleFormBean">
			<input type="text" name="year" maxlength="4">
		</logic:notPresent> <html:errors property="year" /></TD>
	</TR>
	<TR>
		<TD><bean:message key="schedule.page.month" /></TD>
		<TD><logic:present name="scheduleFormBean">
			<html:text property="month" name="scheduleFormBean" maxlength="2"/>
		</logic:present> <logic:notPresent name="scheduleFormBean">
			<input type="text" name="month" maxlength="2">
		</logic:notPresent> <html:errors property="month" /></TD>
	</TR>
	<TR>
		<TD><bean:message key="schedule.page.day" /></TD>
		<TD><logic:present name="scheduleFormBean">
			<html:text property="day" name="scheduleFormBean" maxlength="2"/>
		</logic:present> <logic:notPresent name="scheduleFormBean">
			<input type="text" name="day" maxlength="2">
		</logic:notPresent> <html:errors property="day" /></TD>
	</TR>
	<TR>
		<TD><bean:message key="schedule.page.plan" /></TD>
		<TD><textarea name="plan" cols="60" rows="15"><logic:present name="scheduleFormBean"><bean:write property="plan" name="scheduleFormBean" /></logic:present></textarea>  <html:errors property="plan" /></TD>
	</TR>
	<TR>
		<TD colspan="2"><input type="submit"
			value="<bean:message key='button.submit' />"></TD>
	</TR>
</TABLE>
</form>
</td>
</tr>
</TABLE>
<%} %>
</body>
</html>
