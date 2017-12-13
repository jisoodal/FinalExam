<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<jsp:include page="../main/module/mainTest.jsp" />
<body>
	<div class="cover">
		<div class="cover-image"
			style="background-image : url('${pageContext.request.contextPath}/images/bgimg.jpg')"></div>
		<div class="container" id="content">
			<div class="col-md-12">
				<form action="find.do" method="post" id="find_form">
					<h2>
						아이디/비밀번호 찾기<small> 휴대폰번호로 찾기</small>
					</h2>
					<br />
					<div class="col-xs-12 col-md-8">
						<input type="text" name="mem_cell" class="form-control"
							id="mem_cell" placeholder="핸드폰번호">
					</div>
					<div class="col-xs-12 text-left">
						<br />
						<button type="submit" class="btn btn-info">찾기</button>
						<button type="button" class="btn btn-warning"
							onclick="location.href='../member/loginForm.do'">뒤로가기</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="../main/module/mainFooter.jsp" />
</body>
</html>