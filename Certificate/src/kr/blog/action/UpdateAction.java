package kr.blog.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import kr.blog.dao.BlogDao;
import kr.blog.domain.BlogVo;
import kr.controller.Action;
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
		
		BlogDao dao = BlogDao.getInstance();
		//������ ������
		BlogVo dBboard = dao.getBoard(num);
		
		//Ư�� ���� ���̵� �۵��/����/������ ������..
		
		//�α����� ���̵�� �� �ۼ��� ���̵� �ٸ� ���
		if(user_id !=null && !user_id.equals(dBboard.getMem_id())){
			if(filename!=null){
				FileUtil.removeFile(request, filename);	
			}
			request.setAttribute("accessMsg", "���������� �����ϴ�.");
			return "/views/blog/list.jsp";
		}
		
		//���۵� ���� ����
		BlogVo blogVo = new BlogVo();
		blogVo.setNb_num(num);
		blogVo.setNb_subject(multi.getParameter("nb_subject"));
		blogVo.setNb_content(multi.getParameter("nb_content"));
/*		board.setIp(request.getRemoteAddr());*/
		
		if(filename!=null){//���̹����� ��ü
			blogVo.setNb_filename(FileUtil.rename(request, filename));
		}else{//���۵� �̹����� �������
			blogVo.setNb_filename(dBboard.getNb_filename());
		}
		dao.updateBoard(blogVo);
		if(filename!=null){		
			//���̹����� ��ü
			FileUtil.removeFile(request, dBboard.getNb_filename());
		}
		return "redirect:/blog/list.do";
	}

}
