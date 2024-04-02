package controller;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import dto.User;

@WebServlet("/GotoLoginjsp")
public class Loginuser extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Dao dao=new Dao();
		try {
			User u1= dao.findByEmail(email);
			if(u1.getUserpassword().equals(password))
			{
				HttpSession session=req.getSession();
				session.setAttribute("user", u1);
				req.getRequestDispatcher("homepage.jsp").include(req, resp);
			}
			else
			{
				req.setAttribute("display message", "passwordis wrong");
				req.getRequestDispatcher("Login.jsp").include(req, resp);
			}
		} 
		catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}
}
