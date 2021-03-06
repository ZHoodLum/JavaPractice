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

<title><bean:message key="schedule.page.title" /></title>

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
		<TD><bean:message key="schedule.page.position" /></TD>
		<TD align="right"><a href="schedule_add.do?method=add"><bean:message key="schedule.page.add" /></a></TD>
		<TD width="20"></TD>
	</TR>
</TABLE>
<b><html:errors property="org.apache.struts.action.GLOBAL_MESSAGE" /></b>
<TABLE border="0" width="809">
	<TR class="tableheader">
		<TD><bean:message key="schedule.page.year" /></TD>
		<TD><bean:message key="schedule.page.month" /></TD>
		<TD><bean:message key="schedule.page.day" /></TD>
		<TD><bean:message key="schedule.page.plan" /></TD>
		<TD><bean:message key="button.operation" /></TD>
	</TR>
	<logic:present name="scheduleList">
	<logic:iterate id="schedule" name="scheduleList" scope="request">
	<TR>
		<TD><bean:write name="schedule" property="year" scope="page"/></TD>
		<TD><bean:write name="schedule" property="month" scope="page"/></TD>
		<TD><bean:write name="schedule" property="day" scope="page"/></TD>
		<TD><bean:write name="schedule" property="plan" scope="page"/></TD>
		<TD><a href='schedule_view.do?method=view&id=<bean:write name="schedule" property="id" scope="page"/>'><bean:message key="button.view" /></a>
		<a href='schedule_edit.do?method=edit&id=<bean:write name="schedule" property="id" scope="page"/>'><bean:message key="button.edit" /></a>
		<a href="schedule.do?method=delete&id=<bean:write name="schedule" property="id" scope="page"/>"><bean:message key="button.delete" /></a></TD>
	</TR>
	</logic:iterate>
	</logic:present>
</TABLE>

<logic:present name="pager">
<form name="form1" action="schedule.do?method=list" method="post">
<TABLE border="0" width="809" class="pager">
	<tr><td colspan="4" width="809" height="2" align="center" bgcolor="#1D93DD"></td></tr>
	<TR>
		<TD align="left"><bean:message key="pager.pageSize" />
			<html:select name="pager" property="pageSize" onchange="document.all.pageNo.value='1';document.all.form1.submit();">
				<logic:notEmpty name="pager" scope="request">
					<html:options name="pager" property="pageSizeIndexs" />
				</logic:notEmpty>
			</html:select>
		</TD>
		<TD align="center">
		<bean:message key="pager.rowCount" /><bean:write name="pager" property="rowCount" />
		</TD>
		<TD align="right">
			<a href="javascript:document.all.pageNo.value='<bean:write name="pager" property="firstPageNo" />';document.all.form1.submit();"><bean:message key="pager.firstPageNo" /></a>
			<a href="javascript:document.all.pageNo.value='<bean:write name="pager" property="prePageNo" />';document.all.form1.submit();"><bean:message key="pager.prePageNo" /></a>
			<a href="javascript:document.all.pageNo.value='<bean:write name="pager" property="nextPageNo" />';document.all.form1.submit();"><bean:message key="pager.nextPageNo" /></a>
			<a href="javascript:document.all.pageNo.value='<bean:write name="pager" property="lastPageNo" />';document.all.form1.submit();"><bean:message key="pager.lastPageNo" /></a>
			<html:select name="pager" property="pageNo" onchange="document.all.form1.submit();">
				<logic:notEmpty name="pager" scope="request">
					<html:options name="pager" property="pageNoIndexs" />
				</logic:notEmpty>
			</html:select>
		</TD>
		<TD width="20"></TD>
	
	</TR>
</TABLE>
</form>
</logic:present>
</td>
</tr>
</TABLE>
<%} %>
</body>
</html>
