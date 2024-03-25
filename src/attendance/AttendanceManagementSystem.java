package attendance;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import models.TeacherModel;

import java.awt.Font;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AttendanceManagementSystem implements ActionListener{

	public JFrame frame;
	private JTextField teacherUsrNameTxtField;
	private JTextField teacherPasswordTxtField;
	private JLabel errorLabel;
	private DatabaseConnect db;
	/*
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttendanceManagementSystem window = new AttendanceManagementSystem();
					window.frame.setVisible(true);
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
	public AttendanceManagementSystem() throws Exception {
		this.db = new DatabaseConnect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1021, 534);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(349, 179, 96, 40);
		frame.getContentPane().add(lblNewLabel);
		
	 	teacherUsrNameTxtField = new JTextField();
		teacherUsrNameTxtField.setBounds(480, 192, 96, 20);
		frame.getContentPane().add(teacherUsrNameTxtField);
		teacherUsrNameTxtField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(349, 216, 90, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		teacherPasswordTxtField = new JTextField();
		teacherPasswordTxtField.setColumns(10);
		teacherPasswordTxtField.setBounds(480, 223, 96, 20);
		frame.getContentPane().add(teacherPasswordTxtField);
		
		JLabel lblNewLabel_2 = new JLabel("Teacher Login");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(313, 62, 357, 94);
		frame.getContentPane().add(lblNewLabel_2);
		
		errorLabel = new JLabel("");
		errorLabel.setBounds(349, 305, 269, 14);
		frame.getContentPane().add(errorLabel);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(414, 266, 96, 28);
		frame.getContentPane().add(btnNewButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			String username = this.teacherUsrNameTxtField.getText().trim();
			String password = this.teacherPasswordTxtField.getText().trim();
			try {
				TeacherModel teacher = db.login(username, password);
				if(teacher == null) {
					errorLabel.setText("invalid credentials");
				}else {
					errorLabel.setText("");
					TeacherNavigation teacherNavigation = new TeacherNavigation(teacher);
					teacherNavigation.setVisible(true);
				}
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		} catch (Exception e2) {
			
		}
		
	}
}
