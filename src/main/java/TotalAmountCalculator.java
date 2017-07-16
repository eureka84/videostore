import java.util.Enumeration;
import java.util.Vector;

public class TotalAmountCalculator
{
  private final Vector rentals;

  public TotalAmountCalculator(Vector rentals)
  {
    this.rentals = rentals;
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

  public double total()
  {
    return calculateTotalAmount();
  }
}
