package chapter7.example7_14;

import java.sql.Connection;
import java.sql.SQLException;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DbTools {

	private ComboPooledDataSource dataSource = null;
	
	private DbTools() {
		dataSource = new ComboPooledDataSource("myApp");
//		dataSource = new ComboPooledDataSource();
	}
	
	private static class DBToolsFactory {
		private static DbTools instance = new DbTools();
	}
	
	public static DbTools getInstance() {
		return DBToolsFactory.instance;
	}
	
	public Connection getConnection() {
		Connection con = null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		if(dataSource!=null) {
			dataSource.close();
		}
	}
	
	
}
