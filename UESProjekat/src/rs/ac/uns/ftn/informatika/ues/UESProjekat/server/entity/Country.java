package rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country implements Serializable {

	private static final long serialVersionUID = -3235948014614019135L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "name", unique = false, nullable = false, length = 30)
	private String name;
	
	@OneToMany(cascade = {ALL}, fetch = LAZY, mappedBy = "country")
	private Set<eBook> eBooks = new HashSet<eBook>();
	
	public void add(eBook m){
		if (m.getCountry() != null)
			m.getCountry().geteBooks().remove(m);
		m.setCountry(this);
		eBooks.add(m);
	}
	
	public void remove(eBook c){
		c.setCountry(null);
		eBooks.remove(c);
	}
	
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Country(String name) {
		super();
		this.name = name;
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
		return "Country [id=" + id + ", name=" + name + "]";
	}
	
	
}
