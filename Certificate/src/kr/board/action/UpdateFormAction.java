package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.board.dao.BoardDao;
import kr.board.domain.BoardVo;
import kr.controller.Action;

public class UpdateFormAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if(user_id==null){
			return "redirect:/member/loginForm.do";
		}
		int num = Integer.parseInt(request.getParameter("nb_num"));
		BoardDao dao = BoardDao.getInstance();
		BoardVo boardVo = dao.getBoard(num);
		if(user_id!=null && !user_id.equals(boardVo.getMem_id())){
			request.setAttribute("accessMsg", "수정권한이 없습니다.");
			return "/views/board/list.jsp";
		}
		request.setAttribute("boardVo", boardVo);
		return "/views/board/updateForm.jsp";
	}	
}
