package Controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataAccessObject.Company_DAO;
import DataTransferObject.Company;

@WebServlet("/companysignup")
public class CompanySignUP extends HttpServlet {

	Company dto = new Company();

	Company_DAO dao = new Company_DAO();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String name = req.getParameter("name");
		String pan = req.getParameter("pan");
		long mob = Long.parseLong(req.getParameter("mob"));
		String email = req.getParameter("email");
		long regst_no = Long.parseLong(req.getParameter("regst"));
		String type = req.getParameter("type");
		Date date = Date.valueOf(req.getParameter("regstdate"));
		String pwd = req.getParameter("pwd");

		List<Company> company_email = dao.check1(email);
		List<Company> company_mob = dao.check1(mob);

		List<Company> company_pan = dao.check2(pan);
		List<Company> company_regstno = dao.check2(regst_no);

		if (company_email.isEmpty() && company_mob.isEmpty() && company_pan.isEmpty() && company_regstno.isEmpty()) {

			dto.setName(name);
			dto.setPAN(pan);
			dto.setMobile(mob);
			dto.setEmail(email);
			dto.setRegistration_No(regst_no);
			dto.setCompany_Type(type);
			dto.setRegistration_Date(date);
			dto.setPassword(pwd);
			dao.save(dto);

			res.getWriter().print("<h1> Successfully Registred Kindly Note down id for further opration.</h1>");
			res.getWriter().print("<h1>" + dto.getId() + "</h1>");

		} else {
			res.getWriter().print("<h1> Account already Exist </h1>");

		}

	}

}
