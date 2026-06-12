import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class JdbcAttendanceRepository implements  AttendanceRepository {
	
	private static final String URL = "jdbc:mysql://localhost:3306/"
			+ "attendance_manager_db";
	private static final String USER = "product_user";
	private static final String PASSWORD = "product_pass";
	
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
}
