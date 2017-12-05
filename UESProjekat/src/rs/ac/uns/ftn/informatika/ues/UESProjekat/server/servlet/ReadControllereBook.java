package rs.ac.uns.ftn.informatika.ues.UESProjekat.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity.eBook;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session.eBookDaoLocal;


public class ReadControllereBook extends HttpServlet {

	private static final long serialVersionUID = -6820366488786163882L;
	
	private static Logger log = Logger.getLogger(ReadControllereBook.class);

	@EJB
	private eBookDaoLocal eBookDaoLocal;

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


			request.setAttribute("eBooks", eBookDaoLocal.findAll());
		
			
			getServletContext().getRequestDispatcher("/readeBook.jsp").forward(request, response);
		
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