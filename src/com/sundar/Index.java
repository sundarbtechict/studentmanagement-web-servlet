package com.sundar;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Index
 */
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			PrintWriter out = response.getWriter();	
			out.println("<!DOCTYPE html>"  
					+"<html lang='en'>"
					+ "<head>"
					+ "<title>Student Management</title>"
					+"  <meta charset='utf-8'>"
					+"  <meta name='viewport' content='width=device-width, initial-scale=1'>"  
					+ "<link href='./plugins/bootstrap.css' rel='stylesheet type='text/css />" 
					+"<script type='text/javascript' src='./plugins/bootstrap.min.js'></script>"
					+"<script type='text/javascript' src='./plugins/jquery.2.2.3.min.js'></script>"
					+ ""
					+ "</head>"
					+ "<body>"
					+ "<div class='jumbotron text-center' style='color:#000080;'><h2>Student Management</h2></div>"
					+ "<div class='container'>"
					+ "<table class='table table-bordered'><tr>"
					+ "<th>Register no:</th>"
					+ "<th>Name:</th>"
					+ "<th>Date of Birth:</th>"
					+ "<th>Department:</th>"
					+ "<th>Email:</th>"
					+ "<th>Mobile:</th>"
					+"<th>ACTION</th>"
					+"<th>ACTION</th>"
					+"<th>ACTION</th>"
					+ "</tr>"
					);
			try{
			List<Student> li=DbUtil.select();
			Iterator<Student> itr=li.iterator();  
			while(itr.hasNext())  
			{
				Student st=itr.next();
						out.println("<tr>"
						+ "<td>"+st.getRegNo()+"</td>"
						+ "<td>"+st.getName()+"</td>"
						+ "<td>"+st.getDob()+"</td>"
						+ "<td>"+st.getDept()+"</td>"
						+ "<td>"+st.getEmail()+"</td>"
						+ "<td>"+st.getMobile()+"</td>"
						+"<td><a href='./read?regno="+st.getRegNo()+"'>View</a></td>"
						+"<td><a href='./edit?regno="+st.getRegNo()+"'>Edit</a></td>"
						+"<td><a href='./delete?regno="+st.getRegNo()+"'>Delete</a></td>"
						+ "</tr>");
			}
			out.println("</table>"
			+ "<a href='./././insert.html'>create</a>"
			+ "</div>"
			+ "</body>"
			+ "</html>");
			
			
			}catch (Exception e){System.out.println(e);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
