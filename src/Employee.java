
public class Employee {
	//フィールド
	private int id;
	private String name;
	private String department;
	private String status;
	
	//コンストラクタ
	public Employee(int id, String name, String department, String status) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.status = status;
	}
	

	//ゲッター
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDepartment() {
		return department;
	}
	public String getStatus() {
		return status;
	}
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", status=" + status + "]";
	}
	
}
