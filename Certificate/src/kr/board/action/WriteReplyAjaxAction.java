package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;

import kr.board.dao.BoardDao;
import kr.board.domain.BoardReply;
import kr.board.domain.BoardReplyAjax;
import kr.controller.Action;

public class WriteReplyAjaxAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session=request.getSession();
		String user_id=(String)session.getAttribute("user_id");
		
		BoardReplyAjax replyResult=new BoardReplyAjax();
		
		if(user_id==null){//로그인 안됨
			replyResult.setResult("logout");
		}else{//로그인 됨
			request.setCharacterEncoding("utf-8");//post방식으로 전송됨
			
			BoardReply reply=new BoardReply();
			reply.setRe_content(request.getParameter("re_content"));
			reply.setRe_ip(request.getRemoteAddr());
			reply.setNum(Integer.parseInt(request.getParameter("num")));
			reply.setId(user_id);
			
			BoardDao dao=BoardDao.getInstance();
			dao.replyInsertBoard(reply);
			
			//전송할 데이터 setting
			replyResult.setResult("success");
		}
		//JSON 데이터 생성
		ObjectMapper mapper=new ObjectMapper();
		String jsonData=mapper.writeValueAsString(replyResult);
		
		request.setAttribute("jsonData", jsonData);
		
		return "/views/common/ajaxView.jsp";
	}

}

