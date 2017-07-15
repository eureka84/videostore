public class RegularPrice extends Price
{
  public RegularPrice()
  {
    super(Movie.REGULAR);
  }

  @Override
  int frequentFlyerPoints(int daysRented)
  {
    return  1;
  }

  @Override
  double amount(int daysRented)
  {
    double result =0;
result += 2;
if (daysRented > 2)
result += (daysRented - 2) * 1.5;
    return result;
  }
}
