package movie;

public class NewReleaseMovie extends Movie
{
  public NewReleaseMovie(String title)
  {
    super(title, Movie.NEW_RELEASE);
  }

  @Override
  public double amountfor(int daysRented)
  {
    double result = 0;
    result += daysRented * 3;
    return result;
  }

  @Override
  public int totalFreqFliersPoints(int daysRented)
  {
    int result = 1;
    if (daysRented > 1)
    {
      result++;
    }
    return result;
  }
}
