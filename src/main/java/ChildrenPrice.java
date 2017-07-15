public class ChildrenPrice extends Price
{
  public ChildrenPrice()
  {
    super(Movie.CHILDRENS);
  }

  @Override
  int frequentFlyerPoints(int daysRented)
  {
    int frequentRenterPoints = 1;

    if (code == Movie.NEW_RELEASE
&& daysRented > 1)
frequentRenterPoints++;
    return frequentRenterPoints;
  }
}
