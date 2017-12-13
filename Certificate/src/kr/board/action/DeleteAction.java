package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.board.dao.BoardDao;
import kr.board.domain.BoardVo;
import kr.controller.Action;
import kr.util.FileUtil;

public class DeleteAction implements Action{

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
		
		//로그인한 아이디와 글 작성자 아이디가 다를 경우
		if(user_id != null && !user_id.equals(boardVo.getMem_id())){
			request.setAttribute("accessMsg", "삭제 권한이 없습니다.");
			return "/views/board/list.jsp";
		}
		//글삭제
		dao.deleteBoard(num);
		//파일삭제
		if(boardVo.getNb_filename()!=null){
			FileUtil.removeFile(request, boardVo.getNb_filename());
		}
		return "redirect:/board/list.do";
	}

}
