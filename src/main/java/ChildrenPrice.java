public class ChildrenPrice extends Price
{
  public ChildrenPrice()
  {
    super();
  }

  @Override
  int frequentFlyerPoints(int daysRented)
  {

    return 1;
  }

  @Override
  double amount(int daysRented)
  {
    double result =0;
result += 1.5;
if (daysRented > 3)
result += (daysRented - 3) * 1.5;
    return result;
  }
}
