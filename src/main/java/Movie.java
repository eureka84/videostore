

public class Movie
{
	public static final int CHILDRENS	= 2;
	public static final int REGULAR 	= 0;
	public static final int NEW_RELEASE = 1;
	
	private String title;
  Price price;

  public Movie (String title, int priceCode) {
		this.title 		= title;
		this.setPriceCode(priceCode);
	}
	
	public int getPriceCode () {
		return price.getCode();
	}
	
	public void setPriceCode (int code) {
    price = new Price(code);
	}
	
	public String getTitle () {
		return title;
	}

	int frequentFlyerPoints(int daysRented)
	{
		int frequentRenterPoints = 1;

		if (getPriceCode() == NEW_RELEASE
        && daysRented > 1)
      frequentRenterPoints++;
		return frequentRenterPoints;
	}

	double amount(int daysRented)
	{
		return price.amount(daysRented);
	}
}