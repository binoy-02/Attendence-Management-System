package attendance;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import models.AdminModel;
import models.StudentModel;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AdminLogin<Addteacher> {

	public JFrame frame;
	private JTextField AdminIdTxtField;
	private JTextField AdminPswdTxtField;
	private DatabaseConnect db;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
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
	public AdminLogin() throws Exception {
		db = new DatabaseConnect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 836, 676);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Admin Login");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel_2.setBounds(232, 129, 357, 94);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblAdminId = new JLabel("Admin ID");
		lblAdminId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAdminId.setBounds(277, 253, 75, 40);
		frame.getContentPane().add(lblAdminId);
		
		JLabel lblAdminpassword = new JLabel("AdminPassword");
		lblAdminpassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAdminpassword.setBounds(249, 291, 124, 40);
		frame.getContentPane().add(lblAdminpassword);
		
		AdminIdTxtField = new JTextField();
		AdminIdTxtField.setColumns(10);
		AdminIdTxtField.setBounds(408, 263, 96, 20);
		frame.getContentPane().add(AdminIdTxtField);
		
		AdminPswdTxtField = new JTextField();
		AdminPswdTxtField.setColumns(10);
		AdminPswdTxtField.setBounds(408, 304, 96, 20);
		frame.getContentPane().add(AdminPswdTxtField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String adid =AdminIdTxtField.getText().trim();
				String password = AdminPswdTxtField.getText().trim();
				System.out.println("clicked");
				try {
					AdminModel admin = db.adminlogin(adid,password);
					System.out.println(admin);
					if(admin!=null) {
						AddTeacher st=new AddTeacher();
						st.frame.setVisible(true);
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
		btnNewButton.setBounds(347, 369, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
