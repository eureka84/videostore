import price.Price;

public class Movie
{

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

	int frequentFlyer(int daysRented)
	{
		return price.frequentFlyerPoints(daysRented);
	}
}