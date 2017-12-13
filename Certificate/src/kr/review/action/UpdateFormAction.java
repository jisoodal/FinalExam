package kr.review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.review.dao.ReviewDao;
import kr.review.domain.ReviewVo;

public class UpdateFormAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if(user_id==null){
			return "redirect:/member/loginForm.do";
		}
		int num = Integer.parseInt(request.getParameter("nb_num"));
		ReviewDao dao = ReviewDao.getInstance();
		ReviewVo reviewVo = dao.getBoard(num);
		if(user_id!=null && !user_id.equals(reviewVo.getMem_id())){
			request.setAttribute("accessMsg", "수정권한이 없습니다.");
			return "/views/review/list.jsp";
		}
		request.setAttribute("reviewVo", reviewVo);
		return "/views/review/updateForm.jsp";
	}	
}
