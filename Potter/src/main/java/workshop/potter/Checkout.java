package workshop.potter;

public class Checkout {
	
	public void process(Basket basket) {
        Double netPrice = PriceCalculator.getPrice(basket);
        Double maxDiscount = DiscountCalculator.getMaxDiscount(basket);
        Double totalPrice = netPrice - maxDiscount;
        
        basket.setNetPrice(netPrice);
        basket.setDiscountPrice(maxDiscount);
        basket.setTotalPrice(totalPrice);
        
    }
}
