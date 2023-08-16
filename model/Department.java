package model;

public class Department {
	private Integer d_id;
	private String d_name;
	private Student student;
	public Integer getD_id() {
		return d_id;
	}
	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	

}
