package hipster.model;

/**
 * Framework for a Book object in the Hispter Project.
 * @author Sam Montoya
 * @version 1.0
 */
public class Book
{
	private int pageCount;
	private String author;
	private String subject;
	private String title;
	private double price;
	
	public Book()
	{
		this.pageCount= 0;
		this.author ="";
		this.subject = "";
		this.title = "";
		this.price = -0.00;
	}
	
	public Book(String author, String title, String subject, int pageCount, double price)
	{
		this.pageCount = pageCount;
		this.author = author;
		this.subject = subject;
		this.title = title;
		this.price = price;
	}

	public int getPageCount()
	{
		return pageCount;
	}

	public void setPageCount(int pageCount)
	{
		this.pageCount = pageCount;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}
	
	
}
