package rs.ac.uns.ftn.informatika.ues.UESProjekat.indexing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.lucene.search.BooleanClause.Occur;

import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.servlet.Mock;



@SuppressWarnings("serial")
public class PrepareSearch extends Mock {
	
	@Override
	public void init() throws ServletException{
		super.init();
		Indexer.getInstance().index(new File(ResourceBundle.getBundle("app").getString("storage")));
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> occures = new ArrayList<String>();
		for(Occur o : Occur.values()){
			occures.add(o.toString());
		}
		String tipAdmin = "admin";
		String tipPretplatnik = "pretplatnik";
		
		request.getSession().setAttribute("occures", occures);
		request.getSession().setAttribute("searchTypes", SearchType.getMessages());

		request.setAttribute("tipAdmin", tipAdmin);
		request.setAttribute("tipPretplatnik", tipPretplatnik);
		
		//response.sendRedirect("search.jsp");
		getServletContext().getRequestDispatcher("/search.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, 	HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
