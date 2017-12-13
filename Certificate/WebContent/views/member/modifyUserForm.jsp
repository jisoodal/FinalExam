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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/member.js"></script>

  </head>

<body>
	<jsp:include page="../main/module/mainTest.jsp" />
	<div class="cover">
		<div class="cover-image"
			style="background-image : url('${pageContext.request.contextPath}/images/bgimg.jpg')"></div>
		<div class="container" id="content">
			<h2>회원정보수정</h2>

			<form action="modifyUser.do" method="post" id="modify_form">
				<div class="form-group col-md-12">
					<label for="mem_name">이름</label> <input type="text" name="mem_name"
						class="form-control" id="mem_name" value="${member.mem_name}">
				</div>
				<div class="form-group col-md-12">
					<label for="mem_pw">비밀번호</label> <input type="password"
						name="mem_pw" class="form-control" id="mem_pw">
				</div>
				<div class="form-group col-md-12">
					<label for="mem_pw">비밀번호 확인</label> <input type="password"
						name="check_pw" class="form-control" id="check_pw">
				</div>
				<div class="form-group col-md-12">
					<label for="mem_cell">전화번호</label> <input type="text"
						name="mem_cell" class="form-control" id="mem_cell"
						value="${member.mem_cell}">
				</div>
				<div class="form-group col-md-12">
					<label for="mem_email">이메일</label> <input type="email"
						name="mem_email" class="form-control" id="mem_email"
						value="${member.mem_email}">
				</div>
				<div class="form-group col-md-12">
					<label for="mem_addr">주소</label> <input type="text" name="mem_addr"
						class="form-control" id="mem_addr" value="${member.mem_addr}">
				</div>

				<div class="col-xs-12 text-center">
					<button type="submit" class="btn btn-info">수정</button>
					<button type="button" class="btn btn-warning"
						onclick="location.href='../main/main.do'">홈으로</button>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="../main/module/mainFooter.jsp" />
</body>
</html>