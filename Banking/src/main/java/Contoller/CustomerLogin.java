package Contoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Customer_Dao;
import DTO.Customer;

@WebServlet("/customerlogin")
public class CustomerLogin extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String custid = req.getParameter("custid");
		String pwd = req.getParameter("pwd");

		long id = Long.parseLong(custid);

		Customer_Dao dao = new Customer_Dao();
		Customer customer = dao.fetchbyid(id);

		if (customer == null) {
			res.getWriter().print("<h1> You Entered Invalid Customer id </h1>");
			req.getRequestDispatcher("Customer_Login.html").include(req, res);

		} else {
			if (customer.getPwd().equals(pwd)) {

				res.getWriter().print("<h1>" + customer.getName() + "</h1>");
				// res.getWriter().print("<h1>Login Success</h1>");
				req.getSession().setAttribute("customer", customer);
				req.getRequestDispatcher("CustomerHome.html").include(req, res);

			} else {
				res.getWriter().print("<h1> You Entered Invalid Password</h1>");
				req.getRequestDispatcher("Customer_Login.html").include(req, res);

			}
		}

	}

}
