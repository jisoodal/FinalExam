<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <!--  진짜 -->
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
					<a href="http://www.ihd.or.kr/guidemap.do"><p class="con2">모바일앱개발전문가(MAP)</p></a>
					<hr>
					<p class="con1">&emsp;&ensp;모바일 기반의 앱 기획ㆍ설계 및 UI/UX디자인, 프로그래밍 기술 등 모바일 애플리케이션의 개발능력부터 모바일 환경,
					시장동향, 관련 법령 및 제도 등 전문이론 분야까지 객관적으로 검정하는 자격<br>
					
					도입목적 및 필요성<br>
					스마트 폰 활성화에 따른 국내 모바일 애플리케이션 이용의 급속한 확대<br> 
					모바일 애플리케이션 활용 산업 증가 및 앱 개발자에 대한 수요 증가<br> 
					모바일 앱 개발인력 학습 가이드 및 평가기준 요구에 의한 신규자격 개발 추진</p>
				</div>
				<div class="col-xs-12 col-md-6">
					<img src="${pageContext.request.contextPath}/images/y.jpg">
				</div>
				<br>
			</div>
	</div>
<jsp:include page="../main/module/mainFooter.jsp"/>
</body>
</html>