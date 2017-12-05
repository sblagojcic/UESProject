package rs.ac.uns.ftn.informatika.ues.UESProjekat.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity.User;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session.CategoryDaoLocal;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session.UserDaoLocal;

public class UpdatePersonalInfoController extends HttpServlet {
	
	private static Logger log = Logger.getLogger(UpdatePersonalInfoController.class);
	private static final long serialVersionUID = -7380512096571638502L;
	
	@EJB
	private UserDaoLocal userDaoLocal;
	
	@EJB
	private CategoryDaoLocal categoryDaoLocal;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			
			String id = null;
			String firstName = null;
			String lastName = null;
			String userName = null;
			String password = null;

			
			if ((request.getSession().getAttribute("admin")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
		    	return;
		    }
			
			id = request.getParameter("id");
			
			if ((request.getParameter("firstName") != null) && (!"".equals(request.getParameter("firstName")))) {
				firstName = request.getParameter("firstName");
			}
			if ((request.getParameter("lastName") != null) && (!"".equals(request.getParameter("lastName")))) {
				lastName = request.getParameter("lastName");
			}
			if ((request.getParameter("userName") != null) && (!"".equals(request.getParameter("userName")))) {
				userName = request.getParameter("userName");
			}
			if ((request.getParameter("password") != null) && (!"".equals(request.getParameter("password")))) {
				password = request.getParameter("password");
			}
		
			
			if((id != null) && (!id.equals(""))){
				User u = new User();
				
				u.setId(new Integer(id));
				
				if(firstName != null){
					u.setFirstName(firstName);
			}
				if(lastName != null){
					u.setLastName(lastName);
			}
				if(userName != null){
					u.setUserName(userName);
			}
				if(password != null){
					u.setPassword(password);
			}
				
				userDaoLocal.merge(u);
				
			}
			getServletContext().getRequestDispatcher("/MainController").forward(request, response);
		}catch (ServletException e) {
			log.error(e);
			throw e;
		} catch (IOException e) {
			log.error(e);
			throw e;
		} 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
