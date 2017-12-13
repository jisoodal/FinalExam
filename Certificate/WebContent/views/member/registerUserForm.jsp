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

	<div class="cover">
		<div class="cover-image"
			style="background-image : url('${pageContext.request.contextPath}/images/bgimg.jpg')"></div>
		<div class="container" id="content">
			<h2>회원가입</h2>
			<form action="registerUser.do" method="post" id="register_form">
				<h2></h2>
				<br />
				<div class="form-group col-md-9">
					<label for="mem_id">아이디</label> <input type="text" name="mem_id"
						id="mem_id" class="form-control" placeholder="아이디 입력">
				</div>

				<div class="form-group col-md-3 text-center">
					<input type="button" value="ID중복체크" id="id_check"
						class="btn btn-warning"> <span id="message_id"></span>
						<img src="../images/ajax-loader.gif" width="5" height="5" id="loading" style="display:none;"> 
				</div>

				<div class="form-group col-md-12">
					<label for="mem_pw">비밀번호</label> <input type="password"
						name="mem_pw" class="form-control" id="mem_pw" placeholder="비밀번호">
				</div>

				<div class="form-group col-md-12">
					<label for="check_pw">비밀번호 확인</label> <input type="password"
						name="check_pw" class="form-control" id="check_pw"
						placeholder="비밀번호 확인"><span id="message_pw"></span>
				</div>

				<div class="form-group col-md-12">
					<label for="mem_name">이름</label> <input type="text" name="mem_name"
						class="form-control" id="mem_name" placeholder="이름 입력">
				</div>

				<div class="form-group col-md-12">
					<label for="mem_mail">이메일 주소</label> <input type="email"
						name="mem_email" class="form-control" id="mem_email"
						placeholder="이메일 주소">
				</div>

				<div class="form-group col-md-12">
					<label for="mem_cell">전화번호</label> <input type="tel"
						name="mem_cell" class="form-control" id="mem_cell"
						placeholder="- 없이 입력해 주세요">
				</div>

				<div class="form-group col-md-12">
					<label for="mem_addr">주소</label> <input type="text" name="mem_addr"
						class="form-control" id="mem_addr" placeholder="주소 입력">
				</div>
				<div class="col-xs-12 text-center">
					<button type="submit" class="btn btn-info">회원가입</button>
					<button type="button" class="btn btn-warning"
						onclick="location.href='../main/main.do'">가입취소</button>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="../main/module/mainFooter.jsp" />
</body>
</html>
