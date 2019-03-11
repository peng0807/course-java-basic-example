package chapter7.example7_7;

import java.sql.*;

public class DelData {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/test?user=root&password=";
			con = DriverManager.getConnection(url);
			System.out.println("成功连接数据库");
		} catch (ClassNotFoundException e) {
			System.out.println("载入JDBC驱动类出错");
			e.printStackTrace();
			return;
		} catch (SQLException e) {
			System.out.println("创建数据库连接出错");
			e.printStackTrace();
			return;
		}

		Statement stmt = null;
		try {
			String sql = "delete from user where userName = '王五'";
			stmt = con.createStatement();
			int count = stmt.executeUpdate(sql);
			System.out.println("影响的记录条数是：" + count);
		} catch (SQLException e) {
			System.out.println("更新数据库出错");
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("关闭资源出错");
				e.printStackTrace();
				stmt = null;
				con = null;
			}
			
		}

	}
}
