package Controllers;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;



import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import Dao.UserDao;
import DaoImpl.UserDaoImpl;
import Model.User;




@Controller
public class RegisterController {

	
	HashMap regusers;
	
	public RegisterController()
	{
	regusers=new  HashMap();	
	}
	
	
	@RequestMapping(value="/register",method = RequestMethod.GET)
	 public String register( )
	 {
		 return "register";
	 }
	 
	 @RequestMapping(value="/register",method = RequestMethod.POST)
	 public ModelAndView register(@ModelAttribute User user,HttpServletRequest request,HttpServletResponse response )
	 {
		 ServletContext servletcontext = request.getServletContext();

		  XmlWebApplicationContext context = new XmlWebApplicationContext();

		  context.setServletContext(servletcontext);

		  context.setConfigLocations(new String[]{"/WEB-INF/Skimmdit-servlet.xml"});

		  context.refresh();

		  context.start();
		 UserDao dao=(UserDaoImpl)context.getBean("userDao");
		 
		 if(dao.checkUser(user.getUserName(), regusers))
		 {
			 request.setAttribute("register", "exist");
			 return new ModelAndView("register");
		 }
		 else 
		 {
			 regusers=dao.createUser(regusers,user);
			 request.getServletContext().setAttribute("map", regusers);
			 request.setAttribute("register", "success");
			 HttpSession session=request.getSession();
			 session.setAttribute("usersession", user.getUserName());
			 return new ModelAndView("Profile");	
		 }
			 
	 }
	 
	 
}
