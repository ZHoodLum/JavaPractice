<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested"%>
<%@ page import="com.struts.util.Constants"%>
<%@ page import="com.struts.util.UserInfoList"%>
<%@ page import="com.struts.util.UserInfoTrace"%>
<%@ page import="com.struts.util.SessionCounter" %> 
<%@ page import="java.util.*"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>

<html>
<head>
<title>DEMO OA - <decorator:title default="Welcome!" /></title>
<link rel="stylesheet" type="text/css" href="styles.css">
<!-- <meta http-equiv="refresh" content="30"> -->
<decorator:head />
</head>
<script type="text/javascript">
function clockon(bgclock){
	var now=new Date();
	var year=now.getYear();
	var month=now.getMonth();
	var date=now.getDate();
	var day=now.getDay();
	var hour=now.getHours();
	var minu=now.getMinutes();
	var sec=now.getSeconds();
	var week;
	month=month+1;
	if(month<10) month="0"+month;
	if(date<10) date="0"+date;
	if(hour<10) hour="0"+hour;
	if(minu<10) minu="0"+minu;
	if(sec<10) sec="0"+sec;
	var arr_week=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
	week=arr_week[day];
	var time="";
	time=year+"年"+month+"月"+date+"日 "+week+" "+hour+":"+minu+":"+sec;
	if(document.all){
		bgclock.innerHTML="["+time+"]"
	}
	var timer=setTimeout("clockon(bgclock)",200);
}
</script>
<body onLoad="clockon(bgclock)">
<div align="center">
<%if (session.getAttribute(Constants.USERNAME_KEY) != null) {%>
<table  width="1024" height="115" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td><img src="images/top_01.jpg" width="786" height="115" alt=""></td>
		<td><a href="welcome.do"><img src="images/top_02.jpg" width="107" height="115" border="0" ></a></td>
		<td><a href='logout.do'><img src="images/top_03.jpg" width="131" height="115" border="0"></a></td>
	</tr>
</table>
<table width="1024"  background="images/bg1.gif" ><!--DWLayoutTable-->
	<tr>
	  	<td colspan="2" valign="top" align="left"></td>
   	</tr>
	<tr >
		<td  valign="top"   >
		<table width="187" border="0" class="td" style="margin-left:5px;" >
		  <tr>
		     <td colspan="2" height="5"></td>
		  </tr>
		  <tr>
		     <td colspan="2" id="bgclock" align="center" ></td>
		  </tr>
		  <tr>
		     <td colspan="2" width="200" height="1" align="center" bgcolor="#1D93DD"></td>
		  </tr>
		  <tr>
		     <td colspan="2" height="5"></td>
		  </tr>
          	  <tr>
		     <td colspan="2" align="center"><B><bean:message key="welcome.page.title"/></B>
		     <b><a href='logout.do'><bean:message key="welcome.page.logout" /></a></b></td>
		  </tr>
		  <tr>
		     <td colspan="2" height="5"></td>
		  </tr>
	      <tr>
	         <td width="30"></td>
		     <td ><bean:message key="welcome.page.welcome" />
		     <b><%=(String) session.getAttribute("username")%></b></td>
	      </tr>
	      <tr>
	         <td width="30"></td>
		     <td ><bean:message key="welcome.page.myid" />
		     <%=(String) session.getAttribute("userid")%></td>
	      </tr>
	      <tr >
	         <td width="30"></td>
		     <td><bean:message key="welcome.page.myjob" />
		     <%=(String) session.getAttribute("job")%></td>
	      </tr>
	      <tr >
	         <td width="30"></td>
		     <td><bean:message key="welcome.page.mytimes" />
		     <%=(String) session.getAttribute("accesstime")%></td>
	      </tr>
	      <tr>
             <td height="5" bordercolor="#C7D9E7"></td>
          </tr>
          <tr>
             <td colspan="2" align="center">
		     <b><a href='person_view.do?method=view&username=<%=(String) session.getAttribute("username")%>&view=my'>
		     <bean:message key="welcome.page.viewinfo" />
		     </a>
		     </b>
		     <b><a href='person_edit.do?method=edit&username=<%=(String) session.getAttribute("username")%>&update=my'>
		     <bean:message key="welcome.page.updateinfo" />
		     </a>
		     </b>
	      </td>
          </tr>
        </table>
        <table height="10"><tr><td></td></tr></table>
		
        <div id="menu"  style="margin-left:5px;">
        <ul>
			<li><a href="welcome.do"><bean:message key="frame.main" /></a></li>
			<li><a href="address.do?method=list"><bean:message key="frame.address" /></a></li>
			<%if (!session.getAttribute(Constants.USERID_KEY).equals(Constants.NORMALUSER)) {%>
			<li><a href="person.do?method=list"><bean:message key="frame.person" /></a></li>
			<%} %>
			<li><a href="schedule.do?method=list"><bean:message key="frame.schedule" /></a></li>
			<li><a href="worklog.do?method=list"><bean:message key="frame.worklog" /></a></li>
			<li><a href="notice.do?method=list"><bean:message key="frame.notice" /></a></li>
		</ul>
        </div>
        </td>
		<td align="left" valign="top"><decorator:body /></td>
	</tr>
</table>
<%} else {%> <decorator:body /> <%}%>
<%if (session.getAttribute(Constants.USERNAME_KEY) != null) {%>
<table width="1018" class="td">
<td width="1018" align="center">
<hr>
This is demo
</td>
</table>
<%} %>
</div>
</body>
</html>
