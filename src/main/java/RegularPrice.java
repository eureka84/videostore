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
}
