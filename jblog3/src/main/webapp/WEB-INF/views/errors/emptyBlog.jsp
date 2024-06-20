<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f9f9f9;
        color: #333;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .container {
        text-align: center;
        background-color: #fff;
        padding: 30px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
    }
    h1 {
        color: #ff6347;
        font-size: 2em;
        margin-bottom: 20px;
    }
    hr {
        border: 0;
        height: 1px;
        background: #eee;
        margin: 20px 0;
    }
    a {
        display: inline-block;
        margin-top: 20px;
        padding: 10px 20px;
        background-color: #fe1100;
        color: #fff;
        text-decoration: none;
        border-radius: 4px;
        transition: background-color 0.3s;
    }
    a:hover {
        background-color: #e50900;
    }
    pre {
        color: #333;
        padding: 20px;
        border-radius: 8px;
    }
</style>
</head>
<body>
	<h1>[Empty] 찾을 수 없는 블로그입니다.</h1>
	<hr>
	<pre>
		<a href="${pageContext.request.contextPath}/user/join">회원가입 하시겠습니까?</a>
	</pre>
</body>
</html>