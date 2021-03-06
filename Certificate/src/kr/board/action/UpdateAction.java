package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import kr.board.dao.BoardDao;
import kr.board.domain.BoardVo;
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
		
		BoardDao dao = BoardDao.getInstance();
		//수정된 데이터
		BoardVo dBboard = dao.getBoard(num);
		
		//특정 권한 아이디만 글등록/삭제/수정이 가능함..
		
		//로그인한 아이디와 글 작성자 아이디가 다를 경우
		if(user_id !=null && !user_id.equals(dBboard.getMem_id())){
			if(filename!=null){
				FileUtil.removeFile(request, filename);	
			}
			request.setAttribute("accessMsg", "수정권한이 없습니다.");
			return "/views/board/list.jsp";
		}
		
		//전송된 정보 저장
		BoardVo boardVo = new BoardVo();
		boardVo.setNb_num(num);
		boardVo.setNb_subject(multi.getParameter("nb_subject"));
		boardVo.setNb_content(multi.getParameter("nb_content"));
/*		board.setIp(request.getRemoteAddr());*/
		
		if(filename!=null){//새이미지로 교체
			boardVo.setNb_filename(FileUtil.rename(request, filename));
		}else{//전송된 이미지가 없을경우
			boardVo.setNb_filename(dBboard.getNb_filename());
		}
		dao.updateBoard(boardVo);
		if(filename!=null){		
			//새이미지로 교체
			FileUtil.removeFile(request, dBboard.getNb_filename());
		}
		return "redirect:/board/list.do";
	}

}
