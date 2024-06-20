<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/WEB-INF/views/includes/blogHeader.jsp" />
		</div>
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<h4>${postNow.title }</h4>
					<p>
						${postNow.contents }
					<p>
				</div>
				<ul class="blog-list">
					<c:forEach items="${list }" var="list" varStatus="status">
						<li><a href="${pageContext.request.contextPath}/${id}/${list.categoryNo}/${list.no}">${list.title }</a> <span>${list.regDate }</span></li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath}${blog.logo }">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<li><a href="">닥치고 스프링</a></li>
				<li><a href="">스프링 스터디</a></li>
				<li><a href="">스프링 프로젝트</a></li>
				<li><a href="">기타</a></li>
			</ul>
		</div>
		
		<div id="footer">
			<c:import url="/WEB-INF/views/includes/footer.jsp" />
		</div>
	</div>
</body>
</html>