package rs.ac.uns.ftn.informatika.ues.UESProjekat.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity.Category;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session.CategoryDaoLocal;

public class UpdateCategoryController extends HttpServlet {
	
	private static Logger log = Logger.getLogger(UpdateUserController.class);
	private static final long serialVersionUID = -7380512096571638502L;
	
	@EJB
	private CategoryDaoLocal categoryDaoLocal;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			
			String id = null;
			String name = null;
			
			if ((request.getSession().getAttribute("admin")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
		    	return;
		    }
			
			id = request.getParameter("id");
			
			if ((request.getParameter("name") != null) && (!"".equals(request.getParameter("name")))) {
				name = request.getParameter("name");
			}
			
			
			if((id != null) && (!id.equals(""))){
				Category u = new Category();
				
				u.setId(new Integer(id));
				
				if(name != null){
					u.setName(name);
			}
	
				categoryDaoLocal.merge(u);
				
			}
			getServletContext().getRequestDispatcher("/ReadCategoryController").forward(request, response);
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

