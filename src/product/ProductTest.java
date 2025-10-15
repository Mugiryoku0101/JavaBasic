package product;

public class ProductTest {
	public static void main(String[] args) {
		System.out.println("=== 例外処理テスト ===\n");
		
		System.out.println("【テスト1: 正常なデータ】");
		try {
			Product p1 = new Product(1, "冷蔵庫A", 50000, 10);
			System.out.println(p1 + "を登録しました。");
			System.out.println("✓正常に登録されました\n");
		} catch (Exception e) {
			System.out.println("\u001B[31mjava.lang.Exception: " + e.getMessage() + "\u001B[0m");
			System.out.println("×例外が発生しました\n");
		}
		
		System.out.println("【テスト2: 商品名が空】");
		try {
			String emptyName = "";
			System.out.println("無効な入力です。入力された商品名:" + emptyName);
			Product p2 =new Product(2, "", 40000, 7);
			System.out.println(p2 + "を登録しました。");
		} catch (Exception e) {
			System.out.println("\u001B[31mjava.lang.Exception: " + e.getMessage() + "\u001B[0m");
			System.out.println("✓例外処理が正しく動作しました\n");
		}
		
		System.out.println("【テスト3: 価格がマイナス】");
		try {
			int invalidPrice = -100;
			System.out.println("無効な入力です。入力された価格:" + invalidPrice);
			Product p3 = new Product(3, "テレビ", 80000, 5);
			System.out.println(p3 + "を登録しました。");
		} catch (Exception e) {
			System.out.println("\u001B[31mjava.lang.Exception: " + e.getMessage() + "\u001B[0m");;
			System.out.println("✓例外y粗利が正しく動作しました\n");
		}
		
		System.out.println("【テスト4: 在庫数がマイナス】");
		try {
			int invalidStock = -100;
			System.out.println("無効な入力です。入力された在庫:" + invalidStock);
			Product p4 = new Product(4, "洗濯機", 60000, 8);
			System.out.println(p4 + "を登録しました。");
		} catch (Exception e) {
			System.out.println("\u001B[31mjava.lang.Exception: " + e.getMessage() + "\u001B[0m");
			System.out.println("✓例外処理が正しく動作しました\n");
		}
		System.out.println("=== テスト完了 ===");
		}
	}

