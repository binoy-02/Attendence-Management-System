package attendance;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.StudentModel;
import models.TeacherModel;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class AttendanceView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<StudentModel> students;
	private DatabaseConnect db;
	private TeacherModel teacher;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 * @throws Exception 
	 */

	public AttendanceView(TeacherModel teacher) throws Exception {
		
		
		db=new DatabaseConnect();
		
		this.teacher=teacher;
		students=db.fetchAllStudent(teacher.subject);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 770, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		Map<JCheckBox, StudentModel> studentcheckboxmap = new HashMap<>();
		
		
		for(StudentModel student:students)
		{
			JCheckBox jcheckbox = new JCheckBox(student.name);
			contentPane.add(jcheckbox);
			studentcheckboxmap.put(jcheckbox, student);
		}
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		JButton btnNewButton = new JButton("SUBMIT");
		panel_2.add(btnNewButton);
		
		lblNewLabel = new JLabel("New label");
		panel_2.add(lblNewLabel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String>ids = new ArrayList<>();
				for(JCheckBox studentbox: studentcheckboxmap.keySet()) {
					StudentModel st=studentcheckboxmap.get(studentbox);
					try {
						db.markAttendance(st.id, teacher.subject, studentbox.isSelected());
						lblNewLabel.setText("Marked");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						lblNewLabel.setText("Something went wrong");
						e1.printStackTrace();
					}
				}
			}
		});
	}

}
