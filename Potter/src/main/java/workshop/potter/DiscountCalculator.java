package workshop.potter;

import java.util.Map;

public class DiscountCalculator {

	public static Double getMaxDiscount(Basket basket) {

		Double discount = 0.0;
		Double price = 0.0;
		Double netPrice = PriceCalculator.getPrice(basket);
		Map<Book, Integer> quantitiesByItem = basket.getBasketItem();
		for (Book book : quantitiesByItem.keySet()) {
			price += book.getPrice();
		}

		if (quantitiesByItem.size() == 2) {
			discount = (price * 5 / 100);
		} else if (quantitiesByItem.size() == 3) {
			discount =  (price * 10 / 100);
		} else if (quantitiesByItem.size() == 4) {
			discount =  (price * 20 / 100);
		} else if (quantitiesByItem.size() == 5) {
			discount =  (price * 25 / 100);
		}


		return discount;
	}

}
