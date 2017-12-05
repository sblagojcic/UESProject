package rs.ac.uns.ftn.informatika.ues.UESProjekat.server.entity;

public class eBookIndex {
	private String filename;
	private String author;
	private String title;
	private String keywords;
	public String getFilename() {
		return filename;
	}
	public void setFilename(String fileName) {
		this.filename = fileName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public eBookIndex(String fileName, String author, String title, String keywords) {
		super();
		this.filename = fileName;
		this.author = author;
		this.title = title;
		this.keywords = keywords;
	}
	public eBookIndex() {
		super();
	}
	
	
}
