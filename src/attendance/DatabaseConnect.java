package attendance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.AdminModel;
import models.StudentModel;
import models.TeacherModel;

class PreparedQueries {
	
	public PreparedStatement ADD_STUDENT, ADD_ATTENDANCE, LOGIN, VIEW_STUDENT,MARK_ATTENDANCE,COUNT,STUDENT_LOGIN,STUDENT_DETAILS,ADMIN_LOGIN;
	
	public PreparedQueries(Connection con) throws Exception {
		
		this.ADMIN_LOGIN=con.prepareStatement("SELECT * FROM ADMIN WHERE AD_ID=? AND AD_PSWD=?");
		this.ADD_STUDENT = con.prepareStatement("INSERT INTO STUDENT VALUES(?, ?, ?, ?, ?, ?)");
		this.ADD_ATTENDANCE = con.prepareStatement("INSERT INTO ATTENDANCE(STUDENT_ID, SUBJECT_ID, STATUS) VALUES(?,?,?)");
		this.LOGIN = con.prepareStatement("SELECT * FROM TEACHER_DTLS WHERE T_ID=? AND T_PSWD=?");
		this.VIEW_STUDENT = con.prepareStatement("select * from student inner join COURSE_SUBJECT on student.ST_COURSE=COURSE_SUBJECT.COURSE_NAME WHERE COURSE_SUBJECT.SUBJECT_NAME=?");
		this.MARK_ATTENDANCE = con.prepareStatement("insert into attendance VALUES(?,?,?,?)");
		this.COUNT=con.prepareStatement("SELECT COUNT(*) AS c FROM STUDENT");
		this.STUDENT_LOGIN=con.prepareStatement("SELECT * FROM STUDENT WHERE ST_ID=? AND S_PSWD=?");
		this.STUDENT_DETAILS=con.prepareStatement("SELECT SUBJECT_ID,ROUND((COUNT(CASE WHEN STATUS = 'P' THEN 1 END) / COUNT(*)) * 100, 2) AS ATTENDANCE_PERCENTAGE FROM ATTENDANCE WHERE STUDENT_ID = ? GROUP BY  SUBJECT_ID");
	}
	
}
public class DatabaseConnect {

	Connection con;
	Statement st;
	PreparedQueries queries;
	
	public DatabaseConnect() throws Exception{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		this.con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "hr", "Thottathil1");
		this.st = con.createStatement();
		queries = new PreparedQueries(con);
		
	}
	
	AdminModel adminlogin(String adid,String adpassword) throws SQLException {
		queries.ADMIN_LOGIN.setString(1,adid);
		queries.ADMIN_LOGIN.setString(2,adpassword);
		
		System.out.println(adid + " " + adpassword);
		
		ResultSet adresult = queries.ADMIN_LOGIN.executeQuery();
		
		if(adresult.next()) {
			AdminModel admin = new AdminModel();
			admin.adid=adresult.getString("AD_ID");
			admin.adpswd=adresult.getString("AD_PSWD");
			return admin;
		}
		return null;
		
	}
	
	TeacherModel login(String tid, String password) throws SQLException {
		
		queries.LOGIN.setString(1, tid);
		queries.LOGIN.setString(2, password);

		ResultSet result = queries.LOGIN.executeQuery();
		
		if(result.next()) {
			TeacherModel teacher  = new TeacherModel();
			teacher.tid = result.getString("T_ID");
			teacher.name = result.getString("T_NAME");
			teacher.subject = result.getString("SUBJECT");
			return teacher;
		}
		return null;
	}
	
	List<StudentModel> fetchAllStudent(String subject) throws SQLException{
		queries.VIEW_STUDENT.setString(1, subject);
		ResultSet rs= queries.VIEW_STUDENT.executeQuery();
		List<StudentModel>  students=new ArrayList<>();
		while(rs.next()) {
			StudentModel student = new StudentModel();
			student.age =rs.getInt("ST_AGE");
			student.course=rs.getString("ST_COURSE");
			student.id=rs.getString("ST_ID");
			student.name=rs.getString("ST_NAME");
			student.year=rs.getInt("ST_YEAR");
			students.add(student);
			
		}
		return students;
				
	}
	
	public void markAttendance(String studentId,String subjectName,Boolean status) throws SQLException {
		queries.MARK_ATTENDANCE.setString(1, studentId);
		queries.MARK_ATTENDANCE.setString(2, subjectName);
		queries.MARK_ATTENDANCE.setDate(3, new Date(System.currentTimeMillis()));
		queries.MARK_ATTENDANCE.setString(4,status?"P":"A");
		queries.MARK_ATTENDANCE.executeUpdate();
		
	}
	
	public void addStudents(String name,String course,int year ,int age) throws SQLException{
		
		ResultSet rs=queries.COUNT.executeQuery();
		rs.next();
		int id=rs.getInt("c")+1;
		queries.ADD_STUDENT.setString(1, "S"+id);
		queries.ADD_STUDENT.setString(2, name);
		queries.ADD_STUDENT.setString(3, (name+year).toUpperCase());
		queries.ADD_STUDENT.setInt(4, age);
		queries.ADD_STUDENT.setString(5, course);
		queries.ADD_STUDENT.setInt(6, year);
		queries.ADD_STUDENT.executeUpdate();
	}
	
	public StudentModel studentLogin(String id,String password) throws SQLException {
		queries.STUDENT_LOGIN.setString(1, id);
		queries.STUDENT_LOGIN.setString(2, 	password);
		
		ResultSet rs=queries.STUDENT_LOGIN.executeQuery();
		
		
		if(rs.next()) {
			StudentModel st= new StudentModel();
			st.id= rs.getString("ST_ID");
			st.name= rs.getString("ST_NAME");
			st.course= rs.getString("ST_COURSE");
			st.year=rs.getInt("ST_YEAR");
			st.age=rs.getInt("ST_AGE");
			return st;
		}
		return null;
	}
	public List<String[]> getAttendance(String studentId) throws SQLException {
		queries.STUDENT_DETAILS.setString(1, studentId);
		ResultSet rs=queries.STUDENT_DETAILS.executeQuery();
		
		List<String[]> list = new ArrayList<String[]>();
		while(rs.next()) {
			String[] objects = new String[] {rs.getString("SUBJECT_ID"), rs.getString("ATTENDANCE_PERCENTAGE")};
			System.out.println(objects[0]);
			list.add(objects);
		}
		return list;
}
}
