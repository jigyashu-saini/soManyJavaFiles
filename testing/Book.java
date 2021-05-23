package testing;

public class Book implements Comparable<Book>{ //implements cimparable interfase to have comparable method
	//author(String), title (String), and price (String).
	private String author;
	private String title;
	private String price;
	public Book(String author, String title, String price) {
		super();
		this.author = author;
		this.title = title;
		this.price = price;
	}
	//acessiors and modifiers
	protected String getAuthor() {
		return author;
	}
	protected void setAuthor(String author) {
		this.author = author;
	}
	protected String getTitle() {
		return title;
	}
	protected void setTitle(String title) {
		this.title = title;
	}
	protected String getPrice() {
		return price;
	}
	protected void setPrice(String price) {
		this.price = price;
	}
	
	//toString method
	@Override
	public String toString() {
		return "Author: "+author+"\nTitle: "+title+"\nPrice: "+price;
	}
	@Override
	public int compareTo(Book o) {
		return this.title.compareToIgnoreCase(o.title);
	}
}
