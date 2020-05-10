<%@page import="org.student.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息列表</title>
</head>
<body>
   <table border="1px">
   <tr> 
        <th>学号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>操作</th>
    </tr>
     <% 
        List<Student> students = (List<Student>)request.getAttribute("students");
        for(Student student:students){
        	%>	
        <tr>
            <td><a href="QueryStudentBySno?sno=<%=student.getSno() %>"><%=student.getSno() %></a></td>
            <td><%=student.getSname() %></td>
            <td><%=student.getSage() %></td>
            <td><a href="DeleteStudentServlet?sno=<%=student.getSno() %>">删除</a></td>
        </tr>

    <%} %>
   
   
   </table>

<a href="add.jsp">新增</a>

</body>
</html>