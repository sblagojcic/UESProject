package rs.ac.uns.ftn.informatika.ues.UESProjekat.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity.User;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session.UserDaoLocal;


public class LoginController extends HttpServlet {

	private static final long serialVersionUID = -7345471861052209628L;
	
	private static Logger log = Logger.getLogger(LoginController.class);

	@EJB
	private UserDaoLocal userDaoLocal;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			String userName = request.getParameter("korisnickoIme");
			String password = request.getParameter("lozinka");
			
			if ((userName == null) || (userName.equals("")) || (password == null) || (password.equals(""))) {
				response.sendRedirect(response.encodeRedirectURL("./login.jsp"));
				return;
			}
			
			User user = userDaoLocal.findKorisnikSaKorisnickimImenomILozinkom(userName, password);
			
			System.out.println(userName);
			System.out.println(password);

			
			if (user != null) {	
				HttpSession session = request.getSession(true);

				session.setAttribute("admin", user);

				
			

					if(user.getCategory() != null){
						session.setAttribute("category_id", user.getCategory().getId());
					}
					
					session.setAttribute("type", user.getType());


					

				log.info("Korisnik " + user.getUserName() + " is logged in.");
				getServletContext().getRequestDispatcher("/MainController").forward(request, response);
			}
			
		} catch (EJBException e) {
			if (e.getCause().getClass().equals(NoResultException.class)) {
				response.sendRedirect(response.encodeRedirectURL("./login.jsp"));
			} else {
				throw e;
			}
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
