import java.util.Enumeration;
import java.util.Vector;

public class Statement
{
	private String name;
	private Vector rentals = new Vector ();

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

		double totalAmount = new TotalAmountCalculator(this.rentals).total();
		int frequentRenterPoints = frequentFlierPoints();
		return rentalsStatement() + footerWithTotalsStatement(totalAmount, frequentRenterPoints);
	}

	private String footerWithTotalsStatement(double totalAmount, int frequentRenterPoints)
	{
		String result="";
		result += "You owed " + String.valueOf (totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";
		return result;
	}



	private String rentalsStatement()
	{
		String 				result 					= "Rental Record for " + getName () + "\n";
		Enumeration rentals 				= this.rentals.elements ();
		while (rentals.hasMoreElements ()) {
			Rental 		rental = (Rental)rentals.nextElement ();

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
		return new TotalAmountCalculator(this.rentals).total();
	}

	public int frequentFliersPoints()
	{
   return frequentFlierPoints();
	}

}