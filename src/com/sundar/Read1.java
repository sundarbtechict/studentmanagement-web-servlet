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
 * Servlet implementation class Read1
 */
public class Read1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Read1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String regno = request.getParameter("regno");
		System.out.println(regno);
		try{
			Connection c= DbUtil.getConnection();
			boolean f= false;
			String sql="SELECT * FROM STUDENT_MANAGEMENT WHERE regno=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setString(1,regno);
			ResultSet rs=ps.executeQuery();
			PrintWriter out = response.getWriter();		
			while(rs.next())
			{
				out.println("<!DOCTYPE html>" + 
						"<html lang='en'>" + 
						"<head>" + 
						"<title>Student Management</title>" + 
						"  <meta charset='utf-8'>" + 
						"  <meta name='viewport' content='width=device-width, initial-scale=1'>" + 
						"<link href='./plugins/bootstrap.css' rel='stylesheet type='text/css />" + 
						"<script type='text/javascript' src='./plugins/bootstrap.min.js'></script>" + 
						"<script type='text/javascript' src='./plugins/jquery.2.2.3.min.js'></script>" + 
						"</head>" + 
						"<body>" + 
						"<div class='jumbotron text-center' style='color:#000080;'><h2>Student Management</h2></div>" + 
						"<table class='table table-striped'" 
						+ "<tr>"
						+ "<th>Register no:</th>"
						+ "<td>"+rs.getString("regno")+"</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<th>Name:</th>"
						+ "<td>"+rs.getString("name")+"</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<th>Date of Birth:</th>"
						+ "<td>"+rs.getString("dob")+"</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<th>Department:</th>"
						+ "<td>"+rs.getString("dept")+"</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<th>Email:</th>"
						+ "<td>"+rs.getString("email")+"</td>"
						+ "</tr>"
						+ "<tr>"
						+ "<th>Mobile:</th>"
						+ "<td>"+rs.getString("mobile")+"</td>"
						+ "</tr>"
						+ "</table>"
						+ "<a href='./././index'>back</a>"
						+ "</div>" + 
						"</body>"  
						+"</html>");	
					f=true;
			}
			if(!f)
			{
				out.println("<html> <p>Invalid register no</p><br>"
						+ "<a href='./index'>back</a></html>");
			}
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
