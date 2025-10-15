package product;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static java.util.ArrayList<Product> productList = new ArrayList<>();
	private static java.util.Scanner scanner = new Scanner(System.in);
	
public static void main(String[] args) {
	boolean running = true;
	
	while (running) {
		showMenu();
		
		try {
			int choice = Integer.parseInt(scanner.nextLine());
			switch (choice) {
			case 1:
				addProduct();
				break;
			case 2:
				getProductInfo();
				break;
			case 3:
				searchProduct();
				break;
			case 4:
				displayAllProducts();
				break;
			case 5:
				deleteProduct();
				break;
			case 0:
				System.out.println("終了します");
				running = false;
				break;
				default:
					System.out.println("無効な選択です。もう一度選択してください。");
			}
			System.out.println();
		} catch (NumberFormatException e) {
			System.out.println("数値を入力してください。\n");
				
			}
		}
	scanner.close();
}

private static void showMenu() {
	System.out.println("--メニュー--");
	System.out.println("1:商品追加");
	System.out.println("2:商品情報取得");
	System.out.println("3:商品検索");
	System.out.println("4:商品全て表示");
	System.out.println("5:商品削除");
	System.out.println("0:終了");
	System.out.println();
	System.out.println("メニューから操作を選択してください。");
}
private static void addProduct() {
	try {
		System.out.println("商品IDを入力してください：");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.println("入力された商品ID：" + id);
		
		System.out.println("商品名を入力してください。");
		String name = scanner.nextLine();
		
		if (name.trim().isEmpty()) {
			System.out.println("無効な入力です。入力された商品名：");
			throw new Exception("無効な入力です。商品名を正しく入力してください。");
		}
		System.out.println("入力された商品名：" + name);
		
		System.out.println("価格を入力してください：");
		int price = Integer.parseInt(scanner.nextLine());
		
		if (price < 0) {
			System.out.println("無効な入力です。入力された価格：" + price);
			throw new Exception("無効な入力です。価格を正しく入力してください。");
		}
		System.out.println("入力された価格:" + price);
		
		System.out.println("在庫数を入力してください：");
		int stock = Integer.parseInt(scanner.nextLine());
		
		if (stock < 0) {
			System.out.println("無効な入力です。入力された在庫数：" + stock);
			throw new Exception("無効な入力です。在庫を正しく入力してください。");
		}
		System.out.println("入力された在庫：" + stock);
		
		Product product = new Product(id, name, price, stock);
		productList.add(product);
		System.out.println(product + "を登録しました。");
		
	} catch (NumberFormatException e) {
		System.out.println("\u001B[34mjava.lang.Exception:\u001B[0m " +
		        "\u001B[31m無効な入力です。数値を正しく入力してください。\u001B[0m" + 
				"\u001B[31mat product.Main.main(\u001B[34mMain.java:104\u001B[31m)\u001B[0m");
	} catch (Exception e) {
		System.out.println("\u001B[34mjava.lang.Exception:\u001B[0m " +
		        "\u001B[31m" + e.getMessage() + "\u001B[0m");
	}
}
private static void getProductInfo() {
	System.out.println("商品情報を取得する商品名を入力してください：");
	String name = scanner.nextLine().trim();
	
	for (Product product : productList) {
		if (product.getName().trim().equals(name)) {
			System.out.println("取得した商品は、" + product + "です。");
			return;
		}
	}
	System.out.println("商品名「" + name + "」の商品は見つかりませんでした。");
}
private static void searchProduct() {
	System.out.println("検索する商品名を入力してください：");
	String keyword = scanner.nextLine().trim();
	
	boolean found = false;
	
	for (Product product : productList) {
		if (product.getName().trim().contains(keyword)) {
			System.out.println(product);
			found = true;
		}
	}
	
	if (!found) {
		System.out.println("「" + keyword + "」を含む商品は見つかりませんでした。");
	}
}
private static void displayAllProducts() {
	System.out.println("商品を全て表示します");
	
	if (productList.isEmpty()) {
		System.out.println("登録されている商品はありません。");
		return;
	}
	
	for (Product product : productList) {
		System.out.println(product);
	}
}

private static void deleteProduct() {
    try {
        System.out.println("削除する商品のIDを入力してください：");
        int id = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(i);
                System.out.println("商品IDが" + id + "の商品を削除しました");
                return;
            }
        }
        
        System.out.println("商品ID「" + id + "」の商品は見つかりませんでした。");
        
    } catch (NumberFormatException e) {
        System.out.println("無効な入力です。数値を入力してください。");
    }
}
}


