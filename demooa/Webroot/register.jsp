<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title><bean:message key="register.page.title" /></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is demo">

<!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>

<body>

<form name="form1" action="register.do?method=register" method="post">
<table width="300" border="1">
	<tr>
		<td colspan="2"><bean:message key="register.page.title" /></td>
	</tr>
	<tr>
		<td><bean:message key="register.page.username" /></td>
		<td><logic:present name="registerFormBean">
			<html:text property="username" name="registerFormBean" />
		</logic:present> <logic:notPresent name="registerFormBean">
			<input type="text" name="username">
		</logic:notPresent> <html:errors property="username" /></td>
	</tr>
	<tr>
		<td><bean:message key="register.page.password1" /></td>
		<td><logic:present name="registerFormBean">
			<html:password property="password1" name="registerFormBean" />
		</logic:present> <logic:notPresent name="registerFormBean">
			<input type="password" name="password1">
		</logic:notPresent> <html:errors property="password1" /></td>
	</tr>
	<tr>
		<td><bean:message key="register.page.password2" /></td>
		<td><logic:present name="registerFormBean">
			<html:password property="password2" name="registerFormBean" />
		</logic:present> <logic:notPresent name="registerFormBean">
			<input type="password" name="password2">
		</logic:notPresent> <html:errors property="password2" /></td>
	</tr>
	<tr>
		<td><bean:message key="register.page.email" /></td>
		<td><logic:present name="registerFormBean">
			<html:text property="email" name="registerFormBean" />
		</logic:present> <logic:notPresent name="registerFormBean">
			<input type="text" name="email">
		</logic:notPresent> <html:errors property="email" /></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" name="submit"
			value='<bean:message key="register.page.register" />'> <a
			href="index.do"><bean:message key="register.page.back" /></a></td>
	</tr>
</table>
<html:errors property="org.apache.struts.action.GLOBAL_MESSAGE" /></form>

</body>
</html>
