package dbmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbconnection.DataBaseConnection;
import model.Course;

public class CourseDBManager {
	
	public void addCourse(Course course) {
		Connection con = DataBaseConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO course(c_id,c_name,c_name2,c_name3,c_name4,st_id) VALUES(?,?,?,?,?,?)");
			ps.setInt(1, course.getC_id());
			ps.setString(2, course.getC_name());
			ps.setString(3, course.getC_name2());
			ps.setString(4, course.getC_name3());
			ps.setString(5, course.getC_name4());
			ps.setInt(6, course.getSt_id());

			ps.execute();

			con.close();
			System.out.println("----------Course is Added---------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void updateCourseById(Course course) {
		Connection con = DataBaseConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE course SET c_id=?,c_name=?,c_name2=?,c_name3=?,c_name4=?,st_id=? WHERE c_id=?");
			
			ps.setInt(1, course.getC_id());
			ps.setString(2, course.getC_name());
			ps.setString(3, course.getC_name2());
			ps.setString(4, course.getC_name3());
			ps.setString(5, course.getC_name4());
			ps.setInt(6, 1);
			ps.execute();
			ps.close();
			System.out.println("--------------Course is Updated------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void deleteCourseById(Integer id) {
		Connection con = DataBaseConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM course WHERE c_id=?");
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			System.out.println("---------------Course is deleted ---------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public List<Course> getAllCourses() {
		Connection con = DataBaseConnection.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement("SELECT c_id, c_name,c_name2,c_name3,c_name4 FROM course");
			ResultSet rst = ps.executeQuery();

			List<Course> courses = new ArrayList<>();

			while (rst.next()) {
				Course c = new Course();
				c.setC_id(rst.getInt("c_id"));
				c.setC_name(rst.getString("c_name"));
				c.setC_name2(rst.getString("c_name2"));
				c.setC_name3(rst.getString("c_name3"));
				c.setC_name4(rst.getString("c_name4"));

				courses.add(c);
			}
			return courses;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	

}
