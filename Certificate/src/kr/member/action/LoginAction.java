package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.Member;

public class LoginAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("mem_id");
		String passwd = request.getParameter("mem_pw");
		
		MemberDao dao = MemberDao.getInstance();
		Member member = dao.getMember(id);
	
		boolean check = false;		
		boolean check_level = false;
		
		if(member!=null){
			//��й�ȣ üũ
			check = member.isCheckedPasswd(passwd);
			check_level = member.isCheckedId(id);
			
		}
		if(check ){//���� ����
			//�α��� ó��
			HttpSession session = request.getSession();

			session.setAttribute("user_id", id);
			
		}		
		request.setAttribute("check", check);
		
		if(check_level){
			HttpSession session = request.getSession();
			String mem_level = member.getMem_level();
			session.setAttribute("mem_level", mem_level);
		}
		   request.setAttribute("check_level", check_level);	
		
		return "/views/member/login.jsp";
	}
}