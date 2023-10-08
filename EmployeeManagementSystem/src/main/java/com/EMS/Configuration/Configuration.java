package com.EMS.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class Configuration {

	public Connection configure() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem", "root",
				"2580");

		return con;

	}

}
