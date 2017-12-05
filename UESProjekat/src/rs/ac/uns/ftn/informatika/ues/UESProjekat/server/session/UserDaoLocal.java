package rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session;

import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity.User;

public interface UserDaoLocal extends GenericDaoLocal<User, Integer> {
	
	public User findKorisnikSaKorisnickimImenomILozinkom(
			String userName, String password);

}
