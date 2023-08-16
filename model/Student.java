package model;

public class Student {
	private Integer st_id;
	private String st_name;
	private Integer st_age;
	private Department department;
	public Integer getSt_id() {
		return st_id;
	}
	public void setSt_id(Integer st_id) {
		this.st_id = st_id;
	}
	public String getSt_name() {
		return st_name;
	}
	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}
	public Integer getSt_age() {
		return st_age;
	}
	public void setSt_age(Integer st_age) {
		this.st_age = st_age;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

}
