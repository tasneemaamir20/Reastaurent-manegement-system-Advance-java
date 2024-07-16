package controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import restaurent_management_system.model.entity.Users;
import service.ManagerService;

@Controller
public class ManagerController {
	@Autowired
	ManagerService mService;
	@Autowired
	Users staff;
	
	@GetMapping("/get_all_staff")
		public String get_all_staff(HttpServletRequest req) {
			HttpSession session=req.getSession();
			Users user=(Users)session.getAttribute("user");
			
			List<Users> staffs=mService.get_all_staff(user);
			req.setAttribute("staffs", staffs);
			
			return "get_all_staffs.jsp";
		}
	
	@PostMapping("/add_staff")
	public void add_staff(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		String name=req.getParameter("name");
				String email=req.getParameter("email");
				String password=req.getParameter("password");
				
				String role=req.getParameter("role");
				
				HttpSession session =req.getSession();
				Users user=(Users)session.getAttribute("user");
				
				staff.setName(name);
				staff.setEmail(email);
				staff.setPassword(password);
				staff.setRole(role);
				staff.setBranch(user.getBranch());
				
				ServletContext context=req.getServletContext();
				
				if(mService.add_staff(staff)) {
					context.setAttribute("message", "Staff added successfully!");
					
				}else {
					context.setAttribute("message", "Fail to add Staff!");
				}
				res.sendRedirect("get_all_staff");
	}
}
