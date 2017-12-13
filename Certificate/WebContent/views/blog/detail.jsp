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
				<h2>시험 공지사항</h2>
				<div class="col-xs-12 col-md-12">
					<table class="table table-condensed">
						<thead>
							<tr align="center">
								<th>제목</th>
								<th>${blogVo.nb_subject}</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>작성일</td>
								<td>${blogVo.nb_register}</td>
							</tr>
							<tr>
								<td>글쓴이</td>
								<td>${blogVo.mem_id}</td>
							</tr>
							<tr>
								<td colspan="2">
									<p>${blogVo.nb_content}</p>
								</td>
							</tr>
							<tr>
								<td class="text-center" colspan="2">
									<p>
										<c:if test="${!empty blogVo.nb_filename}">
											<img src="../upload/${blogVo.nb_filename}" class="detail-img">
										</c:if>
									</p>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="col-xs-12 text-center">
					<input type="button" class="btn btn-info" value="수정" onclick="location.href='updateForm.do?nb_num=${blogVo.nb_num}'"
						<c:if test="${user_id!=blogVo.mem_id}"> 
							disabled="disabled" 
						</c:if>>
					<input type="button" class="btn btn-warning" value="삭제" onclick="location.href='delete01.do?nb_num=${blogVo.nb_num}'"
						<c:if test="${user_id!=boardVo.mem_id} && ${mem_level==1}"> 
							disabled="disabled" 
						</c:if>>
					<input type="button" class="btn btn-success" value="목록" onclick="location.href='list.do'">
				</div>
				
			</div>
		</div>
<jsp:include page="../main/module/mainFooter.jsp"/>
</body>
</html> 