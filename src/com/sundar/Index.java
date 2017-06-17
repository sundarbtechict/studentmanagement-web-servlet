package com.sundar;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
		try{
			Connection c= DbUtil.getConnection();
			boolean f= false;
			String sql="SELECT * FROM STUDENT_MANAGEMENT";
			PreparedStatement ps=c.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
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
			
			while(rs.next())
			{
						out.println("<tr>"
						+ "<td>"+rs.getString("regno")+"</td>"
						+ "<td>"+rs.getString("name")+"</td>"
						+ "<td>"+rs.getString("dob")+"</td>"
						+ "<td>"+rs.getString("dept")+"</td>"
						+ "<td>"+rs.getString("email")+"</td>"
						+ "<td>"+rs.getString("mobile")+"</td>"
						+"<td><a href='./read?regno="+rs.getString("regno")+"'>View</a></td>"
						+"<td><a href='./edit?regno="+rs.getString("regno")+"'>Edit</a></td>"
						+"<td><a href='./delete?regno="+rs.getString("regno")+"'>Delete</a></td>"
						+ "</tr>");
							
					f=true;
			}
			if(!f)
			{
				out.println("<p>Empty list</p><br>");
			}
			out.println("</table>"
			+ "<a href='./././insert.html'>create</a>"
			+ "</div>"
			+ "</body>"
			+ "</html>");
			
			rs.close();
			ps.close();
			c.close();
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
