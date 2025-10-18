package product.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateProduct {

			
public static int updateProduct(int productId, int newPrice, int newStock) {
		String sql = "UPDATE products SET price = ?, stock = ? WHERE id = ?";
		
		try (Connection conn = ProductDB.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setInt(1, newPrice);
			pstmt.setInt(2, newStock);
			pstmt.setInt(3, productId);
			
			int rowsAffected = pstmt.executeUpdate();
			
			return rowsAffected;
			
		} catch (SQLException e) {
			System.err.println("データベースエラーが発生しました");
			System.err.println("エラー内容：" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("-商品の価格と在庫を更新-");
			
			System.out.println("商品IDを入力してください：");
			int productId = scanner.nextInt();
			
			System.out.println("価格を入力してください：");
			int newPrice = scanner.nextInt();
			
			System.out.println("在庫数を入力してください：");
			int newStock = scanner.nextInt();
			
			int rowsAffected = updateProduct(productId, newPrice, newStock);
			
			System.out.println("更新成功件数：" + rowsAffected + "件");
			
			if (rowsAffected > 0) {
				System.out.println("更新内容：");
				System.out.println("商品ID：" + productId + ", 価格：" + newPrice + ", 在庫数：" + newStock);
			} else {
				System.out.println("更新失敗");
			}
		} catch (Exception e) {
			System.out.println("エラーが発生しました：" + e.getMessage());
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}
