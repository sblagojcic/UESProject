package rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity.Category;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity.Country;
import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity.Language;

import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity.User;


@Stateless
@Remote(Init.class)
public class InitBean implements Init {

	@EJB
	UserDaoLocal userDao;
	
	@EJB
	CategoryDaoLocal categoryDao;
	
	@EJB
	CountryDaoLocal countryDao;
	
	@EJB
	LanguageDaoLocal languageDao;
	

	
	public void init() {
		User korisnik = new User("Admin", "Admin", "admin", "admin", "admin", null);
		userDao.persist(korisnik);
		
		Category category = new Category();
		category.setName("zanr");
		categoryDao.persist(category);
		
		Country country = new Country();
		country.setName("drzava");
		countryDao.persist(country);
		
		Language language = new Language();
		language.setName("jezik");
		languageDao.persist(language);
		

	}
}
