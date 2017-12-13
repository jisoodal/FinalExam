package kr.blog.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import kr.blog.dao.BlogDao;
import kr.blog.domain.BlogVo;
import kr.controller.Action;
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
		BlogVo blogVo= new BlogVo();		
		blogVo.setNb_subject(multi.getParameter("nb_subject"));
		blogVo.setNb_content(multi.getParameter("nb_content"));
		blogVo.setMem_id(user_id);
		
	
		
		BlogDao dao = BlogDao.getInstance();
		dao.insertBoard(blogVo);		
		return "/views/blog/write.jsp";
	}
	

}
