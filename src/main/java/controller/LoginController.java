package controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.catalina.User;
import org.apache.tomcat.util.http.parser.Host;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import restaurent_management_system.model.entity.Users;
import service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	Users user;
	
	@Autowired
	LoginService lService;
	
	@PostMapping("/login_validate")
public void  loginValidate(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
	Integer id=Integer.parseInt(req.getParameter("id"));
	String password=req.getParameter("password");
	
	user.setId(id);
	user.setPassword(password);
	PrintWriter pw=res.getWriter();
	Users result=lService.loginValidate(user);
	RequestDispatcher fail=req.getRequestDispatcher("Home.jsp");
	
	if(result!=null) {
		if(result.getRole().equals("manager")){
				HttpSession session =req.getSession();
				session.setAttribute("user", result);
				RequestDispatcher manager=req.getRequestDispatcher("manager_operation.jsp");
				manager.forward(req, res);
	}
	
	
	}
	fail.include(req, res);
	pw.print("Invalid Id or Password");
	}
}
