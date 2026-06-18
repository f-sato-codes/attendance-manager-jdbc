
public class DepartmentAttendanceCount {
	private String department;
	private int attendanceCount;
	
	public DepartmentAttendanceCount(String department, int attendanceCount) {
		this.department = department;
		this.attendanceCount = attendanceCount;
	}

	public String getDepartment() {
		return department;
	}

	public int getAttendanceCount() {
		return attendanceCount;
	}

	@Override
	public String toString() {
		return "DepartmentAttendanceCount [department=" + department + ", attendanceCount=" + attendanceCount + "]";
	}
}
