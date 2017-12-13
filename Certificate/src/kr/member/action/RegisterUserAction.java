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
		//���۵� �����Ϳ� ���� ���ڵ� ó��
		request.setCharacterEncoding("UTF-8");
		//�ڹٺ� ��ü ����
		Member member = new Member();
		//���۵� �����͸� �ڹٺ� ����
		member.setMem_id(request.getParameter("mem_id"));
		member.setMem_name(request.getParameter("mem_name"));
		member.setMem_pw(request.getParameter("mem_pw"));
		member.setMem_cell(request.getParameter("mem_cell"));
		member.setMem_email(request.getParameter("mem_email"));
		member.setMem_addr(request.getParameter("mem_addr"));
	
		//MemberDao�� insertMember �޼��带 ȣ���ؼ�
		//�ڹٺ� ����
		MemberDao dao = MemberDao.getInstance();
		dao.insertMember(member);
		
		return "/views/member/registerUser.jsp";
	}

}







