package price;

public class NewReleasePrice implements Price
{

  @Override
  public int frequentFlyerPoints(int daysRented)
  {
    int frequentRenterPoints = 1;

    if (daysRented > 1)
        frequentRenterPoints++;
    return frequentRenterPoints;
  }

  @Override
  public double amount(int daysRented)
  {
    double result = 0;
    result += daysRented * 3;
    return result;
  }
}
