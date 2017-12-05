package rs.ac.uns.ftn.informatika.ues.UESProjekat.server.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.ues.UESProjekat.indexing.Indexer;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity.eBook;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session.CategoryDaoLocal;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session.CountryDaoLocal;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session.LanguageDaoLocal;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session.eBookDaoLocal;




public class CreateController extends HttpServlet {

	private static final long serialVersionUID = -2544396238785425302L;
	
	private static Logger log = Logger.getLogger(CreateController.class);

	@EJB
	private eBookDaoLocal eBookDaoLocal;



	@EJB
	private CountryDaoLocal countryDaoLocal;
	
	@EJB
	private LanguageDaoLocal languageDaoLocal;
	
	@EJB
	private CategoryDaoLocal categoryDaoLocal;
	
	
	/**
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String title = null;
			String author = null;
			String keywords = null;
			Integer publicationYear = null;
			String filename = null;
			String MIME = null;
			//scores
			Integer countryId = null;
			Integer languageId = null;
			Integer categoryId = null;

			if ((request.getSession().getAttribute("admin")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
				return;
			}

			if ((request.getParameter("title") != null) && (!"".equals(request.getParameter("title")))) {
				title = request.getParameter("title");
			}

			if ((request.getParameter("author") != null) && (!"".equals(request.getParameter("author")))) {
				author = new String(request.getParameter("author"));
			}

			if ((request.getParameter("keywords") != null) 	&& (!"".equals(request.getParameter("keywords")))) {
				keywords = new String(request.getParameter("keywords"));
			}

			if ((request.getParameter("filename") != null) && (!"".equals(request.getParameter("filename")))) {
				filename = new String(request.getParameter("filename"));
			}

			if ((request.getParameter("MIME") != null) && (!"".equals(request.getParameter("MIME")))) {
				MIME = new String(request.getParameter("MIME"));
			}

			if ((request.getParameter("publicationYear") != null) && (!"".equals(request.getParameter("publicationYear")))) {
				publicationYear = new Integer(request.getParameter("publicationYear"));
			}

			if ((request.getParameter("country") != null) && (!"".equals(request.getParameter("country")))) {
				countryId = new Integer(request.getParameter("country"));
			}

			if ((request.getParameter("language") != null) && (!"".equals(request.getParameter("language")))) {
				languageId = new Integer(request.getParameter("language"));
			}
			
			if ((request.getParameter("category") != null) && (!"".equals(request.getParameter("category")))) {
				categoryId = new Integer(request.getParameter("category"));
			}

			eBook m = new eBook();

			if (title != null)
				m.setTitle(title);

			if (author != null)
				m.setAuthor(author);

			if ( publicationYear != null)
				m.setPublicationYear(publicationYear);

			if (MIME != null)
				m.setMIME(MIME);

			if (filename != null)
				m.setFilename(filename);

			if (keywords != null)
				m.setKeywords(keywords);

			if (countryId != null)
				m.setCountry(countryDaoLocal.findById(countryId));
			
			if(languageId != null)
				m.setLanguage(languageDaoLocal.findById(languageId));

			if (categoryId != null)
				m.setCategory(categoryDaoLocal.findById(categoryId));
			
			eBookDaoLocal.persist(m);
		
			String storagePath = ResourceBundle.getBundle("app").getString("storage");
			File uploadFile = new File(storagePath, m.getFilename());

			Indexer.getInstance().index(uploadFile, m);

			
			
			getServletContext().getRequestDispatcher("/ReadControllereBook").forward(request, response);
			return;
			
		} catch (ServletException e) {
			log.error(e);
			throw e;
		} catch (IOException e) {
			log.error(e);
			throw e;
		} /*catch (ParseException e) {
			log.error(e);
		}*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
