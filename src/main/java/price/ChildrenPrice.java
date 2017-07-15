package price;

public class ChildrenPrice implements Price
{

  @Override
  public int frequentFlyerPoints(int daysRented)
  {

    return 1;
  }

  @Override
  public double amount(int daysRented)
  {
    double result =0;
    result += 1.5;
    if (daysRented > 3)
        result += (daysRented - 3) * 1.5;
    return result;
  }
}
