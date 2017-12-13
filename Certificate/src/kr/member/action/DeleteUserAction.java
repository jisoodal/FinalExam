package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.Member;

public class DeleteUserAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//�α��� ���� üũ
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if(user_id==null){
			return "redirect:/member/loginForm.do";
		}
		
		//MemberDao�� getMember�� user_id�� �����ؼ� �� ����
		//���ڵ带 �ڹٺ� ��� ��ȯ
		MemberDao dao = MemberDao.getInstance();
		Member member = dao.getMember(user_id);
		boolean check = false;
		
		//�ڹٺ��� null�� �ƴ� ��� ���۵� �����ȣ�� �޾Ƽ�
		//��й�ȣ üũ
		if(member!=null){
			request.setCharacterEncoding("utf-8");
			String passwd = request.getParameter("mem_pw");
			//��й�ȣ ��ġ ���� üũ
			check = member.isCheckedPasswd(passwd);
		}
		//check�� true�̸� MemberDao�� deleteMember�� user_id
		//����.�α׾ƿ�
		if(check){
			//ȸ����������
			dao.deleteMember(user_id);
			//�α׾ƿ�
			session.invalidate();
		}
		//check�� request�� ����
		request.setAttribute("check", check);
		return "/views/member/deleteUser.jsp";
	}

}








