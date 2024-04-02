package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import dao.Dao;
import dto.User;

@WebServlet("/Gotosignup")
@MultipartConfig(maxFileSize=1*1024*1024)
public class SaveUser extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		long contact =Long.parseLong(req.getParameter("contact"));
		String password=req.getParameter("password");
		
//		to get the image file 
		Part imagepart=req.getPart("image");
		byte[] imagebyte=imagepart.getInputStream().readAllBytes();
		
		User user= new User(id,name,email,contact,password,imagebyte);
		
		Dao dao=new Dao();
		
		try {
			int res=dao.saveData(user);
			if(res>0)
			{
				resp.sendRedirect("Login.jsp");
			}
			else {
				resp.sendRedirect("Signup.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
