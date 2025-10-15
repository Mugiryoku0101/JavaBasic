package product;

import java.util.List;

public class Main_bak {
	public static void main(String[] args) {
		ProductManager manager = new ProductManager();
		
		manager.addProduct(new Product_bak(1, "冷蔵庫", 50000, 10));
		DiscountedProduct sofa = new DiscountedProduct(2, "ソファ", 30000, 5, 0.3);
		manager.addProduct(sofa);
		manager.addProduct(new Product_bak(3, "米", 2000, 3));
		manager.addProduct(new Product_bak(4, "小説", 1500, 4));
		manager.addProduct(new Product_bak(5, "Tシャツ", 1500, 5));
		
		System.out.println("---商品を5つ追加して全て表示する---");
		manager.displayAllProducts();
		
		System.out.println("---商品を1つ削除して全て表示する---");
		manager.removeProduct(1);
		manager.displayAllProducts();
		
		System.out.println("---商品名「米」の情報を表示する---");
		
		Product_bak rice = manager.getProductByName("米");
		 if (rice != null) {
	            System.out.println(rice);
	        } else {
	            System.out.println("商品が見つかりませんでした");
	        }
		 
		 System.out.println("--商品名「ソファ」の情報と割引率30％の情報を表示する--");
	       List<Product_bak> sofaResult = manager.search("ソファ");
	       for (Product_bak product : sofaResult) {
	    	   System.out.println(product);
	       }
	       System.out.println("--商品名「Tシャツ」を検索して表示する--");
	       List<Product_bak> tshirtResult = manager.search("Tシャツ");
	       for (Product_bak product : tshirtResult) {
	    	   System.out.println(product);
	        }
	}

}
