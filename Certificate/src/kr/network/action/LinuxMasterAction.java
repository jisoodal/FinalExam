package kr.network.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;

public class LinuxMasterAction implements Action{

		@Override
		public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
			return "/views/network/linuxMaster.jsp";
		}

}