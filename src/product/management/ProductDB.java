package product.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDB {
	private static final String URL = "jdbc:mysql://localhost:3306/product_management";
	private static final String USER = "root";
	private static final String PASSWORD = "17610610tk";
			
	public static Connection getConnection() throws SQLException {
	return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	public static void createTable() {
		String dropTable ="DROP TABLE IF EXISTS products";
		
		String createTable = 
			 "CREATE TABLE products (" +
		     "id INT AUTO_INCREMENT PRIMARY KEY, " +
		     "name VARCHAR(100) NOT NULL, " +
			 "price INTEGER NOT NULL, " +
			 "stock INTEGER NOT NULL, " +
		     "category_id INTEGER NOT NULL" +
			 ")";
         
		String[] insertData = {
				"INSERT INTO products (name, price, stock, category_id) VALUES ('冷蔵庫', 50000, 10, 1)",
				"INSERT INTO products (name, price, stock, category_id) VALUES ('ソファ', 30000, 10000, 2)",
				"INSERT INTO products (name, price, stock, category_id) VALUES ('米', 2000, 50, 3)",
				"INSERT INTO products (name, price, stock, category_id) VALUES ('小説', 1500, 20000, 4)",
				"INSERT INTO products (name, price, stock, category_id) VALUES ('Tシャツ', 1500, 20000, 5)"
		};
		
		try (Connection conn = getConnection();
				Statement stmt = conn.createStatement()) {
			
			stmt.executeUpdate(dropTable);
			System.out.println("既存のテーブルを削除しました");
			
			stmt.executeUpdate(createTable);
			System.out.println("productsテーブルを作成しました");
			
			for (String insert : insertData) {
				stmt.executeUpdate(insert);
			}
			System.out.println("初期データを投入しました（５件）");
			
		} catch (SQLException e) {
			System.err.println("テーブル作成エラー：" + e.getMessage());
			e.printStackTrace();
			}
		}
		
	public static void main(String[] args) {
		System.out.println("=== データベース初期化開始 ===");
		createTable();
		System.out.println("=== データベースの初期化完了 ===");
	}
}

