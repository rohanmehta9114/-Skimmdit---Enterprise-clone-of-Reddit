package Controllers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import Dao.LinksDao;
import DaoImpl.LinksDaoImpl;
import Model.UserLinks;


@Controller
public class LinkController {

	HashMap userlinks;
	
	public LinkController()
	{
		userlinks=new HashMap();
	}
	
	
	@RequestMapping(value="/submitlink",method = RequestMethod.GET)
	 public String submitlink( )
	 {
		return "SubmitLink";
	 }
	
	@RequestMapping(value="/LikeLink",method = RequestMethod.GET)
	 public String likeLink(@RequestParam("linkid") String link,@RequestParam("username") String user,HttpServletRequest request,HttpServletResponse response )
	 {
		HttpSession session=(HttpSession)request.getSession();
		if(session.getAttribute("usersession")!=null)
		{	
		
			ServletContext servletcontext = request.getServletContext();

			  XmlWebApplicationContext context = new XmlWebApplicationContext();

			  context.setServletContext(servletcontext);

			  context.setConfigLocations(new String[]{"/WEB-INF/Skimmdit-servlet.xml"});

			  context.refresh();

			  context.start();
		 
		 LinksDao dao=(LinksDaoImpl)context.getBean("linksDao");
		 
		 String likepage=dao.likeLink(link, user,userlinks);
		
		 return "Profile";
		}
		else
		{	
		return "register";
		}
	 }
	
	@RequestMapping(value="/DisLikeLink",method = RequestMethod.GET)
	 public String disLikeLink(@RequestParam("linkid") String link,@RequestParam("username") String user,HttpServletRequest request,HttpServletResponse response )
	 {
		HttpSession session=(HttpSession)request.getSession();
		if(session.getAttribute("usersession")!=null)
		{	
		
			ServletContext servletcontext = request.getServletContext();

			  XmlWebApplicationContext context = new XmlWebApplicationContext();

			  context.setServletContext(servletcontext);

			  context.setConfigLocations(new String[]{"/WEB-INF/Skimmdit-servlet.xml"});

			  context.refresh();

			  context.start();
			  
		 LinksDao dao=(LinksDaoImpl)context.getBean("linksDao");
		 
		 String likepage=dao.disLikeLink(link, user,userlinks);
		 
		 return "Profile";
		}
		else
		{	
		return "register";
		}
	 }
	 
	 @RequestMapping(value="/submitlink",method = RequestMethod.POST)
	 public ModelAndView submitlink(UserLinks links,HttpServletRequest request)
	 {
			
			HttpSession usersession=request.getSession();
			String username=(String)usersession.getAttribute("usersession");
			links.setUsername(username);
			links.setVoteBy(username);
			UUID linkid=UUID.randomUUID();
			links.setLinkId(linkid);
			userlinks.put(linkid,links);
			request.getServletContext().setAttribute("maplink",userlinks);
			return new ModelAndView("Profile");
			
	 }
	 
	 
	 @RequestMapping(value = "/sortedlinks", method = RequestMethod.GET)
	 public @ResponseBody
	 String sortedArticles(HttpServletRequest request,HttpServletResponse response)
	 {
		 HttpSession mysession=request.getSession();
		 String user="";
		 String opt="";
		 if(mysession.getAttribute("usersession")!=null)
		 {

		 user=(String)mysession.getAttribute("usersession");
		 	
		 }
		 
		 if(request.getServletContext().getAttribute("maplink")!=null)
		 {
			 opt+="<table width='70%' border='1px' cellpadding='3' cellspacing='3'style='background-color:#0CF;border-collapse:collapse;border:1px solid #000;color:#000000;width:'100%'><tr><td>Like</td><td>Dislike</td><td>Title</td><td>Link</td><td>No of Votes</td></tr>";
			 HashMap sorted_map=null;
			 Iterator it;
			 HashMap mymap=(HashMap)request.getServletContext().getAttribute("maplink");
			 ServletContext servletcontext = request.getServletContext();

			  XmlWebApplicationContext context = new XmlWebApplicationContext();

			  context.setServletContext(servletcontext);

			  context.setConfigLocations(new String[]{"/WEB-INF/Skimmdit-servlet.xml"});

			  context.refresh();

			  context.start();
				 
			 LinksDao dao=(LinksDaoImpl)context.getBean("linksDao");
	
			 TreeMap sortedmap=dao.getSortedmap(mymap);
			 Set keys = sortedmap.keySet();
		   	 	for (Iterator i = keys.iterator(); i.hasNext();) 
		   	 	{
		   	 		String key1 =  i.next().toString();
			  		UUID uid = UUID.fromString(key1); 
						   UserLinks dao1=(UserLinks)mymap.get(uid);
						   if(user!="")
						   {
						   opt+="<tr><td><center><a href='LikeLink?linkid="+key1+"&username="+user+"'  ><img src='resources/images/arrow-top-3x.png' /></a></center><td><center><a href='DisLikeLink?linkid="+key1+"&username="+user+"'><img src='resources/images/arrow-bottom-3x.png' /></a></center></td><td><center>"+dao1.getTitle()+"</center></td><td><center><a href='"+dao1.getUrl()+"' target='blank'>"+dao1.getUrl()+"</a></center></td><td><center>"+dao1.getVotecounter()+"</center></td></tr>";
						   }
						   else
						   {
							   opt+="<tr><td><center><a><img src='resources/images/arrow-top-3x.png' /></a></center><td><center><a><img src='resources/images/arrow-bottom-3x.png' /></a></center></td><td><center>"+dao1.getTitle()+"</center></td><td><center><a href='"+dao1.getUrl()+"'  target='blank'>"+dao1.getUrl()+"</a></center></td><td><center>"+dao1.getVotecounter()+"</center></td></tr>";
						   }
		   	 	}
						  
		   	 opt+="</table>";
		 }				 
		return opt;
	 }	
}