import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		EmployeeRepository empRepository  = new JdbcEmployeeRepository ();
		AttendanceRepository attRepository = new JdbcAttendanceRepository();
		List<Employee> employees = empRepository.findAll();
	
		
		attRepository.insert(1,LocalDate.parse("2026-06-03"),
				LocalTime.parse("09:00:00"),
				LocalTime.parse("18:00:00"),
				"completed");
		
		
		for(Employee employee : employees) {
			System.out.println(employee);
		}		
	}

}
