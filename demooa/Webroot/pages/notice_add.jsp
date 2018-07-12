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

<title><bean:message key="notice_add.page.position" /></title>

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
		<TD><bean:message key="notice_add.page.position" /></TD>
		<TD align="right"><a href="notice.do?method=back"><bean:message
			key="notice_add.page.back" /></a></TD>
		<TD width="20"></TD>
	</TR>
</TABLE>
<form name="form1" action="notice_add.do?method=insert" method="post">
<b><html:errors property="org.apache.struts.action.GLOBAL_MESSAGE" /></b>
<TABLE border="0" width="809">
	<TR>
		<TD><bean:message key="notice.page.title" /></TD>
		<TD><logic:present name="noticeFormBean">
			<html:text property="title" name="noticeFormBean" maxlength="100"/>
		</logic:present> <logic:notPresent name="noticeFormBean">
			<input type="text" name="title" maxlength="100">
		</logic:notPresent> <html:errors property="title" /></TD>
	</TR>
	<TR>
		<TD><bean:message key="notice.page.content" /></TD>
		<TD><textarea name="content" cols="60" rows="15"><logic:present name="noticeFormBean"><bean:write property="content" name="noticeFormBean" /></logic:present></textarea>  <html:errors property="content" /></TD>
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
