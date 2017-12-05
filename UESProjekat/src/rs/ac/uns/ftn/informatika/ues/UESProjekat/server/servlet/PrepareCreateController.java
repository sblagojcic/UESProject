package rs.ac.uns.ftn.informatika.ues.UESProjekat.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session.CategoryDaoLocal;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session.CountryDaoLocal;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session.LanguageDaoLocal;

public class PrepareCreateController extends HttpServlet {

	private static final long serialVersionUID = 5161949512237886627L;
	
	private static Logger log = Logger.getLogger(PrepareCreateController.class);

	@EJB
	private CategoryDaoLocal categoryDaoLocal;

	@EJB
	private CountryDaoLocal countryDaoLocal;

	@EJB
	private LanguageDaoLocal languageDaoLocal;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			if ((request.getSession().getAttribute("admin")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
				return;
			}

			request.setAttribute("categorys", categoryDaoLocal.findAll());
			request.setAttribute("countrys", countryDaoLocal.findAll());
			request.setAttribute("languages", languageDaoLocal.findAll());
			
			String tipAdmin = "admin";
			String tipPretplatnik = "pretplatnik";
			
			request.setAttribute("tipAdmin", tipAdmin);
			request.setAttribute("tipPretplatnik", tipPretplatnik);

			getServletContext().getRequestDispatcher("/upload.jsp").forward(request, response);

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
