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
		<div class="cover-image" style="background-image : url('${pageContext.request.contextPath}/images/bgimg.jpg')"></div>
			<div class="container" id="content">
				<br> <br> <br> <br> <br> <br>
				<div class="col-xs-12 col-md-6">
					<a href="http://www.icqa.or.kr/advice/network01.aspx"><p class="con2">네트워크관리사</p></a>
					<hr>
					<p class="con1">&emsp;&ensp;네트워크관리사란 서버를 구축하고 보안 설정, 시스템 최적화 등 네트워크구축 및 이를 효과적으로 관리할 수 있는 인터넷 관련 기술력에 대한 자격이다. <br>
					2급(국가공인) - 네트워크 관련 업무 수행을 위한 일반적인 운용지식과 구축기술 NOS운영, Packet분석, Monitoring, 인터넷기술, Protocol 등 기초 이론과 실무능력 검정 <br>
					1급 - 네트워크 관리에 관한 전문지식을 토대로 네트워크 보안기술, Design, Traffic 분산기술 등 네트워크 전문기술자로서 필요한 IT 기술 및 네트워크 실무. 관리 능력 검정</p>
				</div>
				<div class="col-xs-12 col-md-3">
					<img src="${pageContext.request.contextPath}/images/h22.JPG">
				</div>
				<br>
			</div>
	</div>
<jsp:include page="../main/module/mainFooter.jsp"/>
</body>
</html>