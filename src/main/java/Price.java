public abstract class Price
{
  protected final int code;

  public Price(int code)
  {
    this.code = code;
  }

  public int getCode()
  {
    return code;
  }

  abstract double amount(int daysRented);

  abstract int frequentFlyerPoints(int daysRented);
}
