package kr.mobile.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;

public class MbmAction implements Action{

		@Override
		public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
			return "/views/mobile/mbm.jsp";
		}

}
