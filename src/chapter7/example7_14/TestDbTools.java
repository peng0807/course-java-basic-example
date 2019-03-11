package chapter7.example7_14;

import java.sql.Connection;

public class TestDbTools {

	public static void main(String[] args) throws InterruptedException {
		DbTools tools = DbTools.getInstance();
		Connection con = tools.getConnection();
		System.out.println("成功创建连接");
		Thread.sleep(10000);
		tools.close(con);
	}

}
