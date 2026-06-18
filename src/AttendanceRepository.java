import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AttendanceRepository {

	int insert(int employeeId, LocalDate workDate, LocalTime startTime,
				LocalTime endTime, String status);
	
	List<AttendanceDetail> findAllWithEmployee();
	
	List<AttendanceDetail> findByEmployeeId(int employeeId);
	
	List<DepartmentAttendanceCount> findDepartmentAttendanceCounts();
	
}
