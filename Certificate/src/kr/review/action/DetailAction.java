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
		//글번호 반환
		int num = Integer.parseInt(request.getParameter("nb_num"));
		ReviewDao dao = ReviewDao.getInstance();
		
		//조회수 증가
		dao.updateReadcount(num);
		
		//글번호와 매칭되는 레코드(데이터)를 반환
		ReviewVo reviewVo = dao.getBoard(num);
		//제목은 HTML 불허
		reviewVo.setNb_subject(StringUtil.useNoHtml(reviewVo.getNb_subject()));
		//내용은 HTML 불허 줄바꿈 처리
		reviewVo.setNb_content(StringUtil.useBrNoHtml(reviewVo.getNb_content()));
		
		request.setAttribute("reviewVo", reviewVo);
		
		return "/views/review/detail.jsp";
	}
	
}
