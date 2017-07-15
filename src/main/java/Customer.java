
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
		Enumeration 		rentals 				= this.rentals.elements ();
		String 				result 					= "Rental Record for " + getName () + "\n";
		
		while (rentals.hasMoreElements ()) {
			Rental 		rental = (Rental)rentals.nextElement ();

			result += "\t" + rental.getMovie ().getTitle () + "\t"
								+ String.valueOf (rental.movie.amount(rental.getDaysRented())) + "\n";
		}

		result += "You owed " + String.valueOf (totalAmount()) + "\n";
		result += "You earned " + String.valueOf (totalFrequentFliersPoints()) + " frequent renter points\n";
		
		
		return result;
	}

	private int totalFrequentFliersPoints()
	{
		int frequentRenterPoints =0;
		Enumeration rentals 				= this.rentals.elements ();
		while (rentals.hasMoreElements ()) {
			Rental 		rental = (Rental)rentals.nextElement ();

			frequentRenterPoints += rental.frequentFlyerPoints();

		}
		return frequentRenterPoints;
	}

	private double totalAmount()
	{
		double 				totalAmount 			= 0;
		Enumeration rentals 				= this.rentals.elements ();

		while (rentals.hasMoreElements ()) {
			Rental 		rental = (Rental)rentals.nextElement ();


			totalAmount += rental.movie.amount(rental.getDaysRented());

		}
		return totalAmount;
	}

	public String htmlStatement()
	{
		Enumeration rentals1 = this.rentals.elements ();
		String 				result 					= "Rental Record for " + getName () + "<br>";

		while (rentals1.hasMoreElements ()) {
			Rental 		rental = (Rental) rentals1.nextElement ();

			result += "\t" + rental.getMovie ().getTitle () + "\t"
								+ String.valueOf (rental.movie.amount(rental.getDaysRented())) + "<br>";
		}

		result += "You owed " + String.valueOf (totalAmount()) + "<br>";
		result += "You earned " + String.valueOf (totalFrequentFliersPoints()) + " frequent renter points<br>";

		return result;
	}
}