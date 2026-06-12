import java.time.LocalDate;
import java.time.LocalTime;

public interface AttendanceRepository {

	int insert(int employeeId, LocalDate workDate, LocalTime startTime,
				LocalTime endTime, String status);
	
}
