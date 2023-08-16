package dbmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbconnection.DataBaseConnection;
import model.Department;
import model.Student;

public class StudentBbManager{
	
	public void addStudent(Student student){
		Connection con=DataBaseConnection.getConnection();	
		try {
			PreparedStatement ps=con.prepareStatement("insert into student st_id=?,st_name=?,st_age=?  values (?,?,?)");
			ps.setInt(1, student.getSt_id());
			ps.setString(2, student.getSt_name());
			ps.setInt(3, student.getSt_age());
			System.out.println("--------- Student "+student.getSt_name()+" ------------- is added Successfully");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateStudent(Student student) {
		Connection con=DataBaseConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("update student set st_id=?,set st_name=?, set st_age=? where st_id=?");
			ps.setInt(1, student.getSt_id());
			ps.setString(2, student.getSt_name());
			ps.setInt(3, student.getSt_age());
			System.out.println("---------- Data is updated -----------");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List <Student> getAllStudent(){
		Connection con=DataBaseConnection.getConnection();	
		List<Student> students=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT s.st_id,s.st_name, s.st_age, d.d_id, d.d_name FROM student s INNER JOIN department d ON s.st_id=d.st_id");
		ResultSet rs=	ps.executeQuery();
		while(rs.next()) {
			Student s=new Student();
		          s.setSt_id(rs.getInt("st_id"));
		          s.setSt_name(rs.getString("st_name"));
		          s.setSt_age(rs.getInt("st_age"));
		         Department d=new Department();
		         d.setD_id(rs.getInt("d_id"));
		         d.setD_name(rs.getString("d_name"));
		         s.setDepartment(d);
		         students.add(s);
		}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
	public Student getStudentById(Integer id) {
		Connection con=DataBaseConnection.getConnection();	
		try {
			
			Student s=new Student();
			PreparedStatement ps=con.prepareStatement("SELECT st_id,st_name,st_age FROM student where st_id=?");
			ps.setInt(1, id);
		ResultSet rs=	ps.executeQuery();
		while(rs.next()) {
			System.out.println("------Student Info-------------");
			System.out.println("Id: "+rs.getInt("st_id"));
			System.out.println("Name: "+rs.getString("st_name"));
			System.out.println("Age: "+rs.getInt("st_age"));
		         return s;
		}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 return null;
		
	}
	public void deleteStudent(Integer id) {
		Connection con = DataBaseConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM student WHERE st_id=?");
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			System.out.println("-------------Student deleted ------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}