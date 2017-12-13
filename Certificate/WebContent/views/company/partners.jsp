<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>


<%  request.setCharacterEncoding("UTF-8"); %>
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
		<div class="cover-image" style="background-image : url('${pageContext.request.contextPath}/images/bgimg.jpg')">
		</div>
		<div class="container" id="content">
			<div class="col-xs-10 col-xs-offset-1 col-md-10 col-md-offset-1">
				<p class="con3" style="text-align: center;">
					이 페이지는 
					'용인대학교 컴퓨터과학과 졸업조건'안내 페이지 입니다.
				</p>
				<p class="partner">
					<span style="color: #0100FF">컴퓨터과학과의 졸업 이수 학점<br></span>
					<span style="color: #CC723D">교양필수(2013학번) - 12학점<br>
					교양필수(2014학번부터) - 14학점<br>
					교양선택 - 18학점 이상<br>
					기초전공(전공필수) - 12학점 이상<br>
					전문전공(단일전공자 본인 전문전공이수학점) - 54학점 이상<br>
					전문전공(부,복수,연계 전공자 본인 전문전공이수학점) - 33학점 이상<br>
					졸업 이수학점 - 130학점<br><br> </span>
					
					<span style="color: #5cb85c">컴퓨터과학과 졸업 내규<br></span>
					1. 졸업 작품 제출 <br>
					   4학년 1학기: 프로젝트 제안서, 중간보고서, 중간산출물<br>
					   4학년 2학기: 최종보고서, 발표회, 작품전시회<br>
					   '졸업작품이수증' 증여<br><br>
					   
					2. 영어: 토익 600이상(혹은 톺플, 텝스 등 이에 상응하는 공인어학점수 포함)<br><br>
					
					3. 자격증: 전공 관련 자격증(기사 이상) 1개<br>
					   컴퓨터과학과: 정보처리기사, OCP, OCJP등<br>
					   
					위 3개가 모두 충족될 경우 학사학위 부여
					
					
					
					
				</p>
			</div>
		</div>
	</div>
	<jsp:include page="../main/module/mainFooter.jsp"/>
</body>
</html>