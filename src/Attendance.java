import java.time.LocalDate;
import java.time.LocalTime;

public class Attendance {
	//フィールド
	private int id;
	private int employeeId;
	private  LocalDate workDate;
	private LocalTime startTime;
	private LocalTime endTime;
	private String status;

	
	//コンストラクタ
	public Attendance(int id, int employeeId, LocalDate workDate, LocalTime startTime, LocalTime endTime,
			String status) {

		this.id = id;
		this.employeeId = employeeId;
		this.workDate = workDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
	}

	//ゲッター
	public int getId() {
		return id;
	}


	public int getEmployeeId() {
		return employeeId;
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


	public String getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "Attendance [id=" + id + ", employeeId=" + employeeId + ", workDate=" + workDate + ", startTime="
				+ startTime + ", endTime=" + endTime + ", status=" + status + "]";
	}

}
