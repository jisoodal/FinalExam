<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
   <title>용인대 컴퓨터 관련 자격증</title>
   <link rel="shortcut icon" type="image/x-icon" href="../images/logo.png">

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
	<div class="container" id="alert">
		<script>
			alert('회원정보 수정이 완료되었습니다!');
			location.href = '../main/main.do';
		</script>
	</div>
	<jsp:include page="../main/module/mainFooter.jsp" />
</body>
</html>
