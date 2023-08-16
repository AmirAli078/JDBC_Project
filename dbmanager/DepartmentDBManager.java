package dbmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbconnection.DataBaseConnection;
import model.Department;

public class DepartmentDBManager {
	
	public void addDepartment(Department department) {
		Connection con = DataBaseConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO department(d_id,d_name,st_id) VALUES(?,?,?)");
			ps.setInt(1, department.getD_id());
			ps.setString(2, department.getD_name());
			ps.setInt(3, 1);

			ps.execute();

			con.close();
			System.out.println("------- Department is Added -------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void updateDepartment(Department department) {
		Connection con =  DataBaseConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE department SET d_name=? WHERE d_id=?");
			ps.setString(1, department.getD_name());
			ps.setInt(2, department.getD_id());
			ps.execute();
			ps.close();
			System.out.println("---------- Department is Updated ------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public Department getDepartmentById(Integer id) {
		Connection con = DataBaseConnection.getConnection();
		Department d = new Department();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT d_id, d_name FROM department WHERE d_id=?");
			ps.setInt(1, id);
			ResultSet rst = ps.executeQuery();
			while (rst.next()) {
				System.out.println("***********************************");
	             System.out.println(rst.getInt("d_id"));
	             System.out.println(rst.getString("d_name"));
	             System.out.println("_____________________________________");
			}
			con.close();
			return d;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	
	public void deleteDepartment(Integer id) {
		Connection con = DataBaseConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM department WHERE d_id=?");
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			System.out.println("------------ Department is  deleted ------------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public List<Department> getAllDepartment() {
		Connection con = DataBaseConnection.getConnection();

		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM department");
			ResultSet rst = ps.executeQuery();

			List<Department> deptList = new ArrayList<>();

			while (rst.next()) {
				Department d = new Department();
				d.setD_id(rst.getInt("d_id"));
				d.setD_name(rst.getNString("d_name"));

				deptList.add(d);
			}
			return deptList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
