package studentdatabaseapp;

import java.sql.*;

import java.util.Scanner;

public class Student {
	private String firstName;
	private String lastName;
	private String gradeYear;
	private String studentID;
	private String courses = null;
	private int tuitionBalance = 0;
	private static int costOfCourse = 600;
	private static int id = 1000;
	private static int studentid = 1;
	
	//Constructor: prompt user to enter students name and year
	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter student first name: ");
		this.firstName = in.nextLine();
		
		System.out.println("Enter student last name: ");
		this.lastName = in.nextLine();
		
		System.out.println("1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior\nEnter student class level: ");
		this.gradeYear = in.nextLine();
		
		setStudentID();
	
		
		
		System.out.println(firstName + " " + lastName + " " + gradeYear + studentID);
	
		
		
	}
	
	//Generate and ID
	private void setStudentID() {
		//Grade Level + ID
		id++;
		this.studentID =  gradeYear + "" +id;
	}
	
	//Enroll in courses
	public void enroll() {
		// Get inside a loop, user hits 0
		do {
			System.out.print("Enter course to enroll (Q to quit): ");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			//if (course != "Q") {
			if (!course.contentEquals("Q")) {
				courses = courses + "\n  " + course;
				tuitionBalance = tuitionBalance + costOfCourse;
			}else {break;}
		} while (1 != 0);
		System.out.println("ENROLLED IN: " + courses);
	
	}
	
	// View balance
	public void viewBalance() {
		System.out.println("Your balance is: $" + tuitionBalance);
	}
	
	//Pay tuition
	public void payTuition() {
		viewBalance();
		System.out.println("Enter your payment: $");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		tuitionBalance = tuitionBalance - payment;
		System.out.println("Thank you for your payment of $" + payment);
		viewBalance();
		
	}
	
	//Show status
	public String toString() {
		return "Name: " + firstName + " " + lastName +
				"\nGrade Level:" + gradeYear +
				"\nStudent ID: " + studentID +
				"\nCourses Enrolled:" + courses +
				"\n Balance: $" + tuitionBalance;
	}
	
	/*
	 * public static void clearTable() throws Exception { String url =
	 * "jdbc:mysql://localhost:3306/school2"; String uname = "root"; String pass
	 * ="123456789"; String query ="delete from students";
	 * Class.forName("com.mysql.cj.jdbc.Driver"); Connection con =
	 * DriverManager.getConnection(url,uname,pass); Statement st =
	 * con.createStatement(); int rs = st.executeUpdate(query); st.close();
	 * con.close(); }
	 */
	
	public void loadMysql() throws Exception {

		String url = "jdbc:mysql://localhost:3306/school2";
		String uname = "root";
		String pass ="123456789";
		String query = "insert into students values (?,?,?,?,?,?,?)";
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		PreparedStatement st = con.prepareStatement(query);//PreparedStatement
		st.setInt(1, studentid);
		st.setString(2, firstName);
		st.setString(3, lastName);
		st.setString(4, gradeYear);
		st.setString(5, studentID);
		st.setString(6, courses);
		st.setInt(7, tuitionBalance);
		
		int count = st.executeUpdate();
		System.out.println(count + " row/s affected");
		studentid++;
		
		st.close();
		con.close();
	}

}
