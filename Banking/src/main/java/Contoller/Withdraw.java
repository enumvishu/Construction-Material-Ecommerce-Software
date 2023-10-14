package Contoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Bank_Dao;
import DTO.BankAccount;

@WebServlet("/withdraw")
public class Withdraw extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		double amount = Double.parseDouble(req.getParameter("amount"));

		long acno = (long) req.getSession().getAttribute("acno");

		Bank_Dao bankdao = new Bank_Dao();

		BankAccount bankaccount = bankdao.fetchByAccno(acno);

		if (bankaccount.getAmount() < amount) {
			res.getWriter().print("<h1>Insufficient Balance</h1>");

		} else {

			if (amount > bankaccount.getAccountLimit()) {
				res.getWriter().print("<h1>Limit Excedded</h1>");
			} else {

				bankaccount.setAmount(bankaccount.getAmount() - amount); // before putting any data inside database we should set the data

				bankdao.update(bankaccount);

				res.getWriter().print("<h1>Amount has been Withdrawn succesfully</h1>");
				res.getWriter().print("<h1>Updated Balance " + bankdao.fetchByAccno(acno).getAmount() + "</h1>");

			}
		}
	}
}
