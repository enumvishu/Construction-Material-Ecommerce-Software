package com.EMS.Operations;

import java.util.Scanner;

import com.EMS.DataAccessObject.DataAccessObject;
import com.EMS.DataTransferObject.DataTransferObject;
import com.EMS.Exception.EmployeeManagementSystemException;

public class Insertation {
	static Scanner scan = new Scanner(System.in);

	static DataAccessObject dao = new DataAccessObject();
	static DataTransferObject dto = new DataTransferObject();

	public void Create() throws Exception {

		try {
			int adding = 0;

			while (adding == 0) {
				System.out.println("***Enter the Employee ID***");

				int id = scan.nextInt();
				dto.setId(id);

				System.out.println("***Enter the Employee Name***");
				String name = scan.next();
				dto.setName(name);

				System.out.println("***Enter the Employee Designation***");
				dto.setDesignation(scan.next());

				System.out.println("***Enter the Employee Salary***");
				dto.setSalary(scan.nextDouble());

				boolean validate = dao.create(dto);

				if (validate == false) {

					System.out.println(name + "'s details added sucessfully");

					dao.readbyId(id);
				}

				System.out.println("\nDo you want to perform further operation press 0 or press 1 for exit");
				adding = scan.nextInt();

				if (adding == 1) {
					System.out.println("Thank You!!...");

				}
			}
		} catch (EmployeeManagementSystemException e) {
			System.out.println(e.getMsg());
		}

	}
}
