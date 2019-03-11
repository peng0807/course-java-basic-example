package chapter7.example7_3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import chapter7.User;

public class QueryDataToObject {

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
		List<User> userList = new ArrayList<User>();
		try {
			String sql = "select * from user";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int userId = rs.getInt("userId");
				String userName = rs.getString("userName");
				String password = rs.getString("password");
				User user = new User(userId, userName, password);
				userList.add(user);
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

		for (User user : userList) {
			System.out.println(user);
		}

	}

}
