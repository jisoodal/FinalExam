package kr.review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.review.dao.ReviewDao;
import kr.review.domain.ReviewVo;
import kr.util.StringUtil;

public class DetailAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//�۹�ȣ ��ȯ
		int num = Integer.parseInt(request.getParameter("nb_num"));
		ReviewDao dao = ReviewDao.getInstance();
		
		//��ȸ�� ����
		dao.updateReadcount(num);
		
		//�۹�ȣ�� ��Ī�Ǵ� ���ڵ�(������)�� ��ȯ
		ReviewVo reviewVo = dao.getBoard(num);
		//������ HTML ����
		reviewVo.setNb_subject(StringUtil.useNoHtml(reviewVo.getNb_subject()));
		//������ HTML ���� �ٹٲ� ó��
		reviewVo.setNb_content(StringUtil.useBrNoHtml(reviewVo.getNb_content()));
		
		request.setAttribute("reviewVo", reviewVo);
		
		return "/views/review/detail.jsp";
	}
	
}
