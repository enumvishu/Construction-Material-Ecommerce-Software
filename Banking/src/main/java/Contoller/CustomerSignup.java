package Contoller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Customer_Dao;
import DTO.Customer;

@WebServlet("/customersignup")
public class CustomerSignup extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String custname = req.getParameter("custname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		String dob = req.getParameter("dob");

		long cusmobile = Long.parseLong(req.getParameter("mobile"));

		Customer customer = new Customer();
		Customer_Dao cust_dao = new Customer_Dao();

		Date date = Date.valueOf(dob);

		Period period = Period.between(date.toLocalDate(), LocalDate.now());

		int age = period.getYears();

		if (age < 18) {
			res.getWriter().print("<h1> He is not eligible to create account </h1>");
		} else {

			List<Customer> list1 = cust_dao.fetch(cusmobile);
			List<Customer> list2 = cust_dao.fetch(email);

			// if (list1.isEmpty() && list2.isEmpty()) {

			customer.setName(custname);
			customer.setEmail(email);
			customer.setPwd(password);
			customer.setGender(gender);
			customer.setDob(date);
			customer.setMob(cusmobile);

			cust_dao.save(customer);

			Customer fetchdetails = cust_dao.fetch(email).get(0);

			long custid = fetchdetails.getCustid();

			if (fetchdetails.getGender().equals("Male")) {
				res.getWriter().print("<h1> Hello Sir, Account is Created Sucessfully. Kindly Note your ID for further use:- " + custid + " </h1>");
				req.getRequestDispatcher("Home.html").include(req, res);

			} else {
				res.getWriter().print("<h1> Hello Ma'am, Account is Created Sucessfully. Kindly Note your ID for further use:- " + custid + " </h1>");
				req.getRequestDispatcher("Home.html").include(req, res);

			}

//			} else {
//				res.getWriter().print("<h1> Account already Exist </h1>");
//
//			}
		}
	}

}
