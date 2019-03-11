package chapter7.example7_15;

import chapter7.User;
import chapter7.example7_14.DbTools;
import java.sql.*;
import org.apache.commons.dbutils.*;

public class TestDbUtils {
	// 添加用户
	public void addUser(User user) throws SQLException {
		// 1.获取数据库连接对象
		Connection conn = DbTools.getInstance().getConnection();
		// 2.编写sql语句
		String sql = "insert into user(userName,password) values(?,?)";
		// 3.设置参数数组
		Object[] ps = { user.getUserName(), user.getPassword() };
		QueryRunner qr = new QueryRunner();
		// 4.执行SQL操作
		qr.update(conn, sql, ps);
		// 关闭连接
		DbUtils.close(conn);
	}

	// 将名字为userName的用户密码修改password
	public void updateUser(String userName, String password) throws SQLException {
		Connection conn = DbTools.getInstance().getConnection();
		String sql = "update user set password=? where userName=?";
		Object[] ps = { password, userName };
		QueryRunner qr = new QueryRunner();
		qr.update(conn, sql, ps);
		DbUtils.close(conn);
	}

	// 删除用户名为userName的用户
	public void delUser(String userName) throws SQLException {
		Connection conn = DbTools.getInstance().getConnection();
		String sql = "delete from user where userName=?";
		Object[] ps = { userName };
		QueryRunner qr = new QueryRunner();
		qr.update(conn, sql, ps);
		DbUtils.close(conn);
	}

	// 测试
	public static void main(String[] args) throws Exception {
		User user = new User("刘十", "liu@azc");
		TestDbUtils testor = new TestDbUtils();
		// 添加新用户
		testor.addUser(user);
		System.out.println("添加用户成功!");
		// 修改用户信息
		testor.updateUser("刘十", "123@zzz");
		System.out.println("用户密码修改成功!");
		// 删除用户
		testor.delUser("刘十");
		System.out.println("用户删除成功!");
	}
}
