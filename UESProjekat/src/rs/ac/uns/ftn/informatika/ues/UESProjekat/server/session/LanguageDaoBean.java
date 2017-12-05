package rs.ac.uns.ftn.informatika.ues.UESProjekat.server.session;

import javax.ejb.Local;
import javax.ejb.Stateless;

import rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity.Language;

@Stateless
@Local(LanguageDaoLocal.class)
public class LanguageDaoBean extends GenericDaoBean<Language, Integer> implements LanguageDaoLocal {

}
