package org.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.StudentService;


public class UpdataStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("sno"));
		
		String name = request.getParameter("sname");
		int  age = Integer.parseInt(request.getParameter("sage"))   ;
		String address = request.getParameter("saddress");
		
		Student student = new Student(name,age,address);
		StudentService service =new StudentService();
		boolean result =  service.updateStudentBySno(no, student);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		if(result) {
		//	response.getWriter().println("修改成功！");
			response.sendRedirect("QueryAllStudentsServlet");
		}else {
				response.getWriter().println("修改失败！");			
		}	

		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
