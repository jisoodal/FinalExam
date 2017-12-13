package kr.review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import kr.controller.Action;
import kr.review.dao.ReviewDao;
import kr.review.domain.ReviewVo;
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
		ReviewVo reviewVo= new ReviewVo();		
		reviewVo.setNb_subject(multi.getParameter("nb_subject"));
		reviewVo.setNb_content(multi.getParameter("nb_content"));
		reviewVo.setMem_id(user_id);
		
	
		
		ReviewDao dao = ReviewDao.getInstance();
		dao.insertBoard(reviewVo);		
		return "/views/review/write.jsp";
	}
	

}
