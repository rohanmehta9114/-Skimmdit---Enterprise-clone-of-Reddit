package Controllers;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import Dao.UserDao;
import DaoImpl.UserDaoImpl;
import Model.User;

@Controller
public class LoginController {

	
	@RequestMapping(value="Login",method = RequestMethod.GET)
	 public String Login( )
	 {
		 return "register";
	 }
	 
	 @RequestMapping(value="/Login",method = RequestMethod.POST)
	 public ModelAndView Login(User user,HttpServletRequest request,HttpServletResponse response,ModelMap model )
	 {
		 
		 HashMap map=(HashMap)request.getServletContext().getAttribute("map");
		 
		 ServletContext servletcontext = request.getServletContext();

		  XmlWebApplicationContext context = new XmlWebApplicationContext();

		  context.setServletContext(servletcontext);

		  context.setConfigLocations(new String[]{"/WEB-INF/Skimmdit-servlet.xml"});

		  context.refresh();

		  context.start();
		 
		 UserDao dao=(UserDaoImpl)context.getBean("userDao");
		 
		 if(dao.checkUser(user.getUserName(), map))
		 {
			 
			 if(dao.authenticateUser(map,user))
			 {
				 
				HttpSession session=request.getSession();
				session.setAttribute("usersession", user.getUserName());
				model.addAttribute(map);
				return new ModelAndView("Profile","Command",model); 
			 }
			 else
			 {	
				 request.setAttribute("register", "authfailed");
			 }
			 
			 return new ModelAndView("register");

			  }
		 	else{
			 
			 request.setAttribute("register", "newuser");
			 return new ModelAndView("register"); 
		 
		 		}
		 	 		
	 }

}
