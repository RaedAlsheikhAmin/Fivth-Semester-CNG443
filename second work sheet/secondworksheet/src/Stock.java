public class Stock {
    String symbol;
    String name;
    double previousClosingPrice;
    double currentPrice;
    Stock(String symbol,String name)
    {
        this.symbol=symbol;
        this.name=name;
    }
    double getChangepercent()
    {
        System.out.println("this is the precentage of the change in price");
       return (previousClosingPrice/currentPrice)*100;
    }
}
