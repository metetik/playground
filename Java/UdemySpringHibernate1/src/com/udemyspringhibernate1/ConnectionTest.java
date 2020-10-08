package com.udemyspringhibernate1;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {
	public static void main(String[] args) {
		String connectionString = 
				"jdbc:postgresql://localhost:5432/hb_one_to_one" +
				"?user=hbstudent&password=123698745&ssl=false";
		try {
			Connection conn = DriverManager.getConnection(connectionString);
			System.out.print("Connection Successfull : ");
			System.out.println(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}