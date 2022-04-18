<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page session="false"%>
<!-- session="false" 일때 사용하는 코드 -->
<c:set var="loginId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : 'ID='+=loginId}"/>
 
 <!-- session 사용할때 코드
<c:set var="loginOutLink" value="${sessionScope.id==null ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${sessionScope.id==null ? 'Login' : 'Logout'}"/>
 -->
 
<!-- Darren -->

<!-- 음 일단 대충 보아하니.....
request객체에거 직접 session얻어서 getAttribute를 해주니까
값이 제대로 찍히는거 보아서는
EL쪽 문제가 아닌가 싶어요

 -->
<%--  <c:set var="loginId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}"/>

--%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>fastcampus</title>
    <link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>    
</head>
<body>
${loginId}<br>
${loginOutLink}<br>
${loginOut}<br>
<%-- <%
HttpSession session = request.getSession();
//String str = (String)request.getSession().getAttribute("id");
%>  
<%=str%>
ㅎㅇㅎㅇ${pageContext.request.session.getAttribute('id') == null ? 'Login' : 'Logout'}
???? ${loginOut}<br>
${loginId}<br>
${loginOutLink}<br>
${loginOut}<br>


<%
String loginID = (String)request.getSession().getAttribute("id");
String loginOutLink = "";
if(loginID == null || loginID.equals("")){
	
}
%> --%>
<div id="menu">
	<ul>
	    <li id="logo">fastcampus</li>
	    <li><a href="<c:url value='/'/>">Home</a></li>
	    <li><a href="<c:url value='/board/list'/>">Board</a></li>
	    <li><a href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>    
	    <li><a href="<c:url value='/register/add'/>">Sign in</a></li>
	    <li><a href=""><i class="fas fa-search small"></i></a></li>
	</ul> 
</div>
<div style="text-align:center">
	<h1>This is HOME</h1> 
	<h1>This is HOME</h1>
	<h1>This is HOME</h1>
</div>