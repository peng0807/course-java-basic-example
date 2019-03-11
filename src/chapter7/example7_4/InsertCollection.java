package chapter7.example7_4;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import chapter7.User;

public class InsertCollection {

	public static void main(String[] args) {
		List<User> userList = new ArrayList<User>();
		userList.add(new User("麻六","1234"));
		userList.add(new User("钱7","abcd"));
		
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/test?user=root";
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
			stmt = con.createStatement();
			for(User user : userList) {
				String sql = "insert into user(userName, password) values('" + user.getUserName() + "','" + user.getPassword() + "')";
				stmt.executeUpdate(sql);
			}
			System.out.println("对象列表已插入");
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
