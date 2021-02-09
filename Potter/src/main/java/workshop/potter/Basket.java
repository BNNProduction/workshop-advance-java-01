package workshop.potter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class Basket {
	// private List<BasketItem> basketItem = new ArrayList<BasketItem>();
	private Map<Book, Integer> basketItem = new LinkedHashMap<Book, Integer>();
	private Double netPrice;
	private Double discountPrice;
	private Double totalPrice;
	public void addBook(Book book, int quantity) {
		// BasketItem item = new BasketItem(book,quantity);
		// basketItem.add(item);
		if (basketItem.containsKey(book)) {
			int newQuantity = basketItem.get(book)+ quantity;
			basketItem.put(book, newQuantity);
			
		} else {
			basketItem.put(book, quantity);
		}

	}

}
