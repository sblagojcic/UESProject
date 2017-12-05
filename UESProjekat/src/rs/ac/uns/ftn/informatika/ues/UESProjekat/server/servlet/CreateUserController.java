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

public class CreateUserController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(CreateUserController.class);
	
	@EJB
	private CategoryDaoLocal categoryDaoLocal;
	@EJB
	private UserDaoLocal userDaoLocal;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			
			String firstName = null;
			String lastName = null;
			String userName = null;
			String password = null;
			Integer categoryId = null;
			String type = null;
			
			if ((request.getSession().getAttribute("admin")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
				return;
			}
			
			if ((request.getParameter("type") != null) && (!"".equals(request.getParameter("type")))) {
				type = request.getParameter("type");
			}
			
			if ((request.getParameter("firstName") != null) && (!"".equals(request.getParameter("firstName")))) {
				firstName = request.getParameter("firstName");
			}
			
			if ((request.getParameter("lastName") != null) && (!"".equals(request.getParameter("lastName")))) {
				lastName = request.getParameter("lastName");
			}
			
			if ((request.getParameter("category") != null) && (!"".equals(request.getParameter("category")))) {
				categoryId = new Integer(request.getParameter("category"));
			}
			
			if ((request.getParameter("userName") != null) && (!"".equals(request.getParameter("userName")))) {
				userName = request.getParameter("userName");
			}
			
			if ((request.getParameter("password") != null) && (!"".equals(request.getParameter("password")))) {
				password = request.getParameter("password");
			}
			
			User u = new User();
			
			if(firstName != null)
				u.setFirstName(firstName);
		
			if(lastName != null)
				u.setLastName(lastName);
			
			if(userName != null)
				u.setUserName(userName);
			
			if(type != null)
				u.setType(type);
			
			if (categoryId != null)
				u.setCategory(categoryDaoLocal.findById(categoryId));
			
			if(password != null)
				u.setPassword(password);
			
			userDaoLocal.persist(u);
			
			getServletContext().getRequestDispatcher("/ReadUserController").forward(request, response);
			return;
			
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
