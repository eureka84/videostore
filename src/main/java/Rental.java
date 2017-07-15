
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
		return movie.amount(daysRented);
	}

	int frequentFlyersPoints()
	{
		return movie.frequentFlyerPoints(daysRented);
	}
}