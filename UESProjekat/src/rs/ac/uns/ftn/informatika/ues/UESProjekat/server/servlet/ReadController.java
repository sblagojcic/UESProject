package rs.ac.uns.ftn.informatika.ues.UESProjekat.server.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity.Category;
//import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity.Score;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity.eBook;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session.CategoryDaoLocal;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session.eBookDaoLocal;


public class ReadController extends HttpServlet {

	private static final long serialVersionUID = -6820366488786163882L;
	
	private static Logger log = Logger.getLogger(ReadController.class);

	@EJB
	private eBookDaoLocal eBookDaoLocal;

//	@EJB
//	private ScoreDaoLocal scoreDaoLocal;

	@EJB
	private CategoryDaoLocal categoryDaoLocal;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
//			if ((request.getSession().getAttribute("admin")) == null) {
//				response.sendRedirect(response.encodeURL("./login.jsp"));
//				return;
//				
//			}



			String search = request.getParameter("search");
			
			if(search != null){
				
				Integer categoryId = Integer.parseInt(search);
				
				List<eBook> lista = eBookDaoLocal.findeBooksByCategory(categoryId);
				request.setAttribute("eBooks", lista);
			
			}
			else {
				
				request.setAttribute("eBooks", eBookDaoLocal.findAll());
			}

			request.setAttribute("categories", categoryDaoLocal.findAll());
			
			String tipAdmin = "admin";
			String tipPretplatnik = "pretplatnik";
			request.setAttribute("tipAdmin", tipAdmin);
			request.setAttribute("tipPretplatnik", tipPretplatnik);
			
			getServletContext().getRequestDispatcher("/read.jsp").forward(request, response);
		
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