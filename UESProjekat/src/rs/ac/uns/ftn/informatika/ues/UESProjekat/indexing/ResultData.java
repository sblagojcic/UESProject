package rs.ac.uns.ftn.informatika.ues.UESProjekat.indexing;

public final class ResultData {
	
	private String title;
	private String author;
	private String keywords;
	private String location;
	private String highlight;
	
	public ResultData() {
		super();
	}

	public ResultData(String title,String author, String keywords, String location, String highlight) {
		super();
		this.title = title;
		this.keywords = keywords;
		this.location = location;
		this.highlight = highlight;
		this.author = author;
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

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getHighlight() {
		return highlight;
	}

	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}

}
