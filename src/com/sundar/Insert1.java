package com.sundar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Insert1
 */
public class Insert1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Insert1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("HELLO: ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		Student st=new Student();
		st.setName(request.getParameter("name"));
		st.setRegNo(request.getParameter("regno"));
		st.setDob(request.getParameter("dob"));
		st.setEmail(request.getParameter("email"));
		st.setMobile(request.getParameter("mobile"));
		st.setDept(request.getParameter("dept"));
		try{
		DbUtil.insert(st);
		}catch (Exception e){System.out.println(e);}
		response.sendRedirect("./././index");
	}
}

