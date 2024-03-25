package attendance;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import models.StudentModel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class StudentLogin extends JFrame{

	private JTextField studentUsrNameTxtField;
	private JTextField studentPasswordTxtField;
	private DatabaseConnect db;

	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLogin window = new StudentLogin();
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
	public StudentLogin() throws Exception {
		db = new DatabaseConnect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 1021, 534);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(349, 179, 96, 40);
		getContentPane().add(lblNewLabel);
		
		studentUsrNameTxtField = new JTextField();
		studentUsrNameTxtField.setBounds(480, 192, 96, 20);
		getContentPane().add(studentUsrNameTxtField);
		studentUsrNameTxtField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(349, 216, 90, 28);
		getContentPane().add(lblNewLabel_1);
		
		studentPasswordTxtField = new JTextField();
		studentPasswordTxtField.setColumns(10);
		studentPasswordTxtField.setBounds(480, 223, 96, 20);
		getContentPane().add(studentPasswordTxtField);
		
		JLabel lblNewLabel_2 = new JLabel("Student Login");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(313, 62, 357, 94);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(351, 304, 269, 14);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentid =studentUsrNameTxtField.getText().trim();
				String password = studentPasswordTxtField.getText().trim();
				try {
					StudentModel student = db.studentLogin(studentid,password);
					if(student!=null) {
						StudentView st=new StudentView(student);
						st.setVisible(true);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(430, 288, 89, 23);
		getContentPane().add(btnNewButton);
	}
}
