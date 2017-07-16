import java.util.Enumeration;
import java.util.Vector;

public class Statement
{
	private String name;
	private Vector rentals = new Vector ();
	private double totalAmount;
	private int frequentRenterPoints;

	public Statement(String name) {
		this.name = name;
	}
	
	public void addRental (Rental rental) {
		rentals.addElement (rental);
	}
	
	public String getName () {
		return name;
	}
	
	public String create() {
		totalAmount = 0;
		frequentRenterPoints = 0;

		totalAmount = calculateTotalAmount();
		frequentRenterPoints = frequentFlierPoints();

		return rentalsStatements() + statementFooter(this.totalAmount, this.frequentRenterPoints);
	}

	private String statementFooter(double totalAmount, int frequentRenterPoints)
	{
		String result="";
		result += "You owed " + String.valueOf (totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";
		return result;
	}

	private double calculateTotalAmount()
	{
		double resultAmount = 0;
		Enumeration rentals 				= this.rentals.elements ();

		while (rentals.hasMoreElements ()) {
			double 		thisAmount = 0;
			Rental 		rental = (Rental)rentals.nextElement ();

			thisAmount = rental.amount();

			resultAmount += thisAmount;

		}
		return resultAmount;
	}

	private String rentalsStatements()
	{
		String 				result 					= "Rental Record for " + getName () + "\n";
		Enumeration rentals2 				= this.rentals.elements ();
		while (rentals2.hasMoreElements ()) {
			Rental 		rental = (Rental)rentals2.nextElement ();

			result += "\t" + rental.getMovie ().getTitle () + "\t"
				+ String.valueOf (rental.amount()) + "\n";

		}
		return result;
	}

	private int frequentFlierPoints()
	{
		int frequentRenterPoints = 0;
		Enumeration rentals 				= this.rentals.elements ();
		while (rentals.hasMoreElements ()) {
			Rental 		rental = (Rental)rentals.nextElement ();
			frequentRenterPoints++;

			if (rental.getMovie ().getPriceCode () == Movie.NEW_RELEASE
					&& rental.getDaysRented () > 1)
				frequentRenterPoints++;
		}

		return frequentRenterPoints;
	}

	public double totalAmount()
	{
		return totalAmount;
	}

	public int frequentFliersPoints()
	{
   return frequentRenterPoints;
	}
}