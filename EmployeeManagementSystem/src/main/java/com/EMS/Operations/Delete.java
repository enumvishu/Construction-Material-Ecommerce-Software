package com.EMS.Operations;

import java.util.Scanner;

import com.EMS.DataAccessObject.DataAccessObject;
import com.EMS.DataTransferObject.DataTransferObject;
import com.EMS.Exception.EmployeeManagementSystemException;

public class Delete {
	static Scanner scan = new Scanner(System.in);
	static DataAccessObject dao = new DataAccessObject();
	static DataTransferObject dto = new DataTransferObject();

	public void delete() throws Exception {
		try {
			System.out.println("***Enter the Employee ID***");
			int id = scan.nextInt();

			dao.delete(id);

		}

		catch (EmployeeManagementSystemException e) {
			System.out.println(e.getMsg());
		}

	}

}
