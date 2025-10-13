package product;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		ProductManager manager = new ProductManager();
		
		manager.addProduct(new Product(1, "冷蔵庫", 50000, 10));
		DiscountedProduct sofa = new DiscountedProduct(2, "ソファ", 30000, 5, 0.3);
		manager.addProduct(sofa);
		manager.addProduct(new Product(3, "米", 2000, 3));
		manager.addProduct(new Product(4, "小説", 1500, 4));
		manager.addProduct(new Product(5, "Tシャツ", 1500, 5));
		
		System.out.println("---商品を5つ追加して全て表示する---");
		manager.displayAllProducts();
		
		System.out.println("---商品を1つ削除して全て表示する---");
		manager.removeProduct(1);
		manager.displayAllProducts();
		
		System.out.println("---商品名「米」の情報を表示する---");
		
		Product rice = manager.getProductByName("米");
		 if (rice != null) {
	            System.out.println(rice);
	        } else {
	            System.out.println("商品が見つかりませんでした");
	        }
		 
		 System.out.println("--商品名「ソファ」の情報と割引率30％の情報を表示する--");
	       List<Product> sofaResult = manager.search("ソファ");
	       for (Product product : sofaResult) {
	    	   System.out.println(product);
	       }
	       System.out.println("--商品名「Tシャツ」を検索して表示する--");
	       List<Product> tshirtResult = manager.search("Tシャツ");
	       for (Product product : tshirtResult) {
	    	   System.out.println(product);
	        }
	}

}
