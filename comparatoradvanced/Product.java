package comparatoradvanced;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Product {
	private String name;
	private int priceCents;
	private int stockLevel;

	public Product(String name, int priceCents, int stockLevel) {
		this.name = name;
		this.priceCents = priceCents;
		this.stockLevel = stockLevel;
	}

	@Override
	public String toString() {
		return this.name + ": " + this.stockLevel + " @ $" + this.priceCents / 100.0;
	}

	/**
	 * This comparator should sort products alphabetically (or lexicographically) by
	 * their name.
	 */
	static class AlphabeticalComparator implements Comparator<Product> {
		@Override
		public int compare(Product p1, Product p2) {
			return p1.name.compareTo(p2.name);
		}
	}

	/**
	 * This comparator should sort products by whether or not they are in stock,
	 * then in ascending order by their price.
	 *
	 * After sorting, products that have a positive stock level should appear before
	 * products that have a stock level of 0. If two products being sorted are
	 * either 1) both in stock; or 2) both out of stock, they should then be sorted
	 * based on their price in ascending order.
	 */
	static class PriceStockComparator implements Comparator<Product> {
		@Override
		public int compare(Product p1, Product p2) {
			//suppose two Products p1 and p2 are being compared
			//basically we need to return a negative number if we want p1 to be placed before(above) p2 (for ascending), return positive otherwise
			//for equal values, we need to return 0.
			
			//if p1.stockLevel is 0 or less, and p2.stock level is greater than 0, then return positive number so p1 come after p2.
			if (p1.stockLevel <= 0 && p2.stockLevel > 0) {
				return 1;
			} else if (p2.stockLevel <= 0 && p1.stockLevel > 0) {
				return -1;
			}
			return Double.compare(p1.priceCents, p2.priceCents);
		}
	}

	public static void main(String[] args) {
		Product p1 = new Product("Apple", 123, 12);
		Product p2 = new Product("Ball", 122, 34);
		Product p3 = new Product("Sun", 456, 2);
		Product p4 = new Product("Plutonium", 543, 23);
		Product p5 = new Product("GamaRay", 332, 22);
		Product p6 = new Product("Oxygen", 135, 0);
		Product p7 = new Product("KFC", 511, 0);

		ArrayList<Product> productList = new ArrayList<>(List.of(p1, p2, p3, p4, p5, p6, p7));

		System.out.println("Products sorted according to their name are: ");
		productList.sort(new AlphabeticalComparator());
		for (Product product : productList) {
			System.out.println(product);
		}
		System.out.println();

		System.out.println("Products sorted according to their stock availability, then price are: ");
		productList.sort(new PriceStockComparator());
		for (Product product : productList) {
			System.out.println(product);
		}
		System.out.println();
	}
}