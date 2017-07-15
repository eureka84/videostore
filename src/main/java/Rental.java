
public class Rental
{
	Movie movie;
	private int daysRented;

	public Rental (Movie movie, int daysRented) {
		this.movie 		= movie;
		this.daysRented = daysRented;
	}

  public Movie getMovie () {
		return movie;
	}

	double amount()
	{
		return movie.amount(this.daysRented);
	}

	int frequentFlyersPoints()
	{
		return movie.price.frequentFlyerPoints(daysRented);
	}
}