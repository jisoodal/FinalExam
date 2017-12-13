package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import kr.board.dao.BoardDao;
import kr.board.domain.BoardVo;
import kr.controller.Action;
import kr.util.FileUtil;

public class WriteAction implements Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		
		if(user_id==null){
			return "redirect:/member/loginForm.do";
		}

		MultipartRequest multi = FileUtil.createFile(request);
		BoardVo baordVo= new BoardVo();		
		baordVo.setNb_subject(multi.getParameter("nb_subject"));
		baordVo.setNb_content(multi.getParameter("nb_content"));
		baordVo.setMem_id(user_id);
		
	
		
		BoardDao dao = BoardDao.getInstance();
		dao.insertBoard(baordVo);		
		return "/views/board/write.jsp";
	}
	

}
