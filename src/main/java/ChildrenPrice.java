public class ChildrenPrice extends Price
{
  public ChildrenPrice()
  {
    super(Movie.CHILDRENS);
  }

  @Override
  int frequentFlyerPoints(int daysRented)
  {

    return 1;
  }
}
