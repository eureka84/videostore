import java.util.Enumeration;
import java.util.Vector;

public class RentalsTotalAmountCalculator implements TotalAmountCalculator
{

  public double total(Vector rentals)
  {
    double resultAmount = 0;
    Enumeration rentals1 = rentals.elements();

    while (rentals1.hasMoreElements ()) {
      double 		thisAmount = 0;
      Rental 		rental = (Rental) rentals1.nextElement ();

      thisAmount = rental.amount();

      resultAmount += thisAmount;

    }
    return resultAmount;
  }
}
