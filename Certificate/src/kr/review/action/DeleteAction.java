package kr.review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.review.dao.ReviewDao;
import kr.review.domain.ReviewVo;
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
		ReviewDao dao = ReviewDao.getInstance();
		ReviewVo reviewVo = dao.getBoard(num);
		
		//로그인한 아이디와 글 작성자 아이디가 다를 경우
		if(user_id != null && !user_id.equals(reviewVo.getMem_id())){
			request.setAttribute("accessMsg", "삭제 권한이 없습니다.");
			return "/views/review/list.jsp";
		}
		//글삭제
		dao.deleteBoard(num);
		//파일삭제
		if(reviewVo.getNb_filename()!=null){
			FileUtil.removeFile(request, reviewVo.getNb_filename());
		}
		return "redirect:/review/list.do";
	}

}
