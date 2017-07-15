public class NewReleasePrice extends Price
{
  public NewReleasePrice()
  {
    super();
  }

  @Override
  int frequentFlyerPoints(int daysRented)
  {
    int frequentRenterPoints = 1;

    if (daysRented > 1)
frequentRenterPoints++;
    return frequentRenterPoints;
  }

  @Override
  double amount(int daysRented)
  {
    double result =0;
result += daysRented * 3;
    return result;
  }
}
