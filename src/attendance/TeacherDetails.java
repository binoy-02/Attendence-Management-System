package attendance;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TeacherDetails {

	private JFrame frame;
	private JTextField TeacheIdTxtField;
	private JTextField TeacheNameTxtField;
	private JTextField TeachePswdTxtField;
	private JTextField TeachePhoneTxtField;
	private JTextField TeacherSubTxtField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherDetails window = new TeacherDetails();
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
	public TeacherDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 533);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterTeacherDetails = new JLabel("Enter Teacher Details");
		lblEnterTeacherDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterTeacherDetails.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblEnterTeacherDetails.setBounds(131, 35, 499, 75);
		frame.getContentPane().add(lblEnterTeacherDetails);
		
		JLabel lblTeacherName = new JLabel("Teacher Name");
		lblTeacherName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTeacherName.setBounds(165, 195, 126, 23);
		frame.getContentPane().add(lblTeacherName);
		
		JLabel lblStudentPassword = new JLabel("Teacher Password");
		lblStudentPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStudentPassword.setBounds(165, 229, 160, 23);
		frame.getContentPane().add(lblStudentPassword);
		
		JLabel lblTeacherPhoneNo = new JLabel("teacher phone no");
		lblTeacherPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTeacherPhoneNo.setBounds(165, 269, 160, 23);
		frame.getContentPane().add(lblTeacherPhoneNo);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSubject.setBounds(165, 310, 126, 23);
		frame.getContentPane().add(lblSubject);
		
		JLabel lblTeacherId = new JLabel("Teacher ID");
		lblTeacherId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTeacherId.setBounds(165, 163, 126, 23);
		frame.getContentPane().add(lblTeacherId);
		
		TeacheIdTxtField = new JTextField();
		TeacheIdTxtField.setColumns(10);
		TeacheIdTxtField.setBounds(398, 167, 96, 20);
		frame.getContentPane().add(TeacheIdTxtField);
		
		TeacheNameTxtField = new JTextField();
		TeacheNameTxtField.setColumns(10);
		TeacheNameTxtField.setBounds(398, 199, 96, 20);
		frame.getContentPane().add(TeacheNameTxtField);
		
		TeachePswdTxtField = new JTextField();
		TeachePswdTxtField.setColumns(10);
		TeachePswdTxtField.setBounds(398, 233, 96, 20);
		frame.getContentPane().add(TeachePswdTxtField);
		
		TeachePhoneTxtField = new JTextField();
		TeachePhoneTxtField.setColumns(10);
		TeachePhoneTxtField.setBounds(398, 273, 96, 20);
		frame.getContentPane().add(TeachePhoneTxtField);
		
		TeacherSubTxtField = new JTextField();
		TeacherSubTxtField.setColumns(10);
		TeacherSubTxtField.setBounds(398, 314, 96, 20);
		frame.getContentPane().add(TeacherSubTxtField);
		
		JButton btnTeacherAdd = new JButton("ADD");
		btnTeacherAdd.setBounds(306, 359, 89, 23);
		frame.getContentPane().add(btnTeacherAdd);
	}
}
