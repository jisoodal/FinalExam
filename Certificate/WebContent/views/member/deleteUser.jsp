<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${check}">
	<!DOCTYPE html>
<html>
<head>

<title>회원 탈퇴</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>용인대 컴퓨터 관련 자격증</title>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
     
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sool.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-theme.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css" />
    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/animate.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/sool.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/member.js"></script>
</head>
<body>
	<jsp:include page="../main/module/mainTest.jsp" />
	<div class="cover">
		<div class="cover-image"
			style="background-image : url('${pageContext.request.contextPath}/images/bgimg.jpg')"></div>
		<div class="container" id="alert">
			<h2>회원탈퇴가 정상적으로 완료되었습니다.</h2>
			<br /> <a class="btn btn-md btn-default" href="../main/main.do">홈으로
				돌아가기</a>
		</div>
	</div>
	<jsp:include page="../main/module/mainFooter.jsp" />
</body>
</html>
</c:if>
<c:if test="${!check}">
	<script>
		alert('비밀번호 불일치!');
		history.go(-1);
	</script>
</c:if>