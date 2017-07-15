
public class Rental
{
	Movie movie;
	private int daysRented;

	public Rental (Movie movie, int daysRented) {
		this.movie 		= movie;
		this.daysRented = daysRented;
	}

	double amount()
	{
		return movie.amount(this.daysRented);
	}

	int frequentFlyersPoints()
	{
		return movie.frequentFlyer(this.daysRented);
	}

	String movieTitle()
  {
		return movie.getTitle ();
  }
}