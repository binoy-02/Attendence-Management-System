package attendance;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import models.TeacherModel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeacherNavigation extends JFrame{

	private TeacherModel teacher;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public TeacherNavigation(TeacherModel teacher) {
		this.teacher = teacher;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Option");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(92, 47, 228, 59);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Mark Attendance");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AttendanceView attendanceView = new AttendanceView(teacher);
					attendanceView.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(77, 120, 115, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Student");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentDetails studentDetails;
				try {
					studentDetails = new StudentDetails();
					studentDetails.setVisible(true);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(245, 120, 115, 23);
		getContentPane().add(btnNewButton_1);
	}

}
