package com.akushwah.camel.sample.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectDatabase {

	public static Connection getConnection() {
		Connection con = null;

		try {
			// Registering the HSQLDB JDBC driver
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			// Creating the connection with HSQLDB
			con = DriverManager.getConnection("jdbc:hsqldb:MyDB", "sa", "sa");

		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

		return con;
	}
	
	public static void insert(int a, int b, String s ) {
		Connection con = getConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement("insert into 'MYKILLERAPP.AAKASHTABLE' values (?,?,?);");
			preparedStatement.setInt(1, a);
			preparedStatement.setInt(2, b);
			preparedStatement.setString(3, s);
			preparedStatement.executeQuery();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Connection con = null;

		try {
			// Registering the HSQLDB JDBC driver
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			// Creating the connection with HSQLDB
			con = DriverManager.getConnection("jdbc:hsqldb:MyDB", "sa", "sa");
			// con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/SAMPLE",
			// "sa", "sa");

			if (con != null) {
				System.out.println("Connection created successfully");

			} else {
				System.out.println("Problem with creating connection");
			}

		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
}
