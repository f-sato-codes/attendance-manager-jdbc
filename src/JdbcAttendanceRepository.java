import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class JdbcAttendanceRepository implements  AttendanceRepository {
	
	private static final String URL = "jdbc:mysql://localhost:3306/"
			+ "attendance_manager_db";
	private static final String USER = "product_user";
	private static final String PASSWORD = "product_pass";
	
	//データの挿入
	@Override
	public int insert(int employeeId, LocalDate workDate, LocalTime startTime,
					LocalTime endTime, String status){
			
		String sql = "insert into daily_attendances "
		           + "(employee_id, work_date, start_time, end_time, status) "
		           + "values (?, ?, ?, ?, ?)";
		try(	
			Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement statement = connection.prepareStatement(sql);
		){
			statement.setInt(1,employeeId);
			statement.setDate(2, java.sql.Date.valueOf(workDate));
			statement.setTime(3, java.sql.Time.valueOf(startTime));
			statement.setTime(4, java.sql.Time.valueOf(endTime));
			statement.setString(5,status);
			
			int count = statement.executeUpdate();			
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return 0;
	}
	
	//社員勤怠一覧
	@Override
	public List<AttendanceDetail> findAllWithEmployee() {
		List<AttendanceDetail> attendanceDetails = new ArrayList<>();

		String sql = "select att.id as attendance_id, "
		           + "att.employee_id, "
		           + "emp.name as employee_name, "
		           + "emp.department, "
		           + "att.work_date, "
		           + "att.start_time, "
		           + "att.end_time, "
		           + "att.status as attendance_status "
		           + "from daily_attendances as att "
		           + "left join employees as emp "
		           + "on emp.id = att.employee_id "
		           + "order by att.work_date asc, att.id asc";

		try (
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
		) {
			while (resultSet.next()) {
				int attendanceId = resultSet.getInt("attendance_id");
				int employeeId = resultSet.getInt("employee_id");
				String employeeName = resultSet.getString("employee_name");
				String department = resultSet.getString("department");
				LocalDate workDate = resultSet.getDate("work_date").toLocalDate();
				LocalTime startTime = resultSet.getTime("start_time").toLocalTime();
				LocalTime endTime = resultSet.getTime("end_time").toLocalTime();
				String attendanceStatus = resultSet.getString("attendance_status");

				attendanceDetails.add(new AttendanceDetail(
						attendanceId,
						employeeId,
						employeeName,
						department,
						workDate,
						startTime,
						endTime,
						attendanceStatus
				));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return attendanceDetails;
	}

	//指定した社員の勤怠の一覧
	@Override
	public List<AttendanceDetail> findByEmployeeId(int employeeId) {
		List<AttendanceDetail> attendanceDetails  = new ArrayList<>();

		String sql = "select att.id as attendance_id,att.employee_id,"
				+ "emp.name as employee_name,"
				+ "	emp.department,att.work_date,"
				+ "	att.start_time,att.end_time,"
				+ "	att.status as attendance_status "
				+ "	from daily_attendances as att left join employees as emp"
				+ "	on emp.id = att.employee_id"
				+ "	where att.employee_id = ?"
				+ "  	order by att.work_date asc,att.id asc";
		
	try (
		Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
		PreparedStatement statement = connection.prepareStatement(sql);
		){
		statement.setInt(1,employeeId);
		ResultSet resultSet = statement.executeQuery();

		while(resultSet.next()) {	
			int attendanceId = resultSet.getInt("attendance_id");
			int employeeIdFromDb  = resultSet.getInt("employee_id");
			String employeeName = resultSet.getString("employee_name");
			String department = resultSet.getString("department");
			LocalDate workDate = resultSet.getDate("work_date").toLocalDate();
			LocalTime startTime = resultSet.getTime("start_time").toLocalTime();
			LocalTime endTime = resultSet.getTime("end_time").toLocalTime();
			String attendanceStatus = resultSet.getString("attendance_status");
			
			attendanceDetails.add(new AttendanceDetail(
					attendanceId,
					employeeIdFromDb,
					employeeName,
					department,
					workDate,
					startTime,
					endTime,
					attendanceStatus
			));
		}
	} catch (SQLException e) {
			e.printStackTrace();
		}		
		return attendanceDetails ;
	}
	
}
