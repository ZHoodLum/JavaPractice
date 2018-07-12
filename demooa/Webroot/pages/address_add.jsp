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

<title><bean:message key="address_add.page.position" /></title>
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
		<TD><bean:message key="address_add.page.position" /></TD>
		<TD align="right"><a href="address.do?method=back"><bean:message
			key="address_add.page.back" /></a></TD>
		<TD width="20"></TD>
	</TR>
</TABLE>
<form name="form1" action="address_add.do?method=insert" method="post">
<b><html:errors property="org.apache.struts.action.GLOBAL_MESSAGE" /></b>
<TABLE border="0" width="809">
	<TR>
		<TD><bean:message key="address.page.name" /></TD>
		<TD><logic:present name="addressFormBean">
			<html:text property="name" name="addressFormBean" maxlength="50"/>
		</logic:present> <logic:notPresent name="addressFormBean">
			<input type="text" name="name" maxlength="50">
		</logic:notPresent>
		 <html:errors property="name" /></TD>
	</TR>
	<TR>
		<TD><bean:message key="address.page.sex" /></TD>
		<TD><logic:present name="addressFormBean">
			<html:text property="sex" name="addressFormBean" maxlength="10"/>
		</logic:present> <logic:notPresent name="addressFormBean">
			<input type="text" name="sex" maxlength="10">
		</logic:notPresent></TD>
	</TR>
	<TR>
		<TD><bean:message key="address.page.mobile" /></TD>
		<TD><logic:present name="addressFormBean">
			<html:text property="mobile" name="addressFormBean" maxlength="20"/>
		</logic:present> <logic:notPresent name="addressFormBean">
			<input type="text" name="mobile" maxlength="20">
		</logic:notPresent> <html:errors property="mobile" /></TD>
	</TR>
	<TR>
		<TD><bean:message key="address.page.email" /></TD>
		<TD><logic:present name="addressFormBean">
			<html:text property="email" name="addressFormBean" maxlength="50"/>
		</logic:present> <logic:notPresent name="addressFormBean">
			<input type="text" name="email" maxlength="50">
		</logic:notPresent> <html:errors property="email" /></TD>
	</TR>
	<TR>
		<TD><bean:message key="address.page.qq" /></TD>
		<TD><logic:present name="addressFormBean">
			<html:text property="qq" name="addressFormBean" maxlength="20"/>
		</logic:present> <logic:notPresent name="addressFormBean">
			<input type="text" name="qq" maxlength="20">
		</logic:notPresent></TD>
	</TR>
	<TR>
		<TD><bean:message key="address.page.company" /></TD>
		<TD><logic:present name="addressFormBean">
			<html:text property="company" name="addressFormBean" maxlength="100"/>
		</logic:present> <logic:notPresent name="addressFormBean">
			<input type="text" name="company" maxlength="100">
		</logic:notPresent></TD>
	</TR>
	<TR>
		<TD><bean:message key="address.page.address" /></TD>
		<TD><logic:present name="addressFormBean">
			<html:text property="address" name="addressFormBean" maxlength="100"/>
		</logic:present> <logic:notPresent name="addressFormBean">
			<input type="text" name="address" maxlength="100">
		</logic:notPresent></TD>
	</TR>
	<TR>
		<TD><bean:message key="address.page.postcode" /></TD>
		<TD><logic:present name="addressFormBean">
			<html:text property="postcode" name="addressFormBean" maxlength="10"/>
		</logic:present> <logic:notPresent name="addressFormBean">
			<input type="text" name="postcode" maxlength="10">
		</logic:notPresent> <html:errors property="postcode" /></TD>
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
