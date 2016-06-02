package hipster.model;

public class Hipster
{
	private String name;
	private String [] hipsterPhrases;
	private Book [] hipsterBooks;
	
	public Hipster()
	{
		this.name = "";
		this.hipsterPhrases = new String[4];
		this.hipsterBooks = new Book[3];
		
		setupArray();
		setupBooks();
	}
	
	private void setupArray()
	{
		hipsterPhrases[0] = "That is so mainstream!";
		hipsterPhrases[1] = "I dont mean to sound like a hipster, but...";
		hipsterPhrases[2] = "I liked this before it was cool, bro.";
		hipsterPhrases[3] = "Weeeeeeeed";
	}
	
	private void setupBooks()
	{
		Book firstBook, secondBook;
		
		firstBook = new Book();
		firstBook.setAuthor("Neil ArmStrong");
		firstBook.setTitle("Moon is Cool");
		firstBook.setSubject("Space Stuff");
		firstBook.setPageCount(400);
		firstBook.setPrice(14.99);
		
		secondBook = new Book();
		secondBook.setAuthor("Brettly Montoya");
		secondBook.setTitle("2 School for Cool");
		secondBook.setSubject("Cool Life");
		secondBook.setPageCount(500);
		secondBook.setPrice(10.00);
		
		hipsterBooks[0] = firstBook; hipsterBooks[1] = secondBook; hipsterBooks[2] = firstBook;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String[] getHipsterPhrases()
	{
		return hipsterPhrases;
	}

	public void setHipsterPhrases(String[] hipsterPhrases)
	{
		this.hipsterPhrases = hipsterPhrases;
	}

	public Book[] getHipsterBooks()
	{
		return hipsterBooks;
	}

	public void setHipsterBooks(Book[] hipsterBooks)
	{
		this.hipsterBooks = hipsterBooks;
	}
}
