package chapter7.example7_8;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import chapter7.User;

public class TestPreparedStatement {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/test?user=root&password=root";
		Connection con = DriverManager.getConnection(url);
		String name = "钱7";
		String sql = "select * from user where userName=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		List<User> userList = new ArrayList<User>();
		while (rs.next()) {
			int userId = rs.getInt("userId");
			String userName = rs.getString("userName");
			String password = rs.getString("password");
			User user = new User(userId, userName, password);
			userList.add(user);
		}
		rs.close();
		ps.close();
		con.close();
		for (User user : userList) {
			System.out.println(user);
		}
	}
}