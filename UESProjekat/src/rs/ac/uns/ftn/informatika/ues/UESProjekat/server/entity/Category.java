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
@Table(name = "category")
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "category_name", unique = false, nullable = true, length = 30)
	private String name;
	
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "category")
	private Set<eBook> eBooks = new HashSet<eBook>();
	
	@OneToMany(cascade = {ALL}, fetch = LAZY, mappedBy = "category")
	private Set<User> users = new HashSet<User>();
	
	public void add(eBook v) {
		if (v.getCategory() != null)
			v.getCategory().geteBooks().remove(v);
		v.setCategory(this);
		eBooks.add(v);
	}

	public void remove(eBook v) {
		v.setCategory(null);
		eBooks.remove(v);
	}
	
	public void add(User v) {
		if (v.getCategory() != null)
			v.getCategory().getUsers().remove(v);
		v.setCategory(this);
		users.add(v);
	}

	public void remove(User v) {
		v.setCategory(null);
		users.remove(v);
	}
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String name) {
		super();
		this.name = name;
	}
	
	
	
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
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
		return "Category [id=" + id + ", name=" + name + "]";
	}
	
	
}
