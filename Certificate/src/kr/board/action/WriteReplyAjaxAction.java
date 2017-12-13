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
		
		if(user_id==null){//�α��� �ȵ�
			replyResult.setResult("logout");
		}else{//�α��� ��
			request.setCharacterEncoding("utf-8");//post������� ���۵�
			
			BoardReply reply=new BoardReply();
			reply.setRe_content(request.getParameter("re_content"));
			reply.setRe_ip(request.getRemoteAddr());
			reply.setNum(Integer.parseInt(request.getParameter("num")));
			reply.setId(user_id);
			
			BoardDao dao=BoardDao.getInstance();
			dao.replyInsertBoard(reply);
			
			//������ ������ setting
			replyResult.setResult("success");
		}
		//JSON ������ ����
		ObjectMapper mapper=new ObjectMapper();
		String jsonData=mapper.writeValueAsString(replyResult);
		
		request.setAttribute("jsonData", jsonData);
		
		return "/views/common/ajaxView.jsp";
	}

}

