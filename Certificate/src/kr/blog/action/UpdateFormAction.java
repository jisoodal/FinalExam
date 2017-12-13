package kr.blog.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.blog.dao.BlogDao;
import kr.blog.domain.BlogVo;
import kr.controller.Action;

public class UpdateFormAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if(user_id==null){
			return "redirect:/member/loginForm.do";
		}
		int num = Integer.parseInt(request.getParameter("nb_num"));
		BlogDao dao = BlogDao.getInstance();
		BlogVo blogVo = dao.getBoard(num);
		if(user_id!=null && !user_id.equals(blogVo.getMem_id())){
			request.setAttribute("accessMsg", "���������� �����ϴ�.");
			return "/views/blog/list.jsp";
		}
		request.setAttribute("blogVo", blogVo);
		return "/views/blog/updateForm.jsp";
	}	
}
