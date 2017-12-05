package rs.ac.uns.ftn.informatika.ues.UESProjekat.server.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity.User;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity.eBook;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session.UserDaoLocal;

public class MainController extends HttpServlet {

	private static Logger log = Logger.getLogger(MainController.class);
	private static final long serialVersionUID = 1L;

	@EJB
	private UserDaoLocal userDaoLocal;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			if ((request.getSession().getAttribute("admin")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
				return;
			}
			
			String tipAdmin = "admin";
			String tipPretplatnik = "pretplatnik";
			
			request.setAttribute("tipAdmin", tipAdmin);
			request.setAttribute("tipPretplatnik", tipPretplatnik);


			request.setAttribute("user", userDaoLocal.findAll());
			getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
		
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
