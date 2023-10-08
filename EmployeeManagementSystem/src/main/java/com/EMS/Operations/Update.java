package com.EMS.Operations;

import java.util.Scanner;

import com.EMS.DataAccessObject.DataAccessObject;
import com.EMS.DataTransferObject.DataTransferObject;
import com.EMS.Exception.EmployeeManagementSystemException;

public class Update {
	static Scanner scan = new Scanner(System.in);
	static DataAccessObject dao = new DataAccessObject();
	static DataTransferObject dto = new DataTransferObject();

	public void update() throws Exception {
		int ID = 0;

		try {
			System.out.println("***Enter the Employee ID***");
			int id = scan.nextInt();
			ID = id;
			dao.readbyId(id);

			System.out.println("\nChoose what you want to update \n1.Name\n2.Designation \n3.Salary");
		}

		catch (EmployeeManagementSystemException e) {
			System.out.println(e.getMsg());
		}

		// Inner switch condition for update particular
		switch (scan.nextInt()) {

		case 1:
			System.out.println("Enter the Updated Name of Employee");
			String nm = scan.next();
			dao.updateName(ID, nm);

			dao.readbyId(ID);

			break;

		case 2:
			System.out.println("Enter the Updated Designation of Employee");
			String dgn = scan.next();
			dao.updateDesignation(ID, dgn);

			dao.readbyId(ID);

			break;

		case 3:
			System.out.println("Enter the Updated Salary of Employee");
			double salary = scan.nextDouble();
			dao.updateSalary(ID, salary);

			dao.readbyId(ID);

			break;

		default:
			System.out.println("Invalid Input");
			break;
		}

	}

}
