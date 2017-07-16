public class StatementFactory
{
  public Statement create(String name)
 {
    return new Statement(name,new RentalsTotalAmountCalculator(),new RentalsFrequentFlyerCalculator());
 }
}
