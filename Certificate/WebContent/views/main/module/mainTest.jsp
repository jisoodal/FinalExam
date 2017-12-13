<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
	<nav class="navbar navbar-fixed-top" role="navigation" id="mainnav">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/main/main.do">용인대 컴퓨터 자격증 안내</a>
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar1, #navbar2"></button>
			</div>

			<div class="collapse navbar-collapse" id="navbar2">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="false"> 사이트 소개</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="${pageContext.request.contextPath}/company/business.do"> 사이트 소개</a></li>
							<li><a href="${pageContext.request.contextPath}/company/partners.do"> 졸업 조건 안내</a></li>
							<li><a href="${pageContext.request.contextPath}/company/maps.do"> 시험장 위치 찾기</a></li>
						</ul>
					</li>
						
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="false"> 네트워크 분야</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="${pageContext.request.contextPath}/network/ngs.do">네트워크관리사</a></li>
							<li><a href="${pageContext.request.contextPath}/network/ccna.do">(국제)CCNA</a></li>
							<li><a href="${pageContext.request.contextPath}/network/ccnp.do">(국제)CCNP</a></li>
							<li><a href="${pageContext.request.contextPath}/network/linuxMaster.do">리눅스마스터</a></li>
							<li><a href="${pageContext.request.contextPath}/network/eip.do?num=1">정보처리기사</a></li>
						</ul>
					</li>
						
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="false"> 모바일 분야(어플)</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="${pageContext.request.contextPath}/mobile/map.do?num=1">MAP</a></li>
							<li><a href="${pageContext.request.contextPath}/mobile/mbm.do?num=1">모바일비즈니스매니저</a></li>
							<li><a href="${pageContext.request.contextPath}/mobile/guideWim.do?num=1">무선인터넷관리사</a></li>
							<li><a href="${pageContext.request.contextPath}/mobile/mcm.do?num=1">M-Commerce관리사</a></li>
							<li><a href="${pageContext.request.contextPath}/mobile/linuxMaster.do?num=1">리눅스마스터</a></li>
							<li><a href="${pageContext.request.contextPath}/mobile/eip.do?num=1">정보처리기사</a></li>
						</ul>
					</li>
					
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="false">데이터베이스 분야</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="${pageContext.request.contextPath}/database/sqld.do?num=1">sqld</a></li>
							<li><a href="${pageContext.request.contextPath}/database/sqlp.do?num=1">sqlp</a></li>
							<li><a href="${pageContext.request.contextPath}/database/eip.do?num=1">정보처리기사</a></li>
							
						</ul>
					</li>
					
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="false"> 회원들의 공간</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="${pageContext.request.contextPath}/review/list.do">취업 후기 작성</a></li>
							<li><a href="${pageContext.request.contextPath}/blog/list.do">시험 공지사항</a></li>
							<li><a href="${pageContext.request.contextPath}/board/list.do">질문과 답변</a></li>
						</ul>
					</li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<c:if test="${empty user_id}">
						<li><a href="${pageContext.request.contextPath}/member/registerUserForm.do"><span class="glyphicon glyphicon-user"></span>회원가입</a></li>
						<li><a href="${pageContext.request.contextPath}/member/loginForm.do"><span class="glyphicon glyphicon-log-in"></span>로그인</a></li>
					</c:if>
					<c:if test="${mem_level==1 }">
						<li><a><b><span style="color: #f9b24f;">${user_id}</span>님 로그인 중</b></a></li>
						<li><a href="${pageContext.request.contextPath}/member/modifyUserForm.do"><span class="glyphicon glyphicon-pencil"></span>회원정보</a></li>
						<li><a href="${pageContext.request.contextPath}/member/deleteUserForm.do"><span class="glyphicon glyphicon-remove"></span>회원탈퇴</a></li>
						<li><a href="${pageContext.request.contextPath}/member/logout.do"><span class="glyphicon glyphicon-log-out"></span>로그아웃</a></li>
					</c:if>
					<c:if test="${mem_level==2 }">
						<li><a><b><span style="color: #f9b24f;">관리자</span>님 로그인 중</b></a></li>
						<li><a href="${pageContext.request.contextPath}/admin/memberSee.do"><span class="glyphicon glyphicon-pencil"></span>회원관리</a></li>
						<li><a href="${pageContext.request.contextPath}/member/logout.do"><span class="glyphicon glyphicon-log-out"></span>로그아웃</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</nav>
</header>