public class NewReleasePrice extends Price
{
  public NewReleasePrice()
  {
    super(Movie.NEW_RELEASE);
  }

  @Override
  int frequentFlyerPoints(int daysRented)
  {
    int frequentRenterPoints = 1;

    if (daysRented > 1)
frequentRenterPoints++;
    return frequentRenterPoints;
  }
}
