package product.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddProduct {

	
			public static int addProduct(String name, int price, int stock, int categoryId) {
		String sql = "INSERT INTO products (name, price, stock, category_id) VALUES (?, ?, ?, ?)";
		
		try (Connection conn = ProductDB.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			
			pstmt.setString(1, name);
			pstmt.setInt(2, price);
			pstmt.setInt(3, stock);
			pstmt.setInt(4, categoryId);
			
			int rowsAffected = pstmt.executeUpdate();
			
			return rowsAffected;
		
		} catch (SQLException e) {
			System.out.println("データベースエラーが発生しました");
			System.out.println("エラー内容：" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("-商品の登録-");
			
			System.out.println("商品名を入力してください：");
			String name = scanner.nextLine();
			
			System.out.println("価格を入力してください：");
			int price = scanner.nextInt();
			
			System.out.println("在庫数を入力してください：");
			int stock = scanner.nextInt();
			
			System.out.println("カテゴリーIDを入力してください：");
			int categoryId = scanner.nextInt();
			
			int rowsAffected = addProduct(name, price, stock, categoryId);
			
			System.out.println("登録成功件数：" + rowsAffected + "件");
			System.out.println("登録内容：");
			System.out.println("商品名：" + name + ", 価格：" + price + ", 在庫数：" + stock + ", カテゴリーID：" + categoryId);
		} catch (Exception e) {
			System.out.println("エラーが発生しました：" + e.getMessage());
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		}
	}
