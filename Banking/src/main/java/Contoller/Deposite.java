package Contoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Bank_Dao;
import DTO.BankAccount;

@WebServlet("/deposit")
public class Deposite extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		double amount = Double.parseDouble(req.getParameter("amount"));

		long acno = (long) req.getSession().getAttribute("acno");

		Bank_Dao bankdao = new Bank_Dao();

		BankAccount bankaccount = bankdao.fetchByAccno(acno);

		bankaccount.setAmount(bankaccount.getAmount() + amount); // before putting any data inside database we should set the data

		bankdao.update(bankaccount);

		res.getWriter().print("<h1>Amount has been deposited succesfully</h1>");
		res.getWriter().print("<h1>Updated Balance " + bankdao.fetchByAccno(acno).getAmount() + "</h1>");

	}

}
