package com.EMS.DataAccessObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.EMS.Configuration.Configuration;
import com.EMS.DataTransferObject.DataTransferObject;
import com.EMS.Exception.EmployeeManagementSystemException;

public class DataAccessObject {

	static Scanner scan = new Scanner(System.in);

	static Configuration c1 = new Configuration();

	public boolean create(DataTransferObject dto) throws Exception, EmployeeManagementSystemException {

		try {
			PreparedStatement ps = c1.configure()
					.prepareStatement("insert into employeemanagementsystem values (?,?,?,?)");

			ps.setInt(1, dto.getId());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getDesignation());
			ps.setDouble(4, dto.getSalary());

			boolean x = ps.execute();

		} catch (SQLException e) {
			if ("23000".equals(e.getSQLState())) {

				throw new EmployeeManagementSystemException("ID is not unique.");
			} else {
				throw new EmployeeManagementSystemException("Server Error");
			}
		}
		return true;
	}

	public void readbyId(int id) throws EmployeeManagementSystemException, Exception {

		PreparedStatement ps = c1.configure().prepareStatement("select * from employeemanagementsystem where id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			System.out.println("------------------------------------------------------");
			System.out.println("Emp Name is:- " + rs.getString(2));
			System.out.println("Emp Degisation is:- " + rs.getString(3));
			System.out.println("Emp Salary is:- " + rs.getDouble(4));
			System.out.println("------------------------------------------------------");
		} else {
			throw new EmployeeManagementSystemException("ID not Found");
		}
	}

	public void readAll(DataTransferObject dto) throws Exception {
		PreparedStatement ps = c1.configure().prepareStatement("select * from employeemanagementsystem");

		ResultSet rs = ps.executeQuery();

		System.out.println("------------------------------------------------------");
		while (rs.next()) {
			System.out.println("Emp Id is:- " + rs.getInt(1));
			System.out.println("Emp Name is:- " + rs.getString(2));
			System.out.println("Emp Degisation is:- " + rs.getString(3));
			System.out.println("Emp Salary is:- " + rs.getDouble(4) + "\n");
			System.out.println("-----------------------------------------------------\n");
		}
	}

	public void updateName(int id, String name) throws SQLException, Exception {
		PreparedStatement ps = c1.configure().prepareStatement("update employeemanagementsystem set name=? where id=?");

		ps.setString(1, name);
		ps.setInt(2, id);

		ps.executeUpdate();

		ps.close();
		c1.configure().close();

	}

	public void updateDesignation(int id, String dgn) throws SQLException, Exception {
		PreparedStatement ps = c1.configure()
				.prepareStatement("update employeemanagementsystem set Desigantion=? where id=?");

		ps.setString(1, dgn);
		ps.setInt(2, id);

		ps.executeUpdate();

		ps.close();
		c1.configure().close();

	}

	public void updateSalary(int id, double salary) throws SQLException, Exception {

		PreparedStatement ps = c1.configure()
				.prepareStatement("update employeemanagementsystem set Salary=? where id=?");

		ps.setDouble(1, salary);
		ps.setInt(2, id);

		ps.executeUpdate();

		ps.close();
		c1.configure().close();

	}

	public void delete(int id) throws SQLException, Exception {

		String nme = null;

		try {
			PreparedStatement ps1 = c1.configure()
					.prepareStatement("select * from employeemanagementsystem where id=?");
			ps1.setInt(1, id);
			ResultSet rs = ps1.executeQuery();

			if (rs.next()) {
				nme = rs.getString(2);
			} else {
				throw new EmployeeManagementSystemException("Delete!!...");

			}

			PreparedStatement ps = c1.configure().prepareStatement("delete from employeemanagementsystem where id=?");

			ps.setInt(1, id);
			ps.executeUpdate();

			System.out.println(nme + "'s Details Deleted Successfully");

			ps.close();
			c1.configure().close();

		} catch (Exception e) {
			throw new EmployeeManagementSystemException("Delete ke liye ID nahi mila");

		}

	}

}
