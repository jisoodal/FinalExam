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
		//�۹�ȣ ��ȯ
		int num = Integer.parseInt(request.getParameter("nb_num"));
		BoardDao dao = BoardDao.getInstance();
		
		//��ȸ�� ����
		dao.updateReadcount(num);
		
		//�۹�ȣ�� ��Ī�Ǵ� ���ڵ�(������)�� ��ȯ
		BoardVo boardVo = dao.getBoard(num);
		//������ HTML ����
		boardVo.setNb_subject(StringUtil.useNoHtml(boardVo.getNb_subject()));
		//������ HTML ���� �ٹٲ� ó��
		boardVo.setNb_content(StringUtil.useBrNoHtml(boardVo.getNb_content()));
		
		request.setAttribute("boardVo", boardVo);
		
		return "/views/board/detail.jsp";
	}
	
}
