package chapter7.example7_9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
 
public class TestBatch {
	
	public static void main(String[] args) {
		int size = 200;
		String[] names = new String[size];
		String[] passwords = new String[size];
		for(int i=0; i<size; i++) {
			names[i] = "name" + i;
			passwords[i] = "password" + i;
		}
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/test?rewriteBatchedStatements=true&user=root&password=";
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

		String sql = "insert into user(userName, password) values(?,?)";
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(sql);
			
			Date d1 = new Date();
			for(int i=0; i<size; i++) {
				ps.setString(1, names[i]);
				ps.setString(2, passwords[i]);
				ps.executeUpdate();
			}
			Date d2 = new Date();
			System.out.println("对象列表已插入，非批处理方式耗时：" + (d2.getTime()-d1.getTime()));
			
			Date d3 = new Date();
			for(int i=0; i<size; i++) {
				ps.setString(1, names[i]);
				ps.setString(2, passwords[i]);
				ps.addBatch();
			}
			ps.executeBatch();
			Date d4 = new Date();
			System.out.println("对象列表已插入，批处理方式耗时：" + (d4.getTime()-d3.getTime()));
		} catch (SQLException e) {
			System.out.println("更新数据库出错");
			e.printStackTrace();
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
