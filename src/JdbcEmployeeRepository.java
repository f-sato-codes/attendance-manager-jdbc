import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcEmployeeRepository implements  EmployeeRepository{

	private static final String URL = "jdbc:mysql://localhost:3306/attendance_manager_db";
	private static final String USER = "product_user";
	private static final String PASSWORD = "product_pass";

	@Override
	public List<Employee> findAll() {
		List<Employee> employees = new ArrayList<>();
		
		String sql = "select * from employees";
		
			try (
				Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);	
				){
				while(resultSet.next()) {
					int id = resultSet.getInt("id");
					String name = resultSet.getString("name");
					String department = resultSet.getString("department");
					String status = resultSet.getString("status");
					
					employees.add(new Employee(id,name,department,status));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	return employees;
	}
}
