package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterDemo
 */
public class RegisterDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterDemo() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ID = request.getParameter("ID");
		String Name = request.getParameter("Name");
		String age = request.getParameter("age");
		String salary = request.getParameter("salary");
		String Designation = request.getParameter("Designation");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployee","root","Tiger@123");
			PreparedStatement stmt = con.prepareStatement("insert into emp2 values(?,?,?,?,?)");
			stmt.setString(1,ID);
			stmt.setString(2,Name);
			stmt.setString(3,age);
			stmt.setString(4,salary);
			stmt.setString(5,Designation);
			stmt.execute();
			stmt.close();
			con.close();
			System.out.println("data inserted.......");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
