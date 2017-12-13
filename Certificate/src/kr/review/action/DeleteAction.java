package kr.review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.review.dao.ReviewDao;
import kr.review.domain.ReviewVo;
import kr.util.FileUtil;

public class DeleteAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if(user_id==null){
			return "redirect:/member/loginForm.do";
		}
		int num = Integer.parseInt(request.getParameter("nb_num"));
		ReviewDao dao = ReviewDao.getInstance();
		ReviewVo reviewVo = dao.getBoard(num);
		
		//�α����� ���̵�� �� �ۼ��� ���̵� �ٸ� ���
		if(user_id != null && !user_id.equals(reviewVo.getMem_id())){
			request.setAttribute("accessMsg", "���� ������ �����ϴ�.");
			return "/views/review/list.jsp";
		}
		//�ۻ���
		dao.deleteBoard(num);
		//���ϻ���
		if(reviewVo.getNb_filename()!=null){
			FileUtil.removeFile(request, reviewVo.getNb_filename());
		}
		return "redirect:/review/list.do";
	}

}
