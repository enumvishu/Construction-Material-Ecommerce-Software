package Contoller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Bank_Dao;
import DAO.Customer_Dao;
import DTO.BankAccount;
import DTO.Customer;

@WebServlet("/createbankaccount")
public class CreateBankAccount extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String acctype = req.getParameter("acctype");

		Customer customer = (Customer) req.getSession().getAttribute("customer");
		List<BankAccount> list1 = customer.getAccount();
		boolean flag = true;

		for (BankAccount bankaccount : list1) {
			if (bankaccount.getAccountType().equals(acctype)) {
				res.getWriter().print("<h1>Account Already Exist</h1>");
				flag = false;

			}
		}

		if (flag) {
			BankAccount bankaccount = new BankAccount();
			// bankaccount.setAccountNo(); --> it will generate automatically
			// bankaccount.setAccountLimit()-->
			// bankaccount.setStatus();

			bankaccount.setAccountType(acctype);
			bankaccount.setCustomer(customer);

			if (bankaccount.getAccountType().equals("saving")) {
				bankaccount.setAccountLimit(10000);

			} else {
				bankaccount.setAccountLimit(15000);
			}

			Bank_Dao bankdao = new Bank_Dao();
			bankdao.save(bankaccount);

			List<BankAccount> list2 = list1; // saving
			list2.add(bankaccount); // saving+current
			customer.setAccount(list2);

			Customer_Dao customerdao = new Customer_Dao();
			customerdao.update(customer);

			res.getWriter().print("<h1>Account has been created successfully</h1>");
			res.getWriter().print("<h1>Wating for Manager Approval</h1>");

		}
	}

}
