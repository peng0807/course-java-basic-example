package chapter7.example7_5;
import java.sql.*;
public class GetGeneratedKey {
	public static void main(String[] args) throws Exception{
		//载入驱动类
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("成功载入驱动类");
		//创建连接
		String conStr = "jdbc:mysql://localhost/test?user=root&password=";
		Connection con = DriverManager.getConnection(conStr);
		System.out.println("成功创建连接");
		//创出Statement对象
		Statement stmt = con.createStatement();
		System.out.println(stmt.executeUpdate("insert into user(userName,password) values ('王五','789')", Statement.RETURN_GENERATED_KEYS));
		//获得包含主键的ResultSet对象
		ResultSet rs = stmt.getGeneratedKeys();
		if(rs.next()) {
			System.out.println(rs.getInt(1));
		}
	}
}
