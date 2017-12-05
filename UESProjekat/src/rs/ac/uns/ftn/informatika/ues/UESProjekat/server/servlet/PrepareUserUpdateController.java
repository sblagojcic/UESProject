package rs.ac.uns.ftn.informatika.ues.UESProjekat.server.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session.CategoryDaoLocal;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session.UserDaoLocal;

public class PrepareUserUpdateController extends HttpServlet  {

	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(PrepareUserPassUpdateController.class);

	@EJB
	private UserDaoLocal userDaoLocal;
	
	@EJB
	private CategoryDaoLocal categoryDaoLocal;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			if ((request.getSession().getAttribute("admin")) == null) {
				response.sendRedirect(response.encodeURL("./login.jsp"));
				return;
			}
			
			request.setAttribute("category", categoryDaoLocal.findAll());
			String userId = request.getParameter("id");
			
			if ((userId != null) && (!userId.equals(""))) {
				request.setAttribute("user", userDaoLocal.findById(Integer.parseInt(userId)));
				System.out.println(userId);
				getServletContext().getRequestDispatcher("/updateUser.jsp").forward(request, response);
			}
		} catch (ServletException e) {
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