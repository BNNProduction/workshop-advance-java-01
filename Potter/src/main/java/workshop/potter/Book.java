package workshop.potter;

import lombok.Data;

@Data
public class Book {
	private String name;
	private Double price;

	Book(BookBuilder builder) {
		this.name = builder.name;
		this.price = builder.price;
	}

	Book(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	
	@Data
	public static class BookBuilder {
		private String name;
		private Double price;

		BookBuilder(String name, Double price) {
			this.name = name;
			this.price = price;
		}

		public Book build() {
			Book book = new Book(this);
			return book;
		}

	}
}
