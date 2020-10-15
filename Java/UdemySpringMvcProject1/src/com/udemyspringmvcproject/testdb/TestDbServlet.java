package com.udemyspringmvcproject.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestDbServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String connectionString = 
				"jdbc:postgresql://localhost:5432/web_customer_tracker" +
				"?user=hbstudent&password=123698745&ssl=false";
		String driver = "org.postgresql.Driver";
		
		try {
			PrintWriter out = response.getWriter();
			
			out.println("Connection to database : " + connectionString);
			
			Class.forName(driver);
			
			Connection myConn = DriverManager.getConnection(connectionString);
			
			out.println("Connection successful : " + myConn.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
