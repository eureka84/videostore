import java.util.Enumeration;
import java.util.Vector;

import static java.lang.String.format;
import static java.lang.String.valueOf;

public class Statement
{
	private String name;
	private Vector rentals = new Vector ();

	private TotalAmountCalculator totalAmountCalculator;
	private FrequentFlyerCalculator frequentFlyerCalculator;

	public Statement(String name,
		TotalAmountCalculator totalAmountCalculator,
		FrequentFlyerCalculator frequentFlyerCalculator)
	{
		this.name = name;
		this.totalAmountCalculator = totalAmountCalculator;
		this.frequentFlyerCalculator = frequentFlyerCalculator;
	}
	
	public void addRental (Rental rental) {
		rentals.addElement (rental);
	}

	public String create() {

		double totalAmount = totalAmountCalculator.total(this.rentals);
		int frequentRenterPoints = frequentFlyerCalculator.total(this.rentals);

		return rentalsStatement() + footerWithTotals(totalAmount, frequentRenterPoints);
	}

	private String footerWithTotals(double totalAmount, int frequentRenterPoints)
	{
		return format("You owed %s\nYou earned %s frequent renter points\n", valueOf(totalAmount),
      valueOf(frequentRenterPoints));
	}

	private String rentalsStatement()
	{
		String 	statementHeader = "Rental Record for " + name + "\n";
		Enumeration rentals = this.rentals.elements ();
		while (rentals.hasMoreElements ()) {
			Rental 		rental = (Rental) rentals.nextElement ();
			statementHeader += rentalStatementLine(rental);

		}
		return statementHeader;
	}

	private String rentalStatementLine(Rental rental)
	{
		return "\t" + rental.movieTitle() + "\t"
      + valueOf (rental.amount()) + "\n";
	}

}