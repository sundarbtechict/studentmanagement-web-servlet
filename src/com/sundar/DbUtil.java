package com.sundar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class DbUtil {
	public static final String url = "jdbc:mysql://localhost:3306/student";
	public static final String user = "root";
	public static final String pass = "";

	public static Connection getConnection() throws Exception {
		Connection c;
		Class.forName("com.mysql.jdbc.Driver");
		c = DriverManager.getConnection(url, user, pass);
		return c;
	}
	public static void insert(Student st)
	{
		try{
			Connection c=DbUtil.getConnection();
			PreparedStatement ps=c.prepareStatement("INSERT INTO STUDENT_MANAGEMENT VALUES(?,?,?,?,?,?)");
			ps.setString(1, st.getRegNo());
			ps.setString(2, st.getName());
			ps.setString(3, st.getDob());
			ps.setString(4, st.getDept());
			ps.setString(5, st.getEmail());
			ps.setString(6, st.getMobile());
			int n=ps.executeUpdate();
			if(n==0)
				System.out.println("record is not inserted");
			else
				System.out.println("record is sucessfully inserted");
			ps.close();
			c.close();
		}catch (Exception e){System.out.println(e);}
	}
	public static Student read(String regno)
	{
		Student st=new Student();
		try{
			Connection c= DbUtil.getConnection();
			String sql="SELECT * FROM STUDENT_MANAGEMENT WHERE regno=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setString(1,regno);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				st.setRegNo(rs.getString("regno"));
				st.setName(rs.getString("name"));
				st.setDob(rs.getString("dob"));
				st.setEmail(rs.getString("email"));
				st.setMobile(rs.getString("mobile"));
				st.setDept(rs.getString("dept"));
				st.setF(true);
			}
			rs.close();
			ps.close();
			c.close();
			return st;
		}catch (Exception e){System.out.println(e);return st;}
	}
	public static void update(Student st)
	{
	try{
		Connection c=DbUtil.getConnection();
		PreparedStatement ps=c.prepareStatement("UPDATE STUDENT_MANAGEMENT "
				+ "SET NAME=?,DOB=?,DEPT=?,EMAIL=?,MOBILE=?"
				+ "WHERE REGNO=?");
		ps.setString(6, st.getRegNo());
		ps.setString(1, st.getName());
		ps.setString(2, st.getDob());
		ps.setString(3, st.getDept());
		ps.setString(4, st.getEmail());
		ps.setString(5, st.getMobile());
		int n=ps.executeUpdate();
		if(n==0)
			System.out.println("record is not inserted");
		else
			System.out.println("record is sucessfully inserted");
		ps.close();
		c.close();
	}catch (Exception e){System.out.println(e);}
	}
	public static void delete(String regno) 
	{
		try{
			Connection c= DbUtil.getConnection();
			String sql="DELETE FROM STUDENT_MANAGEMENT WHERE regno=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setString(1,regno);
			ps.executeUpdate();
			ps.close();
			c.close();
		}catch (Exception e){System.out.println(e);}
	}
	public static List<Student> select() throws Exception
	{
		List<Student> li=new ArrayList<Student>();
		Connection c= DbUtil.getConnection();
		String sql="SELECT * FROM STUDENT_MANAGEMENT";
		PreparedStatement ps=c.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Student st=new Student();
			st.setRegNo(rs.getString("regno"));
			st.setName(rs.getString("name"));
			st.setDob(rs.getString("dob"));
			st.setDept(rs.getString("dept"));
			st.setEmail(rs.getString("email"));
			st.setMobile(rs.getString("mobile"));
			li.add(st);
		}
		rs.close();
		ps.close();
		c.close();
		return li;
	}
}
