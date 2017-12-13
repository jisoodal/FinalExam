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
<jsp:include page="../main/module/mainTest.jsp"/>
	<div class="cover">
		<div class="cover-image" style="background-image : url('${pageContext.request.contextPath}/images/bgimg.jpg')"></div>
			<div class="container" id="content">
				<h2>홈페이지 공지사항</h2>
				<form action="update.do" method="post" enctype="multipart/form-data" id="update_form">
					<input type="hidden" name="nb_num" value="${blogVo.nb_num}">
					<div class="form-group col-md-12">
						<label for="nb_subject">제목</label> <input type="text" class="form-control" name="nb_subject" id="nb_subject" value="${blogVo.nb_subject }">
					</div>
					<div class="form-group col-md-12">
						<label for="nb_content">내용</label>
						<textarea class="form-control" rows="5" name="nb_content" id="nb_content">${blogVo.nb_content }</textarea>
					</div>
					<div class="form-group col-md-12">
						<label for="nb_filename">파일</label> <input type="file" name="nb_filename" id="exampleInputFile">
						<c:if test="${!empty blogVo.nb_filename}">
							<br>
							<span>(${blogVo.nb_filename})파일이 등록되었습니다 다시 업로드하면 기존 파일은 삭제됩니다</span>
						</c:if>
					</div>
	
					<div class="col-xs-12 text-center">
						<button type="submit" class="btn btn-info">수정</button>
						<button type="button" class="btn btn-warning" onclick="location.href='../blog/list.do'">목록으로</button>
					</div>
				</form>
			</div>
	</div>
<jsp:include page="../main/module/mainFooter.jsp"/>

</body>
</html>
