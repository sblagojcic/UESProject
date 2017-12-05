package rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity.User;

@Stateless
@Local(UserDaoLocal.class)
public class UserDaoBean extends GenericDaoBean<User, Integer> implements UserDaoLocal{

	public User findKorisnikSaKorisnickimImenomILozinkom(
			String userName, String password) {
		Query q = em.createNamedQuery("findUserUsernameAndPassword");
		q.setParameter("userName", userName);
		q.setParameter("password", password);
		User result = (User) q.getSingleResult();
		return result;
}
}
