package com.sp.demo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Controller")
public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action").toString();
		StudentDao sdao=new StudentDao();
        Student student=new Student();
		if(action.equals("edit"))
		{
			int id=Integer.parseInt(request.getParameter("userId"));
			student=sdao.list(id);
			request.setAttribute("updateData", student);
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}else {
	        List<Student> ss=sdao.allList();
			request.setAttribute("listAll", ss);
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
		
		String action=request.getParameter("action").toString();
		if(action.equals("save"))
		{
			String name=request.getParameter("sname").toString();
			Student s=new Student();
			StudentDao sdao=new StudentDao();
			s.setName(name);
			sdao.add(s);
			doGet(request,response);

		}else if(action.equals("edit"))
		{
			String name=request.getParameter("sname").toString();
			int id=Integer.parseInt(request.getParameter("id"));

			Student s=new Student();
			StudentDao sdao=new StudentDao();
			s.setName(name);
			s.setId(id);
			System.out.println(s.toString());
			sdao.update(s);
			doGet(request,response);
		}
		
		
	}

}
