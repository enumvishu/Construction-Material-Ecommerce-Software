package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataAccessObject.Company_DAO;
import DataTransferObject.Company;

@WebServlet("/companylogin")
public class CompanyLogIn extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		long id = Long.parseLong(req.getParameter("id"));
		String pwd = req.getParameter("pwd");

		Company_DAO dao = new Company_DAO();

		Company company = dao.checkbyid(id);

		if (company != null) {

			if (company.getPassword().equals(pwd)) {

				res.getWriter().print("<h1> Dear, " + company.getName() + " login success</h1>");

				req.getSession().setAttribute("company", company);
				req.getRequestDispatcher("CompanyHome.html").include(req, res);

			} else {
				res.getWriter().print("<h1>Username and password is not matching</h1>");

			}

		} else {
			res.getWriter().print("<h1>Invalid Credntial</h1>");

		}

	}

}
