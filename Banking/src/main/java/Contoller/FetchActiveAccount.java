package Contoller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.BankAccount;
import DTO.Customer;

@WebServlet("/fetchactiveaccount")
public class FetchActiveAccount extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Customer customer = (Customer) req.getSession().getAttribute("customer");

		List<BankAccount> list1 = customer.getAccount();
		List<BankAccount> list2 = new ArrayList<BankAccount>();

		for (BankAccount bankAccount : list1) {

			if (bankAccount.isStatus()) {

				list2.add(bankAccount);

				res.getWriter().print("<h1>Active Accounts Found</h1>");

			}
			req.getSession().setAttribute("list", list2);

			req.getRequestDispatcher("Account.jsp").include(req, res);

		}

	}

}
