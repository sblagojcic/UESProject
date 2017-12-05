package rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session;

import java.util.List;

import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity.Category;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity.User;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity.eBook;

public interface eBookDaoLocal extends GenericDaoLocal<eBook, Integer> {
	public List<eBook> findeBooksByCategory(Integer categoryId);
}
