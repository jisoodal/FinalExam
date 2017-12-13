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
				<h2>실제 취업 후기</h2>
				<form id="search_form" action="list.do" method="get">
					<ul class="search">
						<li>
							<select name="keyfield">
								<option value="nb_subject">제목</option>
								<option value="mem_id">ID</option>
								<option value="nb_content">내용</option>
							</select>
						</li>
						<li>
							<input type="search" size="16" name="keyword" id="keyword">
						</li>
						<li>
							<input type="submit" value="찾기">
						</li>
					</ul>
				</form>
				<c:if test="${count > 0 }">
					<table class="table">
						<thead>
							<tr>
								<th>글번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>날짜</th>
								<th>조회</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="reviewVo" items="${list}">
								<tr>
									<td>${reviewVo.nb_num}</td>
									<td><a href="detail.do?nb_num=${reviewVo.nb_num}">${reviewVo.nb_subject}</a>
									<td>${reviewVo.mem_id}</td>
									<td>${reviewVo.nb_register}</td>
									<td>${reviewVo.nb_hit }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
				<div class="col-xs-12 text-center">
					<c:if test="${mem_level==1}">
						<button type="button" class="btn btn-info" onclick="location.href='writeForm.do'">글쓰기</button>
					</c:if>
					<button type="button" class="btn btn-warning" onclick="location.href='../main/main.do'">홈으로</button>
				</div>
				<c:if test="${count ==0 }">
					등록된 게시물이 없습니다.		
				</c:if>
				<c:if test="${count > 0 }">
					<div class="align-center">${pagingHtml}</div>
				</c:if>
			</div>
	</div>
<jsp:include page="../main/module/mainFooter.jsp" />
</body>
</html>
