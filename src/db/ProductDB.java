
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDB {
	
		private static final String URL = "jdbc:mysql://localhost:3306/product_management";
		private static final String USER = "root";
		private static final String PASSWORD = "17610610tk";
		
		public void testConnection() {
			Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB接続成功");
			
		} catch (ClassNotFoundException e) {
			System.out.println("DB接続失敗");
			System.out.println("JDBC Driverが見つかりません：" + e.getMessage());
		
		} catch (SQLException e) {
			System.out.println("DB接続失敗");
			System.out.println("データベース接続エラー：" + e.getMessage());
			
		} finally {
			if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) { 
			    System.err.println("接続クローズエラー:" + e.getMessage());
			}
		}
	}
}
		
public void getAllProducts() {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				
				stmt = conn.createStatement();
				
				String sql = "SELECT id, name, price, stock, category_id FROM products";
				rs = stmt.executeQuery(sql);
				
				System.out.println("--- productsテーブルの全ての商品情報を表示 ---");
				System.out.println();
				
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					int price = rs.getInt("price");
					int stock = rs.getInt("stock");
					int categoryId = rs.getInt("category_id");
					
					System.out.println("id: " + id);
					System.out.println("name: " + name);
	                System.out.println("price: " + price);
	                System.out.println("stock: " + stock);
	                System.out.println("category_id: " + categoryId);
	                System.out.println();
				}
				
			} catch (ClassNotFoundException e) {
				System.err.println("JDBC Driverが見つかりません：" + e.getMessage());
			} catch (SQLException e) {
				System.out.println("データベースエラー：" + e.getMessage());
				
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						System.err.println("ResultSetクローズエラー：" + e.getMessage());
					}
				}
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						System.err.println("Statementクローズエラー：" + e.getMessage());
					}
				}
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						System.err.println("Connectionクローズエラー：" + e.getMessage());
					}	
				}
			}
}

public static void main(String[] args) {
	ProductDB productDB = new ProductDB();
	
	System.out.println("--- パート1： データベース接続テスト ---");
	productDB.testConnection();
	System.out.println();
	System.out.println("--- パート2： 商品データ取得 ---");
	productDB.getAllProducts();
}

}


		