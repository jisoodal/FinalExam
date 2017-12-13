package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import kr.controller.Action;

public class LogoutAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//session�� request�κ��� ��ȯ ����
		HttpSession session = request.getSession();
		//�α׾ƿ�
		session.invalidate();
		return "/views/member/logout.jsp";
	}

}







