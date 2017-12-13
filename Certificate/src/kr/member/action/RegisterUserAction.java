package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.Member;

public class RegisterUserAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("~~");
		//전송된 데이터에 대한 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		//자바빈 객체 생성
		Member member = new Member();
		//전송된 데이터를 자바빈에 저장
		member.setMem_id(request.getParameter("mem_id"));
		member.setMem_name(request.getParameter("mem_name"));
		member.setMem_pw(request.getParameter("mem_pw"));
		member.setMem_cell(request.getParameter("mem_cell"));
		member.setMem_email(request.getParameter("mem_email"));
		member.setMem_addr(request.getParameter("mem_addr"));
	
		//MemberDao의 insertMember 메서드를 호출해서
		//자바빈 전달
		MemberDao dao = MemberDao.getInstance();
		dao.insertMember(member);
		
		return "/views/member/registerUser.jsp";
	}

}







