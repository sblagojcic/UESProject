package rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session;

import javax.ejb.Local;
import javax.ejb.Stateless;

import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity.Country;

@Stateless
@Local(CountryDaoLocal.class)
public class CountryDaoBean extends GenericDaoBean<Country, Integer> implements CountryDaoLocal {

}
