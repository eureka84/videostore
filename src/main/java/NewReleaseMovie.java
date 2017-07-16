public class NewReleaseMovie extends Movie
{
  public NewReleaseMovie(String title)
  {
    super(title, Movie.NEW_RELEASE);
  }

  @Override
  double amountfor(int daysRented)
  {
    double result = 0;
    result += daysRented * 3;
    return result;
  }
}
