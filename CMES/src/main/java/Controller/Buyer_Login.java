package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataAccessObject.Buyer_DAO;
import DataTransferObject.Buyer;

@WebServlet("/buyerlogin")
public class Buyer_Login extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String custid = req.getParameter("custid");
		String pwd = req.getParameter("pwd");

		long id = Long.parseLong(custid);

		Buyer_DAO dao = new Buyer_DAO();
		Buyer buyer = dao.fetchbyid(id);

		if (buyer == null) {
			res.getWriter().print("<h1> You Entered galat Buyer id </h1>");
			req.getRequestDispatcher("CustomerHome.html").include(req, res);

		} else {

			if (buyer.getPwd().equals(pwd)) {

				res.getWriter().print("<h1>" + buyer.getName() + "</h1>");
				// res.getWriter().print("<h1>Login Success</h1>");
				req.getSession().setAttribute("buyer", buyer);
				req.getRequestDispatcher("CustomerHome.html").include(req, res);

			} else {
				res.getWriter().print("<h1> You Entered Invalid Password</h1>");
				req.getRequestDispatcher("Customer_Login.html").include(req, res);

			}
		}

	}

}
