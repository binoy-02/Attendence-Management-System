package attendance;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class StudentDetails extends JFrame{

	private JTextField studentNameTxtField;
	private JTextField studentAgeTxtField;
	private JTextField studentCourseTxtField;
	private JTextField studentYearTxtField;
	private JLabel lblLabelAdded;
	public DatabaseConnect db;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDetails window = new StudentDetails();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public StudentDetails() throws Exception {
		db= new DatabaseConnect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setBounds(100, 100, 914, 507);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStudentName.setBounds(169, 160, 126, 23);
		getContentPane().add(lblStudentName);
		
		JLabel lblStudentAge = new JLabel("Student Age");
		lblStudentAge.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStudentAge.setBounds(169, 190, 126, 23);
		getContentPane().add(lblStudentAge);
		
		JLabel lblStudentCourse = new JLabel("Student Course");
		lblStudentCourse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStudentCourse.setBounds(169, 224, 126, 23);
		getContentPane().add(lblStudentCourse);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYear.setBounds(169, 258, 126, 23);
		getContentPane().add(lblYear);
		
		studentNameTxtField = new JTextField();
		studentNameTxtField.setColumns(10);
		studentNameTxtField.setBounds(377, 164, 96, 20);
		getContentPane().add(studentNameTxtField);
		
		studentAgeTxtField = new JTextField();
		studentAgeTxtField.setColumns(10);
		studentAgeTxtField.setBounds(377, 194, 96, 20);
		getContentPane().add(studentAgeTxtField);
		
		studentCourseTxtField = new JTextField();
		studentCourseTxtField.setColumns(10);
		studentCourseTxtField.setBounds(377, 228, 96, 20);
		getContentPane().add(studentCourseTxtField);
		
		studentYearTxtField = new JTextField();
		studentYearTxtField.setColumns(10);
		studentYearTxtField.setBounds(377, 262, 96, 20);
		getContentPane().add(studentYearTxtField);
		
		JButton btnStudentAdd = new JButton("ADD");
		btnStudentAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=studentNameTxtField.getText().trim();
				String course=studentCourseTxtField.getText().trim();
				int year=Integer.parseInt(studentYearTxtField.getText().trim());
				int age=Integer.parseInt(studentAgeTxtField.getText().trim());
				try {
					db.addStudents(name, course, year, age);
					lblLabelAdded.setText("Student added successfully..");
					studentNameTxtField.setText("");
					studentCourseTxtField.setText("");
					studentYearTxtField.setText("");
					studentAgeTxtField.setText("");

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					lblLabelAdded.setText("Something went wrong..");
				}
				
			}
		});
		btnStudentAdd.setBounds(282, 333, 89, 23);
		getContentPane().add(btnStudentAdd);
		
		lblLabelAdded = new JLabel("");
		lblLabelAdded.setBounds(392, 342, 221, 14);
		getContentPane().add(lblLabelAdded);
		
		JLabel lblNewLabel = new JLabel("Enter Student details");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(114, 44, 499, 75);
		getContentPane().add(lblNewLabel);
	}
}
