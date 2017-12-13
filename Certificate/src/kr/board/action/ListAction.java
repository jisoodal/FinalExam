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
		
		String keyfield = request.getParameter("keyfield"); //�˻� ����: ����/�̸�
		String keyword = request.getParameter("keyword"); //�˻���
		
		if(keyfield ==null) keyfield ="";
		if(keyword ==null) keyword="";
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) pageNum="1";
		
		int rowCount = 10;//���������� �Խù� ��
		int pageCount =10;//��ȭ���� ������ ��
		int currentPage = Integer.parseInt(pageNum);
		
		BoardDao dao = BoardDao.getInstance();
		int count = dao.getBoardCount(keyfield, keyword);
		
		//����¡ ó��
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
