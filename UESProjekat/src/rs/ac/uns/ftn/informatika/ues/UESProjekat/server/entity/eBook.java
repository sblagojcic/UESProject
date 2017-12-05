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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "eBook")
@NamedQuery(name = "findeBooksByCategory", query = "SELECT m FROM eBook m WHERE m.category.id = :categoryId")
public class eBook implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eBook_id", unique = true, nullable = true)
	private Integer id;
	
	@Column(name = "title", unique = false, nullable = false, length = 80)
	private String title;
	
	@Column(name = "author", unique = false, nullable = false, length = 120)	
	private String author;

	@Column(name = "keywords", unique = false, nullable = false, length = 120)
	private String keywords;
	
	@Column(name = "publicationYear", unique = false, nullable = false, length = 120)	
	private Integer publicationYear;

	@Column(name = "filename", unique = false, nullable = false, length = 200)	
	private String filename;
	
	@Column(name = "MIME", unique = false, nullable = false, length = 100)	
	private String MIME;
	

	
	@ManyToOne
	@JoinColumn(name = "country_id", referencedColumnName = "country_id", nullable = true)
	private Country country;
	
	@ManyToOne
	@JoinColumn(name = "language_id", referencedColumnName = "language_id", nullable = true)
	private Language language;
	
	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
	private Category category;

	
	public eBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public eBook(String title, String author, String keywords, String MIME, String filename,
			Integer publicationYear, Country country, Language language, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.keywords = keywords;
		this.publicationYear = publicationYear;
		this.filename = filename;
		this.MIME = MIME;
		country.add(this);
		language.add(this);
		category.add(this);
	}





	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getKeywords() {
		return keywords;
	}
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getMIME() {
		return MIME;
	}

	public void setMIME(String mIME) {
		MIME = mIME;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Integer getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}

	@Override
	public String toString() {
		return "eBook [id=" + id + ", title=" + title + ", author=" + author + ", keywords=" + keywords
				+ ", publicationYear=" + publicationYear + ", filename=" + filename + ", MIME=" + MIME + ", country="
				+ country + ", language=" + language + ", category=" + category + "]";
	}

	
}
