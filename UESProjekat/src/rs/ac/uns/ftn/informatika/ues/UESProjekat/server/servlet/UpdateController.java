package rs.ac.uns.ftn.informatika.ues.UESProjekat.server.servlet;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class UpdateController extends HttpServlet {
	
	private static final long serialVersionUID = 4676416691336033321L;
	
	private static Logger log = Logger.getLogger(UpdateController.class);

	@EJB
	private eBookDaoLocal movieDaoLocal;

//	@EJB
//	private ScoreDaoLocal scoreDaoLocal;

	@EJB
	private CountryDaoLocal countryDaoLocal;
	
	@EJB
	private LanguageDaoLocal languageDaoLocal;
	
	@EJB
	private CategoryDaoLocal categoryDaoLocal;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		try {
			
			String movieId = null;
			String title = null;
			String author = null;
			String keywords = null;
			Integer publicationYear = null;
			String filename = null;
			String MIME = null;
			
			Integer countryId = null;
			Integer languageId = null;
			Integer categoryId = null;
			
			if ((request.getSession().getAttribute("admin")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
		    	return;
		    }
			
			movieId = request.getParameter("id");
			
			if ((request.getSession().getAttribute("admin")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
				return;
			}

			if ((request.getParameter("title") != null) && (!"".equals(request.getParameter("title")))) {
				title = request.getParameter("title");
			}

			if ((request.getParameter("author") != null) && (!"".equals(request.getParameter("author")))) {
				author = request.getParameter("author");
			}
			
			if ((request.getParameter("keywords") != null) && (!"".equals(request.getParameter("keywords")))) {
				keywords = request.getParameter("keywords");
			}
			
			if ((request.getParameter("publicationYear") != null) && (!"".equals(request.getParameter("publicationYear")))) {
				publicationYear = new Integer(request.getParameter("publicationYear"));
			}
			
			if ((request.getParameter("filename") != null) && (!"".equals(request.getParameter("filename")))) {
				filename = request.getParameter("filename");
			}
			
			if ((request.getParameter("MIME") != null) && (!"".equals(request.getParameter("MIME")))) {
				MIME = request.getParameter("MIME");
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
	
			if ((movieId!=null) && (!movieId.equals(""))) {
				
				eBook m = new eBook();
				m.setId(new Integer(movieId));
				
				if (title != null)
					m.setTitle(title);
				
				if (title != null)
					m.setTitle(title);
				if (author != null)
					m.setAuthor(author);
				if (filename != null)
					m.setFilename(filename);
				if (MIME != null)
					m.setMIME(MIME);
				if (publicationYear != null)
					m.setPublicationYear(publicationYear);
				if (keywords != null)
					m.setKeywords(keywords);
				
				



				if (countryId != null)
					m.setCountry(countryDaoLocal.findById(countryId));
				
				if(languageId != null)
					m.setLanguage(languageDaoLocal.findById(languageId));

				if (categoryId != null)
					m.setCategory(categoryDaoLocal.findById(categoryId));	
				
				movieDaoLocal.merge(m);
				String storagePath = ResourceBundle.getBundle("app").getString("storage");
				File uploadFile = new File(storagePath, m.getFilename());
				Indexer.getInstance().index(uploadFile, m);
			}
			
			getServletContext().getRequestDispatcher("/ReadControllerMovie").forward(request, response);
		
		} catch (ServletException e) {
			log.error(e);
			throw e;
		} catch (IOException e) {
			log.error(e);
			throw e;
		} /*catch (ParseException e) {
			log.error(e); }*/
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
