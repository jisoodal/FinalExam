package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.dao.BoardDao;
import kr.board.domain.BoardVo;
import kr.controller.Action;

import kr.util.StringUtil;

public class DetailAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//글번호 반환
		int num = Integer.parseInt(request.getParameter("nb_num"));
		BoardDao dao = BoardDao.getInstance();
		
		//조회수 증가
		dao.updateReadcount(num);
		
		//글번호와 매칭되는 레코드(데이터)를 반환
		BoardVo boardVo = dao.getBoard(num);
		//제목은 HTML 불허
		boardVo.setNb_subject(StringUtil.useNoHtml(boardVo.getNb_subject()));
		//내용은 HTML 불허 줄바꿈 처리
		boardVo.setNb_content(StringUtil.useBrNoHtml(boardVo.getNb_content()));
		
		request.setAttribute("boardVo", boardVo);
		
		return "/views/board/detail.jsp";
	}
	
}
