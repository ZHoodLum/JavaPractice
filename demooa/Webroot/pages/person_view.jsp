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

<title><bean:message key="person_view.page.title" /></title>

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
<TABLE width="815" >
<tr>
<td width="809" class="td" valign="top">
<%if(!request.getParameter("view").equals("my")){%>
<TABLE width="809" class="position">
	<TR>
		<TD><bean:message key="person_view.page.position" /></TD>
		<TD align="right"><a href="person.do?method=back"><bean:message
			key="person_view.page.back" /></a></TD>
		<TD width="20"></TD>
	</TR>
</TABLE>
<%}%>
<logic:present name="personFormBean">
	<html:hidden property="id" name="personFormBean"/>
</logic:present>
<logic:notPresent name="personFormBean">
	<input type="hidden" name="id">
</logic:notPresent>
<logic:present name="personFormBean">
	<html:hidden property="password1" name="personFormBean"/>
</logic:present>
<logic:notPresent name="personFormBean">
	<input type="hidden" name="password1">
</logic:notPresent>
<logic:present name="personFormBean">
	<html:hidden property="password2" name="personFormBean"/>
</logic:present>
<logic:notPresent name="personFormBean">
	<input type="hidden" name="password2">
</logic:notPresent>
<logic:present name="personFormBean">
	<html:hidden property="accessTime" name="personFormBean"/>
</logic:present>
<logic:notPresent name="personFormBean">
	<input type="hidden" name="accessTime">
</logic:notPresent>
		
<TABLE border="0" width="809">
    <TR>
		<TD><bean:message key="person.page.username" /></TD>
		<TD><logic:present name="personFormBean">
			<html:text property="username" name="personFormBean"  style="border:0;" readonly="true"/>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="text" name="username" style="border:0;" readonly="true">
		</logic:notPresent>
		 <html:errors property="username" /></TD>
	</TR>
	<TR>
		<TD><bean:message key="person.page.userid" /></TD>
		<TD><logic:present name="personFormBean">
			<html:text property="userid" name="personFormBean"  style="border:0;" readonly="true"/>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="text" name="userid" style="border:0;" readonly="true">
		</logic:notPresent>
		 <html:errors property="userid" /></TD>
	</TR>
	<TR>
		<TD><bean:message key="person.page.name" /></TD>
		<TD><logic:present name="personFormBean">
			<html:text property="truename" name="personFormBean"  style="border:0;" readonly="true"/>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="text" name="truename" style="border:0;" readonly="true">
		</logic:notPresent>
		 <html:errors property="truename" /></TD>
	</TR>
	<TR>
		<TD><bean:message key="person.page.sex" /></TD>
		<TD><logic:present name="personFormBean">
			<html:text property="sex" name="personFormBean" style="border:0;" readonly="true"/>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="text" name="sex" style="border:0;" readonly="true">
		</logic:notPresent></TD>
	</TR>
	<TR>
		<TD><bean:message key="person.page.telphone" /></TD>
		<TD><logic:present name="personFormBean">
			<html:text property="telphone" name="personFormBean" style="border:0;" readonly="true"/>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="text" name="telphone" style="border:0;" readonly="true">
		</logic:notPresent></TD>
	</TR>
	<TR>
		<TD><bean:message key="person.page.email" /></TD>
		<TD><logic:present name="personFormBean">
			<html:text property="email" name="personFormBean" style="border:0;" readonly="true"/>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="text" name="email" style="border:0;" readonly="true">
		</logic:notPresent><html:errors property="email" /></TD>
	</TR>
	<TR>
		<TD><bean:message key="person.page.job" /></TD>
		<TD><logic:present name="personFormBean">
			<html:text property="job" name="personFormBean" style="border:0;" readonly="true"/>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="text" name="job" style="border:0;" readonly="true">
		</logic:notPresent></TD>
	</TR>
	<TR>
		<TD><bean:message key="person.page.branch" /></TD>
		<TD><logic:present name="personFormBean">
			<html:text property="branch" name="personFormBean" style="border:0;" readonly="true"/>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="text" name="branch" style="border:0;" readonly="true">
		</logic:notPresent></TD>
	</TR>
	<TR>
		<TD><bean:message key="person.page.address" /></TD>
		<TD><logic:present name="personFormBean">
			<html:text property="address" name="personFormBean" style="border:0;" readonly="true"/>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="text" name="address" style="border:0;" readonly="true">
		</logic:notPresent></TD>
	</TR>
	<TR>
		<TD><bean:message key="person.page.foundtime" /></TD>
		<TD><logic:present name="personFormBean">
			<html:text property="foundTime" name="personFormBean" style="border:0;" readonly="true"/>
		</logic:present> <logic:notPresent name="personFormBean">
			<input type="text" name="foundTime" style="border:0;" readonly="true">
		</logic:notPresent></TD>
	</TR>
</TABLE>
</td>
</tr>
</TABLE>
<%} %>
</body>
</html>
