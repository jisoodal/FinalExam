package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.member.dao.MemberDao;

public class FindIDPWAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String mem_cell = request.getParameter("mem_cell");
		
		MemberDao dao = MemberDao.getInstance();
		String id = dao.findId(mem_cell);
		String pw = dao.findPW(mem_cell);
		
		request.setAttribute("mem_id", id);
		request.setAttribute("mem_pw", pw);
		
		return "/views/member/findIDPW.jsp";
	}

}
