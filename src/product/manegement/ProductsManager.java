package product.manegement;

import java.util.ArrayList;
import java.util.List;

public class ProductsManager {
	private List<Product> products;
	
	public ProductsManager() {
		this.products = new ArrayList<>();
	}
	public void addProduct(Product product) {
		products.add(product);
		System.out.println("商品を追加しました：" + product.getName());
	}
	public void removeProduct(int id) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getId() == id) {
				Product removed = products.remove(i);
				System.out.println("商品を削除しました；" + removed.getName());
				return;
			}
		}
		
			System.out.println("ID=" + id + "の商品が見つかりませんでした");
		}
		public Product getProductByName(String name) {
			for (Product product : products) {
				if (product.getName().equals(name)) {
					return product;
				}
			}
			return null;
		}
		public void displayAllProducts() {
			for (Product product : products) {
				System.out.println(product);
				}
			}
		}