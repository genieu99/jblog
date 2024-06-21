<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Access Error</title>
<style>
	body {
		font-family: Arial, sans-serif;
		background-color: #f9f9f9;
		color: #333333;
		margin-left: 40px;
		margin-right: 40px;
	}
	
	h1 {
		color: #4978D2;
		margin-bottom: 20px;
	}
	
	p {
		font-size: 18px;
		margin-bottom: 20px;
	}
	
	a {
        display: inline-block;
        align-items: center;
        padding: 10px 20px;
        background-color: #4978D2;
        color: #fff;
        text-decoration: none;
        border-radius: 4px;
        transition: background-color 0.3s;
    }
    
    a:hover {
        background-color: #e50900;
    }
</style>
</head>
<body>
	<h1>[Authentication] Access Error</h1>
	<hr/>
	<p>블로그 접근 권한이 없습니다.</p>
	<a href="${pageContext.request.contextPath}/${authUser.id }">내 블로그 가기</a>
	<a href="${pageContext.request.contextPath}/user/join">회원가입하기</a>
</body>
</html>