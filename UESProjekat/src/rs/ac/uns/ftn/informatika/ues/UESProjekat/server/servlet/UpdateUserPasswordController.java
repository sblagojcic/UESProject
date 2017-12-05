package rs.ac.uns.ftn.informatika.ues.UESProjekat.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity.User;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session.UserDaoLocal;


public class UpdateUserPasswordController extends HttpServlet {

	private static Logger log = Logger.getLogger(UpdateUserPasswordController.class);
	private static final long serialVersionUID = -7380512096571638502L;
	
	@EJB
	private UserDaoLocal userDaoLocal;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			
			String id = null;
			String password = null;
			String repeatedPassword = null;
			
			if ((request.getSession().getAttribute("admin")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
		    	return;
		    }
			
			
			id = request.getParameter("id");
			
			if ((request.getParameter("password") != null) && (!"".equals(request.getParameter("password")))) {
				password = request.getParameter("password");
			}
			
			if ((request.getParameter("repeatedPassword") != null) && (!"".equals(request.getParameter("repeatedPassword")))) {
				repeatedPassword = request.getParameter("repeatedPassword");
			}
			 	
				if((id!=null) && (!id.equals(""))){
					
					User u = new User();
					u.setId(new Integer(id));
				
					if(password!=null)
						u.setPassword(password);
					userDaoLocal.merge(u);
					System.out.println("Pokupio: " + " " + password);
					
				}
				getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
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
