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
		int frequentRenterPoints = new FrequentFlyerCalculator(this.rentals).total();

		return header() + footerWithTotals(totalAmount, frequentRenterPoints);
	}

	private String footerWithTotals(double totalAmount, int frequentRenterPoints)
	{
		String statementFooter ="";
		statementFooter += "You owed " + String.valueOf (totalAmount) + "\n";
		statementFooter += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points\n";
		return statementFooter;
	}

	private String header()
	{
		String 				statementHeader 					= "Rental Record for " + getName () + "\n";
		Enumeration rentals = this.rentals.elements ();
		while (rentals.hasMoreElements ()) {
			Rental 		rental = (Rental) rentals.nextElement ();

			statementHeader += "\t" + rental.getMovie ().getTitle () + "\t"
				+ String.valueOf (rental.amount()) + "\n";

		}
		return statementHeader;
	}

}