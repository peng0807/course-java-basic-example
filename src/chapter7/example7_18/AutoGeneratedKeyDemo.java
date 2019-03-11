package chapter7.example7_18;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import chapter7.User;
import chapter7.example7_14.DbTools;

//演示插入记录并获取新记录的主键id值
public class AutoGeneratedKeyDemo {
	public static void main(String[] args) throws SQLException {
		User user = new User("testUser", "test@azc");
		// 1.获取数据库连接对象
		Connection conn = DbTools.getInstance().getConnection();
		QueryRunner qr = new QueryRunner();
		// 2.编写sql语句
		String sql = "insert into user(userName,password) values(?,?)";
		// 3.设置参数数组
		Object[] ps = { user.getUserName(), user.getPassword() };
		// 4.执行SQL操作
		Long userId = qr.insert(conn, sql, new ScalarHandler<Long>(1), ps);
		// 关闭连接
		System.out.println("新增记录的主键id为:"+userId);
		DbUtils.close(conn);
	}
}