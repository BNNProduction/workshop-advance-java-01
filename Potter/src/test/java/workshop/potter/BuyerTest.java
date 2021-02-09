package workshop.potter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyerTest {
	@Test
	public void buy_1_books() {
		// 1. Create basket
		Basket basket = new Basket();
		// 2. Add book to basket
		basket.addBook(Catalog.PotterI(), 1);
		// 3. Checkout
		Checkout checkout = new Checkout();
		checkout.process(basket);
		assertEquals(8.00, basket.getNetPrice()); // 8.00
		assertEquals(0, basket.getDiscountPrice()); // 0
		assertEquals(8.00, basket.getTotalPrice()); // 0
	}

	@Test
	public void buy_2_books() {
		// 1. Create basket
		Basket basket = new Basket();
		// 2. Add book to basket
		basket.addBook(Catalog.PotterI(), 1);
		basket.addBook(Catalog.PotterII(), 1);
		// 3. Checkout
		Checkout checkout = new Checkout();
		checkout.process(basket);

		// Check netPrice = 16, discountPrice 5%
		assertEquals(16.00, basket.getNetPrice()); // 16.00
		assertEquals(0.80, basket.getDiscountPrice()); // 0.8
		assertEquals(15.20, basket.getTotalPrice()); // 15.20
	}

	@Test
	public void buy_3_books() {
		// 1. Create basket
		Basket basket = new Basket();
		// 2. Add book to basket
		basket.addBook(Catalog.PotterI(), 1);
		basket.addBook(Catalog.PotterII(), 1);
		basket.addBook(Catalog.PotterIII(), 1);
		// 3. Checkout
		Checkout checkout = new Checkout();
		checkout.process(basket);

		// Check netPrice = 24, discountPrice 24 - 10%
		assertEquals(24.00, basket.getNetPrice()); // 24.00
		assertEquals(2.40, basket.getDiscountPrice()); // 2.40
		assertEquals(21.60, basket.getTotalPrice()); // 21.60
	}
	@Test
	public void buy_4_books() {
		// 1. Create basket
		Basket basket = new Basket();
		// 2. Add book to basket
		basket.addBook(Catalog.PotterI(), 1);
		basket.addBook(Catalog.PotterII(), 1);
		basket.addBook(Catalog.PotterIII(), 1);
		basket.addBook(Catalog.PotterIV(), 1);
		// 3. Checkout
		Checkout checkout = new Checkout();
		checkout.process(basket);

		// Check netPrice = 32, discountPrice 32 - 20%
		assertEquals(32.00, basket.getNetPrice()); // 32.00
		assertEquals(6.40, basket.getDiscountPrice()); // 6.40
		assertEquals(25.60, basket.getTotalPrice()); // 25.60
	}
	@Test
	public void buy_5_books() {
		// 1. Create basket
		Basket basket = new Basket();
		// 2. Add book to basket
		basket.addBook(Catalog.PotterI(), 1);
		basket.addBook(Catalog.PotterII(), 1);
		basket.addBook(Catalog.PotterIII(), 1);
		basket.addBook(Catalog.PotterIV(), 1);
		basket.addBook(Catalog.PotterV(), 1);
		// 3. Checkout
		Checkout checkout = new Checkout();
		checkout.process(basket);

		// Check netPrice = 40, discountPrice 40 - 25%
		assertEquals(40.00, basket.getNetPrice()); // 40.00
		assertEquals(10.00, basket.getDiscountPrice()); // 10.00
		assertEquals(30.00, basket.getTotalPrice()); // 30.00
	}

	@Test
	@DisplayName("ซื้อหนังสือ Potter 1 จำนวน 2 เล่ม จะไม่ได้รับส่วนลด")
	public void buy_2_books_same_book() {
		// 1. Create basket
		Basket basket = new Basket();
		// 2. Add book to basket
		basket.addBook(Catalog.PotterI(), 1);
		basket.addBook(Catalog.PotterI(), 1);
		// 3. Checkout
		Checkout checkout = new Checkout();
		checkout.process(basket);
		// Check netPrice = 16, discountPrice 0%
		assertEquals(16.00, basket.getNetPrice()); // 16.00
		assertEquals(0, basket.getDiscountPrice()); // 0
		assertEquals(16.00, basket.getTotalPrice()); // 16.00
	}

	@Test
	public void buy_2_books_same_book_size_of_book_is_1() {
		// 1. Create basket
		Basket basket = new Basket();
		// 2. Add book to basket
		basket.addBook(Catalog.PotterI(), 1);
		basket.addBook(Catalog.PotterI(), 1);

		// Check size of book in basket
		assertEquals(1, basket.getBasketItem().size()); // total diff book
		assertEquals(2, basket.getBasketItem().get(Catalog.PotterI())); // Quantity of PotterI in basket is 2

	}

	@Test
	public void buy_3_books_same_book_size_of_book_is_2() {
		// 1. Create basket
		Basket basket = new Basket();
		// 2. Add book to basket
		basket.addBook(Catalog.PotterI(), 1);
		basket.addBook(Catalog.PotterI(), 1);
		basket.addBook(Catalog.PotterII(), 1);

		// Check size of book in basket
		assertEquals(2, basket.getBasketItem().size()); // total diff book
		assertEquals(2, basket.getBasketItem().get(Catalog.PotterI())); // Quantity of PotterI in basket is 2
		assertEquals(1, basket.getBasketItem().get(Catalog.PotterII())); // Quantity of PotterII in basket is 1

	}

	@Test
	public void buy_3_books_same_book_size_of_book_is_2_getDiscount_5percent_but_book3_pay8EUR() {
		// 1. Create basket
		Basket basket = new Basket();
		// 2. Add book to basket
		basket.addBook(Catalog.PotterI(), 1);
		basket.addBook(Catalog.PotterI(), 1);
		basket.addBook(Catalog.PotterII(), 1);
		// 3. Checkout
		Checkout checkout = new Checkout();
		checkout.process(basket);
		// Check netPrice = 24, discountPrice 16 - 5% = 15.20 totalprice = 23.20
		assertEquals(24.00, basket.getNetPrice()); // 24.00
		assertEquals(0.80, basket.getDiscountPrice()); // 0.80
		assertEquals(23.20, basket.getTotalPrice()); // 23.20

	}

	@Test
	public void buy_4_books_same_book_size_of_book_is_3_getDiscount_10percent_but_book4_5_pay8EUR() {
		// 1. Create basket
		Basket basket = new Basket();
		// 2. Add book to basket
		basket.addBook(Catalog.PotterI(), 1);
		basket.addBook(Catalog.PotterI(), 1);
		basket.addBook(Catalog.PotterII(), 1);
		basket.addBook(Catalog.PotterIII(), 1);
		// 3. Checkout
		Checkout checkout = new Checkout();
		checkout.process(basket);

		// Check netPrice = 32, discountPrice 24 - 10% = 21.6 totalprice = 28.60
		assertEquals(32.00, basket.getNetPrice()); // 32.00
		assertEquals(2.40, basket.getDiscountPrice()); // 2.40
		assertEquals(29.60, basket.getTotalPrice()); // 29.60

	}

}
