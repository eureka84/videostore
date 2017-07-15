
public class Rental
{
	Movie movie;
	private int daysRented;

	public Rental (Movie movie, int daysRented) {
		this.movie 		= movie;
		this.daysRented = daysRented;
	}
	
	public int getDaysRented () {
		return daysRented;
	}
	
	public Movie getMovie () {
		return movie;
	}

	int frequentFlyerPoints()
	{
		int frequentRenterPoints = 1;

		if (getMovie ().getPriceCode () == Movie.NEW_RELEASE
        && getDaysRented () > 1)
      frequentRenterPoints++;
		return frequentRenterPoints;
	}

	double amount()
	{
		return movie.amount(daysRented);
	}
}