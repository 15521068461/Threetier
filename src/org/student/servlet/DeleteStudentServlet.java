package org.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.service.StudentService;


public class DeleteStudentServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//request.setCharacterEncoding("utf-8");	
			
			int no = Integer.parseInt( request.getParameter("sno")) ;
			
			StudentService service =new StudentService();
			
			boolean result = service.deleteStudentBySno(no);
			
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			if(result) {
				//response.getWriter().println("É¾³ý³É¹¦£¡");
				response.sendRedirect("QueryAllStudentsServlet");
			}else {
					response.getWriter().println("É¾³ýÊ§°Ü£¡");			
			}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
