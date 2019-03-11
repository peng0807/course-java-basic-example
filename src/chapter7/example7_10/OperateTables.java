package chapter7.example7_10;

import java.sql.*;

import chapter7.Department;
import chapter7.Employee;

public class OperateTables {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/test?user=root&password=";
		Connection con = DriverManager.getConnection(url);
		String deptName = "海外市场部";
		// 创建新雇员对象
		Employee employee = new Employee("李松明", new Department(deptName));
		// 1.查询部门是否存在
		String sql = "select * from department where name=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, deptName);
		ResultSet rs = ps.executeQuery(); // 执行查询
		int deptId; // 部门主键id
		if (rs.next()) {
			// 2.部门已经存在
			System.out.println("部门:" + deptName + "已经存在.");
			deptId = rs.getInt("id"); // 获取部门主键id
		} else {
			// 3.部门不存在
			System.out.println("部门:" + deptName + "不存在.");
			// 插入新部门记录
			sql = "insert into department(name) values(?)";
			// 插入记录的同时需要获取该记录的主键Id
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, deptName);
			ps.executeUpdate();
			// 获取新部门的id
			rs = ps.getGeneratedKeys();
			rs.next();
			deptId = rs.getInt(1);
		}
		employee.getDepartment().setId(deptId);
		// 4.插入雇员数据
		sql = "insert into employee(departmentId, name) values(?,?)";
		ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.setLong(1, employee.getDepartment().getId());
		ps.setString(2, employee.getName());
		ps.executeUpdate();
		rs = ps.getGeneratedKeys(); // 获取新雇员的主键id
		rs.next();
		int employeeId = rs.getInt(1);
		employee.setId(employeeId);
		System.out.println("雇员数据插入成功.");
		System.out.println(employee.getDepartment());
		System.out.println(employee);
		rs.close();
		ps.close();
		con.close();
	}
}
