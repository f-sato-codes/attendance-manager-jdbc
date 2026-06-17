import java.time.LocalDate;
import java.time.LocalTime;

public class AttendanceDetail {
	private int attendanceId;
	private int employeeId;
	private String employeeName;
	private String department;
	private LocalDate workDate;
	private LocalTime startTime;
	private LocalTime endTime;
	private String attendanceStatus;

	
	public AttendanceDetail(int attendanceId, int employeeId, String employeeName, String department,
			LocalDate workDate, LocalTime startTime, LocalTime endTime, String attendanceStatus) {
		this.attendanceId = attendanceId;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.department = department;
		this.workDate = workDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.attendanceStatus = attendanceStatus;
	}

	//ゲッター
	public int getAttendanceId() {
		return attendanceId;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public String getDepartment() {
		return department;
	}


	public LocalDate getWorkDate() {
		return workDate;
	}


	public LocalTime getStartTime() {
		return startTime;
	}


	public LocalTime getEndTime() {
		return endTime;
	}


	public String getAttendanceStatus() {
		return attendanceStatus;
	}


	@Override
	public String toString() {
		return "AttendanceDetail [attendanceId=" + attendanceId + ", employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", department=" + department + ", workDate=" + workDate + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", attendanceStatus=" + attendanceStatus + "]";
	}
	
	
}
