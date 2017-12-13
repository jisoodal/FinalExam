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
	<div class="cover">
		<div class="cover-image" style="background-image : url('${pageContext.request.contextPath}/images/bgimg.jpg')"></div>
		<div class="container" id="content">
			<form action="login.do" method="post" id="login_form">
				<h2>
					로그인<small> 환영합니다! </small>
				</h2>
				<br />
				<div class="form-group col-md-8">
					<input type="text" name="mem_id" id="mem_id" class="form-control"
						placeholder="아이디를 입력하세요">
				</div>

				<div class="form-group col-md-8">
					<input type="password" name="mem_pw" class="form-control"
						id="mem_pw" placeholder="비밀번호를 입력하세요">
				</div>
				<div class="col-xs-12 text-left">
					<a href="../member/findForm.do">아이디 / 비밀번호 찾기</a> &emsp;&ensp; <input
						type="submit" value="로그인" class="btn btn-info" />
					<button type="button" class="btn btn-warning"
						onclick="location.href='../main/main.do'">홈으로</button>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="../main/module/mainFooter.jsp" />
</body>
</html>