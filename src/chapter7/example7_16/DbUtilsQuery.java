package chapter7.example7_16;

import java.sql.Connection;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import chapter7.User;
import chapter7.example7_14.DbTools;

public class DbUtilsQuery {
	public static void main(String[] args) throws Exception {
		Connection conn = DbTools.getInstance().getConnection();
		System.out.println("成功创建数据库连接");
		// 1.根据id查询用户(BeanHandler使用)
		QueryRunner runner = new QueryRunner();
		String sql = "select * from user where userId=?";
		User user = runner.query(conn, sql, new BeanHandler<User>(User.class), 1);
		System.out.println("1.id=1的用户信息为:" + user);

		// 2.查询所有用户(BeanListHandler使用)
		sql = "select * from user";
		BeanListHandler<User> beanListHandler = new BeanListHandler<User>(User.class);
		List<User> list = runner.query(conn, sql, beanListHandler);
		System.out.println("2.打印输出全部用户信息");
		for (User u : list) {
			System.out.println(u);
		}
		// 3.查询总的记录数(ScalarHandler使用)
		sql = "select count(*) from user";
		long count = (long) runner.query(conn, sql, new ScalarHandler("count(*)"));
		System.out.println("3.总记录数为:" + count);

		// 4.查询按id升序排序的前4条记录(BeanListHandler使用)
		sql = "select * from user   order by userId asc limit 0, 4";
		beanListHandler = new BeanListHandler<User>(User.class);
		list = runner.query(conn, sql, beanListHandler);
		System.out.println("4.输出前4条记录");
		for (User u : list) {
			System.out.println(u);
		}

		// 5.查询某一列的所有数据(ColumnListHandler使用)
		sql = "select userName from user";
		List<String> userNameList = runner.query(conn, sql, new ColumnListHandler<String>("userName"));
		System.out.println("5.输出所有用户名");
		for (String s : userNameList) {
			System.out.println(s);
		}
		conn.close();
	}
}