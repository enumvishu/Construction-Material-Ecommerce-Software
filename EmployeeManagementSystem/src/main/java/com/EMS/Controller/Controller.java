package com.EMS.Controller;

import java.util.Scanner;

import com.EMS.DataAccessObject.DataAccessObject;
import com.EMS.DataTransferObject.DataTransferObject;
import com.EMS.Operations.Delete;
import com.EMS.Operations.Insertation;
import com.EMS.Operations.Read;
import com.EMS.Operations.Update;

public class Controller {

	static Scanner scan = new Scanner(System.in);

	static DataAccessObject dao = new DataAccessObject();
	static DataTransferObject dto = new DataTransferObject();
	static Insertation insertation = new Insertation();
	static Update update = new Update();
	static Read read = new Read();
	static Delete delete = new Delete();

	public static void main(String[] args) throws Exception {

		int count = 0;
		while (count == 0) {

			System.out.println("***Welcome to Employee Management System*** \n");

			System.out.println(
					"What Operation you want to perform " + "\n1.Create " + "\n2.Read " + "\n3.Update" + "\n4.Delete");

			switch (scan.nextInt()) {
			case 1:
				insertation.Create();

				break;

			case 2:
				read.read();

				break;

			case 3:
				update.update();

				break;

			case 4:
				delete.delete();

				break;

			default:
				System.out.println("Invalid Input");
				break;
			}
		}

		System.out.println("\nThank You for Using Employee Managaement System");

	}
}
