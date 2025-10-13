package product;

import java.util.ArrayList;
import java.util.List;

public class ProductManager implements Searchable {
	private List<Product> products;
	
	public ProductManager() {
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
		public List<Product> getAllProducts() {
			return products;
		}
		
		@Override
		public List<Product> search(String keyword) {
			List<Product> result = new ArrayList<>();
			
			for (Product product : products) {
				if (product.getName().toLowerCase().contains(keyword.toLowerCase())) {
					result.add(product);
				}
			}
			return result;
		}
		
     }
