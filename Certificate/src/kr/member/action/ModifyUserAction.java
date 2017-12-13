package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.Member;

public class ModifyUserAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//�α��� ���� üũ
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if(user_id==null){
			return "redirect:/member/loginForm.do";
		}
		
		//���۵� �����Ϳ� ���� ���ڵ�
		request.setCharacterEncoding("utf-8");
		//�ڹٺ� ����
		Member member = new Member();
		//�ڹٺ� ���۵� ������ ����
		//id�� ���۵��� �ʾұ� ������ session�� ����� user_id.
		//���۵� ������ : name,passwd,phone,email,zipcode,
		//               address1,address2
		member.setMem_id(user_id);
		member.setMem_name(request.getParameter("mem_name"));
		member.setMem_pw(request.getParameter("mem_pw"));
		member.setMem_cell(request.getParameter("mem_cell"));
		member.setMem_email(request.getParameter("mem_email"));
		member.setMem_addr(request.getParameter("mem_addr"));

		//MemberDao�� updateMember�� �ڹٺ� ����
		MemberDao dao = MemberDao.getInstance();
		dao.updateMember(member);
		return "/views/member/modifyUser.jsp";
	}

}







