package kr.review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import kr.controller.Action;
import kr.review.dao.ReviewDao;
import kr.review.domain.ReviewVo;
import kr.util.FileUtil;

public class UpdateAction implements Action{


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String user_id =(String)session.getAttribute("user_id");
		if(user_id == null){
			return "redirect:/member/loginForm.do";
		}
		MultipartRequest multi = FileUtil.createFile(request);
		int num = Integer.parseInt(multi.getParameter("nb_num"));
		String filename = multi.getFilesystemName("nb_filename");
		
		ReviewDao dao = ReviewDao.getInstance();
		//������ ������
		ReviewVo dBboard = dao.getBoard(num);
		
		//Ư�� ���� ���̵� �۵��/����/������ ������..
		
		//�α����� ���̵�� �� �ۼ��� ���̵� �ٸ� ���
		if(user_id !=null && !user_id.equals(dBboard.getMem_id())){
			if(filename!=null){
				FileUtil.removeFile(request, filename);	
			}
			request.setAttribute("accessMsg", "���������� �����ϴ�.");
			return "/views/review/list.jsp";
		}
		
		//���۵� ���� ����
		ReviewVo reviewVo = new ReviewVo();
		reviewVo.setNb_num(num);
		reviewVo.setNb_subject(multi.getParameter("nb_subject"));
		reviewVo.setNb_content(multi.getParameter("nb_content"));
/*		board.setIp(request.getRemoteAddr());*/
		
		if(filename!=null){//���̹����� ��ü
			reviewVo.setNb_filename(FileUtil.rename(request, filename));
		}else{//���۵� �̹����� �������
			reviewVo.setNb_filename(dBboard.getNb_filename());
		}
		dao.updateBoard(reviewVo);
		if(filename!=null){		
			//���̹����� ��ü
			FileUtil.removeFile(request, dBboard.getNb_filename());
		}
		return "redirect:/review/list.do";
	}

}
