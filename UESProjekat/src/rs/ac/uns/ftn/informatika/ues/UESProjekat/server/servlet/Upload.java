package rs.ac.uns.ftn.informatika.ues.UESProjekat.server.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import rs.ac.uns.ftn.informatika.ues.UESProjekat.indexing.Indexer;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity.eBookIndex;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session.CategoryDaoLocal;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session.CountryDaoLocal;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session.LanguageDaoLocal;

//import rs.ac.uns.ftn.informatika.ues.lucene.indexing.Indexer;

@SuppressWarnings({"serial", "unchecked"})
public class Upload extends Mock {
	
	public void init() throws ServletException {
	}
	@EJB
	private CategoryDaoLocal categoryDaoLocal;

	@EJB
	private CountryDaoLocal countryDaoLocal;

	@EJB
	private LanguageDaoLocal languageDaoLocal;

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String storagePath = ResourceBundle.getBundle("app").getString("storage");
		
		if(ServletFileUpload.isMultipartContent(request)){
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024);
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				if ((request.getSession().getAttribute("admin")) == null) {
					response.sendRedirect(response.encodeURL("./login.jsp"));}

				List<FileItem> items = upload.parseRequest(request);
				FileItem fileItem = null;
				File uploadedFile = null;
				String fileName = "";
				String extension = "";
				for(FileItem item : items){ //trebalo bi da ima samo 1
					if(!item.isFormField()){
						fileName = item.getName();
						if(fileName.endsWith("pdf")){
							extension = ".pdf";
						}else{
							return;
						}
						fileName = System.currentTimeMillis() + extension;
						uploadedFile = new File(storagePath, fileName);
						fileItem = item;
						break;
					}
				}
				request.setAttribute("categorys", categoryDaoLocal.findAll());
				request.setAttribute("countrys", countryDaoLocal.findAll());
				request.setAttribute("languages", languageDaoLocal.findAll());

				while (uploadedFile.exists()) {
					fileName = System.currentTimeMillis() + extension;
					uploadedFile = new File(storagePath, fileName);
				}
				uploadedFile.createNewFile();
				fileItem.write(uploadedFile);
				eBookIndex entity = Indexer.getInstance().index(uploadedFile);
				request.setAttribute("eBookIndex", entity);
				getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
			} catch (Exception e) {
				response.sendRedirect("upload.jsp");
			}
		}
	}

}

