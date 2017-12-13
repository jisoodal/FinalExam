package kr.board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.dao.BoardDao;
import kr.board.domain.BoardVo;
import kr.controller.Action;
import kr.util.PagingUtil;

public class ListAction implements Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String keyfield = request.getParameter("keyfield"); //검색 종류: 제목/이름
		String keyword = request.getParameter("keyword"); //검색어
		
		if(keyfield ==null) keyfield ="";
		if(keyword ==null) keyword="";
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) pageNum="1";
		
		int rowCount = 10;//한페이지의 게시물 수
		int pageCount =10;//한화면의 페이지 수
		int currentPage = Integer.parseInt(pageNum);
		
		BoardDao dao = BoardDao.getInstance();
		int count = dao.getBoardCount(keyfield, keyword);
		
		//페이징 처리
		PagingUtil page = new PagingUtil(keyfield, keyword, currentPage, count, rowCount, pageCount,"list.do");
		
		List<BoardVo> list = null;
		if(count >0){
			list = dao.getListBoard(page.getStartCount(),
									page.getEndCount(),
									keyfield, keyword);
		}		
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		request.setAttribute("pagingHtml", page.getPagingHtml());
		return "/views/board/list.jsp";
	}

}
