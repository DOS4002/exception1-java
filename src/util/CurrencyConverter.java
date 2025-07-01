package util;

public class CurrencyConverter {
	

	public static final double IOF = 0.06;

	
	public static double paidInReals(double dollarPrice, double quantityDollar ) {
		return (IOF * quantityDollar * dollarPrice) + quantityDollar * dollarPrice ;
	}

}
