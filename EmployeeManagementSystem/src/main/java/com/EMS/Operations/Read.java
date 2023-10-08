package com.EMS.Operations;

import java.util.Scanner;

import com.EMS.DataAccessObject.DataAccessObject;
import com.EMS.DataTransferObject.DataTransferObject;
import com.EMS.Exception.EmployeeManagementSystemException;

public class Read {
	static Scanner scan = new Scanner(System.in);
	static DataAccessObject dao = new DataAccessObject();
	static DataTransferObject dto = new DataTransferObject();

	public void read() throws Exception {
		System.out.println("Press 0 to get by Id and press 1 to get all employee details");

		switch (scan.nextInt()) {
		case 0:
			try {
				System.out.println("***Enter the Employee ID***");
				int id = scan.nextInt();

				dao.readbyId(id);

			} catch (EmployeeManagementSystemException e) {
				System.out.println(e.getMsg());
			}

			break;

		case 1:
			dao.readAll(dto);

			break;

		default:
			System.out.println("Invalid Input");

			break;

		}
	}
}
