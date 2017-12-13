package kr.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
   
public class DispatcherServlet extends HttpServlet{
	     
	private Map<String,Action> commandMap =
			new HashMap<String,Action>();
	
	@Override
	public void init(ServletConfig config)
			                   throws ServletException{
		Properties pr = new Properties();
		//"/WEB-INF/ActionMap.properties" ��ȯ
		String props = config.getInitParameter("propertyConfig");
		//"/WEB-INF/ActionMap.properties"�� ������ ����
		String path = config.getServletContext().getRealPath(props);
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(path);
			//���� ��Ʈ���� Properties ��ü�� �Ѱ� key�� value�� ����
			pr.load(fis);
		}catch(IOException e){
			throw new ServletException(e);
		}finally{
			if(fis!=null)try{fis.close();}catch(IOException e){}
		}
	
		//Properties ��ü���� key���ϱ�
		Iterator keyIter = pr.keySet().iterator();
		while(keyIter.hasNext()){
			String command = (String)keyIter.next();//key
			String className = pr.getProperty(command);//value
			
			try{
				//���ڿ��� �̿��� Ŭ������ ã�� Class Ÿ������ ��ȯ
				Class commandClass = Class.forName(className);
				//��ü�� ����
				Object commandInstance = commandClass.newInstance();
				
				System.out.println(command + ", " + commandInstance);
				
				//HashMap�� key�� value�� ���
				commandMap.put(command, (Action)commandInstance);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	 
	@Override
	protected void doGet(HttpServletRequest request,
			             HttpServletResponse response)
	                throws ServletException,IOException{
		requestPro(request,response);
	}
	@Override
	protected void doPost(HttpServletRequest request,
			              HttpServletResponse response)
	                throws ServletException,IOException{
		requestPro(request,response);
	}
	private void requestPro(HttpServletRequest request,
			                HttpServletResponse response)
	                throws ServletException,IOException{
		String view = null;
		Action com = null;
		
		try{
			String command = request.getRequestURI();
			if(command.indexOf(request.getContextPath())==0){
				command = command.substring(
						request.getContextPath().length());
			}
			
			//HashMap�� key�� �־ value(�� ��ü)�� ����
			com = commandMap.get(command);
			view = com.execute(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(view.startsWith("redirect:")){//�����̷�Ʈ
			view = view.substring("redirect:".length());
			response.sendRedirect(request.getContextPath()+view);
		}else{//������
			//forward ������� view(jsp) ȣ��
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}
}









