package workshop.potter;

public class PriceCalculator {

	public static Double getPrice(Basket basket) {

		Double netPrice = 0.0;
		
		for(Book book : basket.getBasketItem().keySet()) {
			netPrice = netPrice + book.getPrice() * basket.getBasketItem().get(book);
		}

		return netPrice;
	}
}
