package chapter7.example7_1;

import java.sql.*;

public class ConnectMySQL {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/test?user=root";
			con = DriverManager.getConnection(url);
			System.out.println("成功连接数据库");
		} catch (ClassNotFoundException e) {
			System.out.println("载入JDBC驱动类出错");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("创建数据库连接出错");
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("关闭数据库连接出错");
					e.printStackTrace();
					con = null;
				}
			}
		}

	}

}
