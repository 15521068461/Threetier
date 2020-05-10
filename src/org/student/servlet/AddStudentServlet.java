package org.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.student.entity.Student;
import org.student.service.StudentService;

public class AddStudentServlet extends HttpServlet {
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt( request.getParameter("sno"));
      String name =  request.getParameter("sname");
     int age = Integer.parseInt(request.getParameter("sage"));
     String address = request.getParameter("saddress");
     Student student = new Student(no,name,age,address);
     
     StudentService studentService = new StudentService();
    boolean result= studentService.addStudent(student);
    
    
    response.setContentType("text/html; charset=UTF-8");
    response.setCharacterEncoding("utf-8");
    
    PrintWriter out =response.getWriter();//为了可以在jps中打印出来
    if(result) {
   
    	out.print("增加成功!!!");
    	response.sendRedirect("QueryAllStudentsServlet");
    }else {
    	out.print("增加失败!");
    }
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
		//System.out.println("sswwsw");
	}

}
