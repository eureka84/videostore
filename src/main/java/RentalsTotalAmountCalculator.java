import java.util.Enumeration;
import java.util.Vector;

public class RentalsTotalAmountCalculator implements TotalAmountCalculator
{

  public double total(Vector rentals)
  {
    double resultAmount = 0;
    Enumeration rentals1 = rentals.elements();

    while (rentals1.hasMoreElements ()) {
      Rental 		rental = (Rental) rentals1.nextElement ();

      resultAmount += rental.amount();

    }
    return resultAmount;
  }
}
