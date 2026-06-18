import java.util.List;

public class Main {

	public static void main(String[] args) {

		EmployeeRepository empRepository  = new JdbcEmployeeRepository ();
		AttendanceRepository attRepository = new JdbcAttendanceRepository();
		List<Employee> employees = empRepository.findAll();
	
		
		List<DepartmentAttendanceCount> attCounts = attRepository.findDepartmentAttendanceCounts();
		
		for(DepartmentAttendanceCount attCount : attCounts) {
			System.out.println(attCount);
		}
		
		/*
		List<AttendanceDetail> attDetails = attRepository.findByEmployeeId(1);
	
		for (AttendanceDetail attDetail : attDetails) {
			System.out.println(attDetail);
		}
		/*
		attRepository.insert(1,LocalDate.parse("2026-06-03"),
				LocalTime.parse("09:00:00"),
				LocalTime.parse("18:00:00"),
				"completed");
				
		List<AttendanceDetail> attDetails = attRepository.findAllWithEmployee();
		for(AttendanceDetail attDetail :attDetails) {
			System.out.println(attDetail);
		}

		for(Employee employee : employees) {
			System.out.println(employee);
		}
		*/
	}

}
