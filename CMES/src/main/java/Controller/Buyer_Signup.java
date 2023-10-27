package Controller;

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

import DataAccessObject.Buyer_DAO;
import DataTransferObject.Buyer;

@WebServlet("/buyersignup")
public class Buyer_Signup extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String custname = req.getParameter("custname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		String dob = req.getParameter("dob");

		long cusmobile = Long.parseLong(req.getParameter("mobile"));

		Buyer buyer = new Buyer();
		Buyer_DAO buyer_dao = new Buyer_DAO();

		Date date = Date.valueOf(dob);

		Period period = Period.between(date.toLocalDate(), LocalDate.now());

		int age = period.getYears();

		if (age <= 21) {
			res.getWriter().print("<h1> He is not eligible to create account </h1>");
		} else {

			List<Buyer> list1 = buyer_dao.fetch(cusmobile);
			List<Buyer> list2 = buyer_dao.fetch(email);

			// if (list1.isEmpty() && list2.isEmpty()) {

			buyer.setName(custname);
			buyer.setEmail(email);
			buyer.setPwd(password);
			buyer.setGender(gender);
			buyer.setDob(date);
			buyer.setMob(cusmobile);

			buyer_dao.save(buyer);

			Buyer fetchdetails = buyer_dao.fetch(email).get(0);

			long custid = fetchdetails.getBuyerid();

			if (fetchdetails.getGender().equals("Male")) {
				res.getWriter().print("<h1> Hello Sir,  Account is Created Sucessfully. Kindly Note your ID for further use:- " + custid + " </h1>");
				req.getRequestDispatcher("Home.html").include(req, res);

			} else {
				res.getWriter().print("<h1> Hello Ma'am, Account is Created Sucessfully.  Kindly Note your ID for further use:- " + custid + " </h1>");
				req.getRequestDispatcher("Home.html").include(req, res);

			}
		}
	}
}
