package product.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteProduct {

	

			public static int deleteProductByCategory(int categoryId) {
		String sql = "DELETE FROM products WHERE category_id = ?";
		
		try (Connection conn = ProductDB.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setInt(1, categoryId);
			
			int rowsAffected = pstmt.executeUpdate();
			
			return rowsAffected;
			
		} catch (SQLException e) {
			System.err.println("データベースエラーが発生しました");
			System.out.println("エラー内容：" + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("-商品の削除（カテゴリーID指定）-");
			
			System.out.println("削除するカテゴリーIDを入力してください：");
			int categoryId = scanner.nextInt();
			
			int rowsAffected = deleteProductByCategory(categoryId);
			
			System.out.println("削除成功件数：" + rowsAffected + "件");
			
			if (rowsAffected > 0) {
				System.out.println("カテゴリーID" + categoryId + "の商品を削除しました");
			} else {
				System.out.println("該当する商品が見つかりませんでした。");
			}
			
		} catch (Exception e) {
			System.out.println("エラーが発生しました：" + e.getMessage());
			e.printStackTrace();
		} finally {
			scanner.close();
			}
		}
	}
