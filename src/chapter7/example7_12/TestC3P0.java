package chapter7.example7_12;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestC3P0 {
	public static void main(String[] args) throws Exception {
		ComboPooledDataSource cpds = null;
		try {
			cpds = new ComboPooledDataSource("myApp");
//			cpds.setDriverClass("com.mysql.jdbc.Driver");
//			cpds.setJdbcUrl("jdbc:mysql://localhost/test");
//			cpds.setUser("root");
//			cpds.setPassword("");
			
			Properties pro = new Properties();
			InputStream fis = TestC3P0.class.getClassLoader().getResourceAsStream("./dbinfo.properties");
			//加载属性文件
			pro.load(fis);
			fis.close();
			//设置相关属性
			cpds.setDriverClass(pro.getProperty("driver"));
			cpds.setJdbcUrl(pro.getProperty("url"));
			cpds.setUser(pro.getProperty("user"));
			cpds.setPassword(pro.getProperty("password"));
			
			System.out.println("C3P0连接池初始化成功!");
			//从连接池中获取数据库连接
			Connection con = cpds.getConnection();
			System.out.println("成功从C3P0连接池中获取数据库连接对象!");
			Thread.sleep(2000); // 休眠2秒
			//释放连接回连接池
			con.close();
			System.out.println("释放连接，回归连接池!");
			cpds.close(); // 关闭连接池
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}