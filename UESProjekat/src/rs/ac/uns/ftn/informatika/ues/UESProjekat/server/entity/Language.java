package rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "language")
public class Language implements Serializable {

	private static final long serialVersionUID = 5968258139553453630L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "language_id", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "name", nullable = false, unique = false, length = 30)
	private String name;
	
	@OneToMany(cascade = {ALL}, fetch = LAZY, mappedBy = "language")
	private Set<eBook> eBooks = new HashSet<eBook>();
	
	public Language() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Language(String name) {
		super();
		this.name = name;
	}
	
	public void add(eBook v) {
		if (v.getLanguage() != null)
			v.getLanguage().geteBooks().remove(v);
		v.setLanguage(this);
		eBooks.add(v);
	}
	


	public void remove(eBook v) {
		v.setLanguage(null);
		eBooks.remove(v);
	}

	
	public Set<eBook> geteBooks() {
		return eBooks;
	}
	public void seteBooks(Set<eBook> eBooks) {
		this.eBooks = eBooks;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Language [id=" + id + ", name=" + name + "]";
	}
	
	
}
