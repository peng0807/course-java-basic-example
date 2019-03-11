package chapter7.example7_2;

import java.sql.*;

public class QueryData {

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
		ResultSet rs = null;
		try {
			String sql = "select * from user";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString("password"));
			}
		} catch (SQLException e) {
			System.out.println("查询数据库出错");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("关闭资源出错");
				e.printStackTrace();
				rs = null;
				stmt = null;
				con = null;
			}
			
		}

	}

}
