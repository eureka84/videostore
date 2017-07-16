package movie;

public class ChildrenMovie extends Movie
{
  public ChildrenMovie(String title)
  {
    super(title);
  }

  @Override
  public double amountfor(int daysRented)
  {
    double result = 0;
    result += 1.5;
    if (daysRented > 3)
    {
      result += (daysRented - 3) * 1.5;
    }
    return result;
  }

  @Override
  public int totalFreqFliersPoints(int daysRented)
  {
    return 1;
  }
}
