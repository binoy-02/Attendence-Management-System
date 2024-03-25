package attendance;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;

public class StudentAttendenceView {

	private JFrame frame;
	private JTextField studentIDTxtField;
	private JTextField studentNameTxtField;
	private JTextField studentAgeTxtField;
	private JTextField studentCourseTxtField;
	private JTextField studentYearTxtField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentAttendenceView window = new StudentAttendenceView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentAttendenceView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 914, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStudentName.setBounds(169, 160, 126, 23);
		frame.getContentPane().add(lblStudentName);
		
		JLabel lblStudentAge = new JLabel("Student Age");
		lblStudentAge.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStudentAge.setBounds(169, 190, 126, 23);
		frame.getContentPane().add(lblStudentAge);
		
		JLabel lblStudentCourse = new JLabel("Student Course");
		lblStudentCourse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStudentCourse.setBounds(169, 224, 126, 23);
		frame.getContentPane().add(lblStudentCourse);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYear.setBounds(169, 258, 126, 23);
		frame.getContentPane().add(lblYear);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStudentId.setBounds(169, 133, 126, 23);
		frame.getContentPane().add(lblStudentId);
		
		studentIDTxtField = new JTextField();
		studentIDTxtField.setBounds(377, 137, 96, 20);
		frame.getContentPane().add(studentIDTxtField);
		studentIDTxtField.setColumns(10);
		
		studentNameTxtField = new JTextField();
		studentNameTxtField.setColumns(10);
		studentNameTxtField.setBounds(377, 164, 96, 20);
		frame.getContentPane().add(studentNameTxtField);
		
		studentAgeTxtField = new JTextField();
		studentAgeTxtField.setColumns(10);
		studentAgeTxtField.setBounds(377, 194, 96, 20);
		frame.getContentPane().add(studentAgeTxtField);
		
		studentCourseTxtField = new JTextField();
		studentCourseTxtField.setColumns(10);
		studentCourseTxtField.setBounds(377, 228, 96, 20);
		frame.getContentPane().add(studentCourseTxtField);
		
		studentYearTxtField = new JTextField();
		studentYearTxtField.setColumns(10);
		studentYearTxtField.setBounds(377, 262, 96, 20);
		frame.getContentPane().add(studentYearTxtField);
		
		JButton btnStudentAdd = new JButton("Check Attendence");
		btnStudentAdd.setBounds(279, 302, 137, 23);
		frame.getContentPane().add(btnStudentAdd);
		
		JLabel lblAttendencePercentage = new JLabel("Attendence Percentage");
		lblAttendencePercentage.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttendencePercentage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAttendencePercentage.setBounds(98, 350, 213, 42);
		frame.getContentPane().add(lblAttendencePercentage);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(377, 363, 82, 23);
		frame.getContentPane().add(lblNewLabel);
	}
}
