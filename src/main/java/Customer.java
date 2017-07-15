
import java.util.Vector;
import java.util.Enumeration;

public class Customer 
{
	private String name;
	private Vector rentals = new Vector ();

	public Customer (String name) {
		this.name = name;
	}
	
	public void addRental (Rental rental) {
		rentals.addElement (rental);
	}
	
	public String getName () {
		return name;
	}
	
	public String statement () {
		double 				totalAmount 			= 0;
		int					frequentRenterPoints 	= 0;
		Enumeration 		rentals 				= this.rentals.elements ();
		String 				result 					= "Rental Record for " + getName () + "\n";
		
		while (rentals.hasMoreElements ()) {
			Rental 		rental = (Rental)rentals.nextElement ();

			frequentRenterPoints += frequentFlyerPoints(rental);
				
			result += "\t" + rental.getMovie ().getTitle () + "\t"
								+ String.valueOf (rental.amount()) + "\n";
			totalAmount += rental.amount();
				
		}
		
		result += "You owed " + String.valueOf (totalAmount) + "\n";
		result += "You earned " + String.valueOf (frequentRenterPoints) + " frequent renter points\n";
		
		
		return result;
	}

	private int frequentFlyerPoints(Rental rental)
	{
		int frequentRenterPoints = 1;

		if (rental.getMovie ().getPriceCode () == Movie.NEW_RELEASE
        && rental.getDaysRented () > 1)
      frequentRenterPoints++;
		return frequentRenterPoints;
	}

}