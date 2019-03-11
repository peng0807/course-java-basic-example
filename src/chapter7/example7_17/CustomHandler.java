package chapter7.example7_17;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.*;

import chapter7.Department;
import chapter7.Employee;
import chapter7.example7_14.DbTools;

class EmployeeHandler implements ResultSetHandler<Employee>{
	@Override
	public Employee handle(ResultSet rs) throws SQLException {
		Employee employee = null;
		if(rs.next()){
			employee = new Employee();
			employee.setId(rs.getInt("e.id"));
			employee.setName(rs.getString("e.name"));
			int departmentId = rs.getInt("d.id");
			String departmentName = rs.getString("d.name");
			Department department = new Department(departmentId, departmentName);
			employee.setDepartment(department);
		}
		return employee;
	}
}

class EmployeeListHandler implements ResultSetHandler<List<Employee>>{
	@Override
	public List<Employee> handle(ResultSet rs) throws SQLException {
		List<Employee> list = new ArrayList<Employee>();
		while(rs.next()) {
			Employee employee = new Employee();
			employee.setId(rs.getInt("e.id"));
			employee.setName(rs.getString("e.name"));
			int departmentId = rs.getInt("d.id");
			String departmentName = rs.getString("d.name");
			Department department = new Department(departmentId, departmentName);
			employee.setDepartment(department);
			list.add(employee);
		}
		return list;
	}
}

public class CustomHandler {
	public static void main(String[] args) throws SQLException {
		Connection conn = DbTools.getInstance().getConnection();
		System.out.println("成功创建数据库连接");
		QueryRunner runner = new QueryRunner();
		//1.查询输出id为3的雇员信息
		System.out.println("1:id=3的雇员信息:");
		String sql = "select * from employee as e, department as d where e.id=? and e.departmentId=d.id";
		EmployeeHandler employeeHandler = new EmployeeHandler();
		Employee employee = runner.query(conn, sql, employeeHandler, 3);
		System.out.println(employee);
		// 查询部门id=4的所有雇员信息
		System.out.println("2:id=4部门的所有雇员:");
		sql = "select * from employee as e, department as d where d.id=? and e.departmentId=d.id";
		EmployeeListHandler employeeListHandler = new EmployeeListHandler();
		List<Employee> employeeList = runner.query(conn, sql, employeeListHandler, 4);
		for (Employee e : employeeList) {
			System.out.println(e);
		}
	}
}