import java.util.List;

public class Main {

	public static void main(String[] args) {

		EmployeeRepository repository  = new JdbcEmployeeRepository ();
		List<Employee> employees = repository.findAll();
	
		for(Employee employee : employees) {
			System.out.println(employee);
		}		
	}
}
