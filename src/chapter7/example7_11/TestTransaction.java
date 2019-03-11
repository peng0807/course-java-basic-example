package chapter7.example7_11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestTransaction {
	
	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/test?rewriteBatchedStatements=true&user=root&password=zsc123";
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

		String sql = "insert into user(userId, userName, password) values(?,?,?)";
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(sql);
//			con.setAutoCommit(false); // 禁止事务自动提交
			ps.setInt(1, 1);
			ps.setString(2, "张三");
			ps.setString(3, "abcd");
			ps.executeUpdate();
			ps.setInt(1, 1);
			ps.setString(2, "李四");
			ps.setString(3, "1234");
			ps.executeUpdate();
//			con.commit();
		} catch (SQLException e) {
			System.out.println("更新数据库出错，事务回滚");
			e.printStackTrace();
//			try {
//				con.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//				System.out.println("事务回滚失败");
//			}
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("关闭资源出错");
				e.printStackTrace();
				ps = null;
				con = null;
			}
		}
	}
}
