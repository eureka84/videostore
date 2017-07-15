

public class Movie
{
	public static final int CHILDRENS	= 2;
	public static final int REGULAR 	= 0;
	public static final int NEW_RELEASE = 1;
	
	private String title;
  Price price;

  public Movie(String title, Price price) {
		this.title 		= title;
		this.price = price;
	}

	public String getTitle () {
		return title;
	}

	public double amount(int daysRented)
	{
		return price.amount(daysRented);
	}
}