package kr.blog.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.blog.dao.BlogDao;
import kr.blog.domain.BlogVo;
import kr.board.dao.BoardDao;
import kr.board.domain.BoardVo;
import kr.controller.Action;

import kr.util.StringUtil;

public class DetailAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		int num = Integer.parseInt(request.getParameter("nb_num"));
		BlogDao dao = BlogDao.getInstance();
		
		dao.updateReadcount(num);
		
		BlogVo blogVo = dao.getBoard(num);
		
		blogVo.setNb_subject(StringUtil.useNoHtml(blogVo.getNb_subject()));

		blogVo.setNb_content(StringUtil.useBrNoHtml(blogVo.getNb_content()));
		
		request.setAttribute("blogVo", blogVo);
		
		return "/views/blog/detail.jsp";
	}
	
}
