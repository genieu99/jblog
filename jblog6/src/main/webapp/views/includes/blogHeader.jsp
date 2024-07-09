<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h1><a href="${pageContext.request.contextPath}/${id}">${blog.title }</a></h1>
<ul>
	<sec:authorize access="!isAuthenticated()">
		<li><a href="${pageContext.request.contextPath}/user/login">로그인</a></li>
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated()" >
		<sec:authentication property="principal" var="authUser" />
		<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
		<c:if test="${authUser.id == blog.id }">
			<li><a href="${pageContext.request.contextPath}/${authUser.id }/admin/basic">블로그 관리</a></li>
		</c:if>
	</sec:authorize>
</ul>