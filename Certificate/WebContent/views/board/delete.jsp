<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int num = Integer.parseInt(request.getParameter("nb_num"));
%>
<script type="text/javascript">
	if(confirm("질문을 삭제하시겠습니까?")){
		alert("삭제 완료");		
		location.href='delete.do?nb_num=<%=num %>';
	}else{
		alert("취소");
		history.go(-1);
	}
</script>

