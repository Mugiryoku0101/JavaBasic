package product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductSelect {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/shopdb";
		String user = "root";
		String password = "1234";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("✓DB接続成功");
			
			stmt = conn.createStatement();
			String sql = "SELECT id, name, price, stock FROM products";
			rs = stmt.executeQuery(sql);
			
			System.out.println("--- 商品一覧 ---");
			while (rs.next()) {
				int  id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				int stock = rs.getInt("stock");
				System.out.println(id + " ｜ " + name + " ｜ " + price + "円 ｜ 在庫:" + stock);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("× JDBCドライバエラー:" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("× SQLエラー:" + e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
				System.out.println("🔒接続を閉じました");
			} catch (SQLException e) { 
			    System.out.println("！クローズ時のエラー:" + e.getMessage());
			}
		}
	}
}