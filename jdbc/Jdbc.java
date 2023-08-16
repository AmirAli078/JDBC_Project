package jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dbmanager.CourseDBManager;
import dbmanager.DepartmentDBManager;
import dbmanager.StudentBbManager;
import model.Course;
import model.Department;
import model.Student;


public class Jdbc {
	DepartmentDBManager departmentdbmanager=new DepartmentDBManager();
	StudentBbManager studentBbmanager=new StudentBbManager();
	CourseDBManager coursedbmanager=new CourseDBManager(); 
	
	
	public void courseManagement() {
		Scanner s=new Scanner(System.in);
		int choice;
		do {
			System.out.println("_________________________________________________________________________");
			System.out.println("|------------- Wellcome into Course Management System -------------------|");
			System.out.println("|________________________________________________________________________|");
			System.out.println("1: ADD Course\n2: UPDATE Course\n3: DELETE Course\n4: GET ALL Course\n5 EXIT");
			  System.out.print("enter your choice: ");
			 choice=s.nextInt();
			 switch(choice) {
			 case 1:{
				 Scanner sc=new Scanner(System.in);
					Course cr=new Course();
					System.out.println("Enter Course id: ");
					int id=sc.nextInt();
					cr.setC_id(id);
					System.out.println("Enter Course name: ");
					String name=sc.next();
				    cr.setC_name(name);
					System.out.println("Enter Course name2: ");
					String name2=sc.next();
				    cr.setC_name2(name2);
					System.out.println("Enter Course name3: ");
					String name3=sc.next();
				    cr.setC_name3(name3);
					System.out.println("Enter Course name4: ");
					String name4=sc.next();
				    cr.setC_name4(name4);
				    System.out.println("ENTER STUDENT ID: ");
				    int st_id=sc.nextInt();
				    cr.setSt_id(st_id);
				    coursedbmanager.addCourse(cr);
				break;
			 }
			 case 2:{
				 Scanner sc=new Scanner(System.in);
				 System.out.println("Enter COURSE id to update COURSE: ");
				 int id=sc.nextInt();
				 Course cr=new Course();
				 cr.setC_id(id);
				 System.out.println("enter new name of Course: ");
				 String name=sc.next();
				 cr.setC_name(name);
				 coursedbmanager.updateCourseById(cr);
				 break;
			 }
			 case 3:{
				 Scanner sc=new Scanner(System.in);
				 System.out.println("Enter Course id to Delete Course: ");
				 int id=sc.nextInt();
				 coursedbmanager.deleteCourseById(id);
				 break;
			 }
			 case 4:{
				List<Course> cor= coursedbmanager.getAllCourses();
				 for(Course c: cor) {
					 System.out.println("*******************");
					 System.out.println("Id: "+c.getC_id());
					 System.out.println("Course Name: "+c.getC_name());
					 System.out.println("Course Name2: "+c.getC_name2());
					 System.out.println("Course Name3: "+c.getC_name3());
					 System.out.println("Course Name4: "+c.getC_name4());
					 
				 }
                 break;
			 }
			 }
			
		}while(choice!=5);
		
	}
	
	
	public void studentManagemet() {
		Scanner s=new Scanner(System.in);
		int choice;
		do {
			System.out.println("___________________________________________________________________");
			System.out.println("|------------ Wellcome into Student Management System -------------|");
			System.out.println("|___________________________________________________________________|");
			System.out.println("1: ADD Student\n2: UPDATE Student\n3: DELETE student\n4: GET student By Id\n5: GET ALL Student\n6 EXIT");
			  System.out.print("enter your choice: ");
			 choice=s.nextInt();
			 switch(choice) {
			 case 1:{
				 Scanner sc=new Scanner(System.in);
					Student st=new Student();
					System.out.println("Enter Student id: ");
					int id=sc.nextInt();
					st.setSt_id(id);
					System.out.println("Enter Student name: ");
					String name=sc.next();
				    st.setSt_name(name);
					System.out.println("Enter Student age: ");
					int age=sc.nextInt();
					st.setSt_age(age);
					studentBbmanager.addStudent(st);
				break;
			 }
			 case 2:{
				 Scanner sc=new Scanner(System.in);
				 System.out.println("Enter Student id to update Student: ");
				 int id=sc.nextInt();
				 Student st =studentBbmanager.getStudentById(id);
				 st.setSt_id(id);
				 System.out.println("enter new name of Student: ");
				 String name=sc.next();
				 st.setSt_name(name);
				 studentBbmanager.updateStudent(st);
				 break;
			 }
			 case 3:{
				 Scanner sc=new Scanner(System.in);
				 System.out.println("Enter Student id to Delete Student: ");
				 int id=sc.nextInt();
				 studentBbmanager.deleteStudent(id);
				 break;
			 }
			 case 4:{
				 Scanner sc=new Scanner(System.in);
				 System.out.println("Enter Student id to get Student Information: ");
				 int id=sc.nextInt();
				 studentBbmanager.getStudentById(id);
				 break;
			 }
			 case 5:{
				List<Student> li= studentBbmanager.getAllStudent();
				 for(Student s1: li) {
					 System.out.println("*******************");
					 System.out.println("Id: "+s1.getSt_id());
					 System.out.println("Name: "+s1.getSt_name());
					 System.out.println("Name: "+s1.getSt_age());
					 
				 }
                 break;
			 }
			 }
			
		}while(choice!=6);
		
	}
public void departmentManagement() {
		Scanner s=new Scanner(System.in);
		int choice;
		do {
			System.out.println("___________________________________________________________________________");
			System.out.println("|-------------- Wellcome into Department Management System ----------------|");
			System.out.println("|___________________________________________________________________________|");
			System.out.println("1: ADD Department\n2: UPDATE Department\n3: DELETE Department\n4: GET Department By Id\n5: GET ALL Departments\n6 EXIT");
			  System.out.print("enter your choice: ");
			 choice=s.nextInt();
			 switch(choice) {
			 case 1:{
				 Scanner sc=new Scanner(System.in);
					Department d=new Department();
					System.out.println("Enter department id: ");
					int id=sc.nextInt();
					d.setD_id(id);
					System.out.println("Enter Department name: ");
					String name=sc.next();
					d.setD_name(name);
					departmentdbmanager.addDepartment(d);
				break;
			 }
			 case 2:{
				 Scanner sc=new Scanner(System.in);
				 System.out.println("Enter Department id to update department: ");
				 int id=sc.nextInt();
				 Department d=departmentdbmanager.getDepartmentById(id);
				 d.setD_id(id);
				 System.out.println("enter new name of department: ");
				 String name=sc.next();
				 d.setD_name(name);
				 departmentdbmanager.updateDepartment(d);
				 break;
			 }
			 case 3:{
				 Scanner sc=new Scanner(System.in);
				 System.out.println("Enter Department id to Delete department: ");
				 int id=sc.nextInt();
				 departmentdbmanager.deleteDepartment(id);
				 break;
			 }
			 case 4:{
				 Scanner sc=new Scanner(System.in);
				 System.out.println("Enter Department id to get department info:: ");
				 int id=sc.nextInt();
				 departmentdbmanager.getDepartmentById(id);
				 break;
			 }
			 case 5:{
				List<Department> li= departmentdbmanager.getAllDepartment();
				 for(Department d: li) {
					 System.out.println("*******************");
					 System.out.println("Id: "+d.getD_id());
					 System.out.println("Name: "+d.getD_name());
					 
				 }
                 break;
			 }
			 }
			
		}while(choice!=6);
		
		
		
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int ch;
		do {
			System.out.println("____________________________________________________________________");
			System.out.println("| --------- wellcome to College management System ------------------|");
			System.out.println("|___________________________________________________________________|");
			System.out.println("	1: 		Department Management");
			System.out.println("	2: 		Student Management");
			System.out.println("	3: 		Course Management");
			System.out.println("	4: 		exit");
			System.out.println("What you want to manage: ");
			ch=sc.nextInt();
			Jdbc jd=new Jdbc();
			switch(ch) {
			case 1:{
				jd.departmentManagement();
				break;
			}
			case 2:{
				jd.studentManagemet();
				break;
			}
			case 3:{
				jd.courseManagement();
			}
			}
		}
		while(ch!=4);

	}
}
