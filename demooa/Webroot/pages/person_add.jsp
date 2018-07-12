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

<title><bean:message key="person_add.page.position" /></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is demo">
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
		<TD><bean:message key="person_add.page.position" /></TD>
		<TD align="right"><a href="person.do?method=back"><bean:message
			key="person_add.page.back" /></a></TD>
		<TD width="20"></TD>
	</TR>
</TABLE>
<form name="form1" action="person_add.do?method=insert" method="post">
<b><html:errors property="org.apache.struts.action.GLOBAL_MESSAGE" /></b>
<TABLE border="0" width="809">
	<TR>
		<TD><bean:message key="person.page.username" /></TD>
		<TD><logic:present name="personFormBean">
			<html:text property="username" name="personFormBean" maxlength="50"/>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="text" name="username" maxlength="50">
		</logic:notPresent>
		 <html:errors property="username" /></TD>
	</TR>
	<tr>
		<td><bean:message key="person.page.password1" /></td>
		<td><logic:present name="personFormBean">
			<html:password property="password1" name="personFormBean" />
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="password" name="password1">
		</logic:notPresent> <html:errors property="password1" /></td>
	</tr>
	<tr>
		<td><bean:message key="person.page.password2" /></td>
		<td><logic:present name="personFormBean">
			<html:password property="password2" name="personFormBean" />
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="password" name="password2">
		</logic:notPresent> <html:errors property="password2" /></td>
	</tr>
	<TR>
		<TD><bean:message key="person.page.name" /></TD>
		<TD><logic:present name="personFormBean">
			<html:text property="truename" name="personFormBean" maxlength="10"/>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="text" name="truename" maxlength="10">
		</logic:notPresent><html:errors property="truename" /></TD>
	</TR>
	<TR>
		<TD><bean:message key="person.page.sex" /></TD>
		<TD><logic:present name="personFormBean">
			<html:select property="sex" name="personFormBean">
			<html:option value="男"><bean:message key="person.page.man"/></html:option>
			<html:option value="女"><bean:message key="person.page.woman"/></html:option>
			</html:select>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="text" name="sex" maxlength="20">
		</logic:notPresent></TD>
	</TR>
	<TR>
		<TD><bean:message key="person.page.telphone" /></TD>
		<TD><logic:present name="personFormBean">
			<html:text property="telphone" name="personFormBean" maxlength="50"/>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="text" name="telphone" maxlength="50">
		</logic:notPresent> </TD>
	</TR>
	<TR>
		<TD><bean:message key="person.page.email" /></TD>
		<TD><logic:present name="personFormBean">
			<html:text property="email" name="personFormBean" maxlength="20"/>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="text" name="email" maxlength="20">
		</logic:notPresent><html:errors property="email" /></TD>
	</TR>
	<TR>
		<TD><bean:message key="person.page.job" /></TD>
		<TD><logic:present name="personFormBean">
			<html:text property="job" name="personFormBean" maxlength="100"/>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="text" name="job" maxlength="100">
		</logic:notPresent></TD>
	</TR>
	<TR>
		<TD><bean:message key="person.page.branch" /></TD>
		<TD><logic:present name="personFormBean">
			<html:text property="branch" name="personFormBean" maxlength="100"/>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="text" name="branch" maxlength="100">
		</logic:notPresent></TD>
	</TR>
	<TR>
		<TD><bean:message key="person.page.address" /></TD>
		<TD><logic:present name="personFormBean">
			<html:text property="address" name="personFormBean" maxlength="10"/>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="text" name="address" maxlength="10">
		</logic:notPresent></TD>
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
