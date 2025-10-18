package product.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdateMultipleProducts {
	
	static class ProductUpdate {
		int productId;
		int price;
		int stock;
		
		ProductUpdate(int productId, int price, int stock) {
			this.productId = productId;
			this.price = price;
			this.stock = stock;
		}
	}

	public static boolean updateMultipleProducts(List<ProductUpdate> products) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int totalUpdate = 0;
		boolean allSuccess = true;
		
		try {
			conn = ProductDB.getConnection();
			conn.setAutoCommit(false);
			
			String sql = "UPDATE products SET price = ?, stock = ? WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			
			for (ProductUpdate product : products) {
				pstmt.setInt(1, product.price);
				pstmt.setInt(2, product.stock);
				pstmt.setInt(3, product.productId);
				
				int rowsAffected = pstmt.executeUpdate();
				
				if (rowsAffected == 0) {
					allSuccess = false;
					System.out.println(products.size() + "件全ての更新に失敗しました。");
					break;
				}
				totalUpdate += rowsAffected;
			}
			
			if (allSuccess && totalUpdate == products.size()) {
				conn.commit();
				System.out.println("コミット成功");
				System.out.println("更新成功件数：" + totalUpdate + "件");
				System.out.println();
				
				for (int i = 0; i < products.size(); i++) {
					ProductUpdate p = products.get(i);
					System.out.println("更新内容" + (i + 1) + "：");
					System.out.println("商品ID：" + p.productId + ", 価格：" + p.price + ", 在庫数：" + p.stock);
					if (i < products.size() - 1) {
						System.out.println();
					}
				}
				return true;
			} else {
				conn.rollback();
				System.out.println("更新成功件数：" + totalUpdate + "件");
				System.out.println("ロールバックしました。");
				return false;
					}
				} catch (SQLException e) {
					System.err.println("データベースエラーが発生しました");
					System.err.println("エラー内容：" + e.getMessage());
					
					if (conn != null) {
						try {
							conn.rollback();
							System.out.println("ロールバックしました。");
						} catch (SQLException rollbackEx) {
							System.err.println("ロールバックに失敗しました：" + rollbackEx.getMessage());
			}
		}
	
	    e.printStackTrace();
	    return false;
} finally {
	try {
		if (pstmt != null) pstmt.close();
		if (conn != null) {
			conn.setAutoCommit(true);
			conn.close();
		}
	} catch (SQLException e) {
		e.printStackTrace();
	   }
	}
}

public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	List<ProductUpdate> products = new ArrayList<>();
	
	try {
		System.out.println("--商品の価格と在庫の更新①--");
		System.out.println("商品IDを入力してください：");
		int productId1 = scanner.nextInt();
		System.out.println("価格を入力してください：");
		int price1 = scanner.nextInt();
		System.out.println("在庫を入力してください：");
		int stock1 = scanner.nextInt();
		products.add(new ProductUpdate(productId1, price1, stock1));
		
		System.out.println("--商品の価格と在庫を更新②--");
		System.out.println("商品IDを入力してください：");
		int productId2 = scanner.nextInt();
		System.out.println("価格を入力してください：");
		int price2 = scanner.nextInt();
		System.out.println("在庫を入力してください：");
		int stock2 = scanner.nextInt();
		products.add(new ProductUpdate(productId2, price2, stock2));
		
		updateMultipleProducts(products);
	} catch (Exception e) {
		System.err.println("エラーが発生しました：" + e.getMessage());
		e.printStackTrace();
	} finally {
		scanner.close();
	}
	}
}
