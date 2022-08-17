package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register2Demo
 */
public class Register2Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register2Demo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Name = request.getParameter("Name");
		String age = request.getParameter("age");
		String salary = request.getParameter("salary");
		String designation = request.getParameter("designation");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployee","root","Tiger@123");
			PreparedStatement stmt = con.prepareStatement("insert into emp1 values(?,?,?,?)");
			stmt.setString(1,Name);
			stmt.setString(2,age);
			stmt.setString(3,salary);
			stmt.setString(4,designation);
			stmt.execute();
			stmt.close();
			con.close();
			System.out.println("data inserted.......");
			response.setContentType("text/html");
			PrintWriter p = response.getWriter();
			p.print("<h3>Data inserted successfully to MySQL Command Line</h3>");
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
