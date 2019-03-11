package chapter7.example7_13;

import java.sql.*;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestProperties {
	public static void main(String[] args) throws Exception {
		ComboPooledDataSource cpds = new ComboPooledDataSource("myApp");
		System.out.println("C3P0连接池初始化成功!");
		Connection con = cpds.getConnection();
		System.out.println("从C3P0连接池中获取数据库连接对象!");
		Thread.sleep(2000);
		con.close();
		System.out.println("释放连接，回归连接池!");
		cpds.close();
		System.out.println("关闭数据库连接池!");
	}
}