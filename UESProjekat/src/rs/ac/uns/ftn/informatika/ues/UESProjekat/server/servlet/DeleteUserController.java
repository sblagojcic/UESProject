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


public class DeleteUserController extends HttpServlet {
	
	private static final long serialVersionUID = -5385463981362749448L;

	private static Logger log = Logger.getLogger(DeleteUserController.class);
	
	@EJB
	private UserDaoLocal userDaoLocal;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			if ((request.getSession().getAttribute("admin")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
				return;
			}

			String id = null;
			id = request.getParameter("id");

			User user = userDaoLocal.findById(Integer.parseInt(id));
			userDaoLocal.remove(user);

			getServletContext().getRequestDispatcher("/ReadUserController").forward(request, response);
			
		} catch (ServletException e) {
			log.error(e);
			throw e;
		} catch (IOException e) {
			log.error(e);
			throw e;
		}
	}

	protected void doPost(HttpServletRequest request, 	HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
