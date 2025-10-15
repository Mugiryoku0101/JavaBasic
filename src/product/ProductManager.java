package product;

import java.util.ArrayList;
import java.util.List;

public class ProductManager implements Searchable {
	private List<Product_bak> products;
	
	public ProductManager() {
		this.products = new ArrayList<>();
	}
	public void addProduct(Product_bak product) {
		products.add(product);
		System.out.println("商品を追加しました：" + product.getName());
	}
	public void removeProduct(int id) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getId() == id) {
				Product_bak removed = products.remove(i);
				System.out.println("商品を削除しました；" + removed.getName());
				return;
			}
		}
		
			System.out.println("ID=" + id + "の商品が見つかりませんでした");
		}
		public Product_bak getProductByName(String name) {
			for (Product_bak product : products) {
				if (product.getName().equals(name)) {
					return product;
				}
			}
			return null;
		}
		public void displayAllProducts() {
			for (Product_bak product : products) {
				System.out.println(product);
				}
			}
		public List<Product_bak> getAllProducts() {
			return products;
		}
		
		@Override
		public List<Product_bak> search(String keyword) {
			List<Product_bak> result = new ArrayList<>();
			
			for (Product_bak product : products) {
				if (product.getName().toLowerCase().contains(keyword.toLowerCase())) {
					result.add(product);
				}
			}
			return result;
		}
		
     }
