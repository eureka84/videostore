

public class Movie
{
	public static final int CHILDRENS	= 2;
	public static final int REGULAR 	= 0;
	public static final int NEW_RELEASE = 1;
	
	private String title;
  Price price;

  public Movie (String title, int priceCode) {
		this.title 		= title;
		price = new Price(priceCode);
	}

	public String getTitle () {
		return title;
	}

	int frequentFlyerPoints(int daysRented)
	{
		int frequentRenterPoints = 1;

		if (price.getCode() == NEW_RELEASE
        && daysRented > 1)
      frequentRenterPoints++;
		return frequentRenterPoints;
	}

	public double amount(int daysRented)
	{
		return price.amount(daysRented);
	}
}