package rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity.Category;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity.User;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity.eBook;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session.eBookDaoLocal;


@Stateless
@Local(eBookDaoLocal.class)
public class eBookDaoBean extends GenericDaoBean<eBook, Integer> implements eBookDaoLocal {

	@Override
	public List<eBook> findeBooksByCategory(Integer categoryId) {
		Query q = em
				.createNamedQuery("findeBooksByCategory");
		q.setParameter("categoryId", categoryId);
		List<eBook> result = q.getResultList();
		return result;
	}

}
