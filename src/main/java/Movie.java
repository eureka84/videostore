

public class Movie
{
	public static final int CHILDRENS	= 2;
	public static final int REGULAR 	= 0;
	public static final int NEW_RELEASE = 1;
	
	private String title;
  private Price price;

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

	double amount(int daysRented)
	{
		double result =0;
		switch (getPriceCode ()) {
      case REGULAR:
        result += 2;
        if (daysRented > 2)
          result += (daysRented - 2) * 1.5;
        break;
      case NEW_RELEASE:
        result += daysRented * 3;
        break;
      case CHILDRENS:
        result += 1.5;
        if (daysRented > 3)
          result += (daysRented - 3) * 1.5;
        break;
    }
		return result;
	}

	int frequentFlyerPoints(int daysRented)
	{
		int frequentRenterPoints = 1;

		if (getPriceCode() == NEW_RELEASE
        && daysRented > 1)
      frequentRenterPoints++;
		return frequentRenterPoints;
	}
}