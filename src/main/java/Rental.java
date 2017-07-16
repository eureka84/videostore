import movie.Movie;

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

	double amount()
	{
		return movie.amountfor(daysRented);
	}

	String movieTitle()
	{
		return movie.getTitle ();
	}
}