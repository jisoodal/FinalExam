<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
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
  </head>
<body>
 
<jsp:include page="../main/module/mainTest.jsp"/>
	<div class="cover">
		<div class="cover-image"
			style="background-image : url('${pageContext.request.contextPath}/images/bgimg.jpg')"></div>
		<div class="container" id="content">
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<div class="col-xs-12 col-md-6">
				<p class="con2">
					용인대학교 컴퓨터과학과<br> 학생들을 위한<br> 자격증 안내 페이지입니다.<br> -made by Jisoo-
				</p>
				<hr>
				<p class="con1">&emsp;&ensp; 항상 자격증 시험을 준비할 때 내가 취업하고자 하는 분야에 필요한 자격증이
				어떤 것이 있는지 한 눈에 알아보고 싶었습니다. 이 페이지를 만들게 된 가장 큰 계기도 제 자신의 정보를 위해, 그리고
				이러한 정보들을 다른 학생들에게도 알려주면 어떨까 하는 마음에 만들게 되었습니다.
				</p>
			</div>
			<div class="col-xs-12 col-md-6">
				<img src="${pageContext.request.contextPath}/images/1312312.jpg">
			</div>
		</div>
	</div>
	<jsp:include page="../main/module/mainFooter.jsp"/>
</body>
</html>