package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import kr.controller.Action;
import kr.member.dao.MemberDao;
import kr.member.domain.Member;
import kr.member.domain.MemberAjax;

public class CheckDuplicatedIdAjaxAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberAjax memberAjax = new MemberAjax(); 
		try{
			String mem_id = request.getParameter("mem_id");
			MemberDao dao = MemberDao.getInstance();
			Member member = dao.getMember(mem_id);
			System.out.println(mem_id);
			if(member == null){//���̵� ���ߺ�
				memberAjax.setResult("idNotFound");
			}else{//���̵� �ߺ�
				memberAjax.setResult("idDuplicated");
			}
		}catch(Exception e){
			memberAjax.setResult("failure");
			e.printStackTrace();
		}
		
		/*
		 * JSON�������� ��ȯ�ϱ⸦ ���ϴ� ���ڿ��� MemberAjax��
		 * ������Ƽ�� ������ �� MemberAjax�� ObjectMapper��
		 * writeValueAsString�� �����ؼ� �Ϲ� ���ڿ� �����͸�
		 * JSON������ ���ڿ� �����ͷ� ��ȯ
		 */
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(memberAjax);
		request.setAttribute("jsonData", jsonData);
		
		return "/views/common/ajaxView.jsp";
	}

}







