package attendance;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.StudentModel;

import java.awt.ScrollPane;
import java.util.List;

public class StudentView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private StudentModel student;
	private DatabaseConnect db;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public StudentView(StudentModel student) throws Exception {
		
		this.student=student;
		this.db = new DatabaseConnect();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		List<String[]> list = db.getAttendance(student.id);
		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Subject");
		dm.addColumn("Percentage");
		
		for(String[] string: list) {
			dm.addRow(string);
		}
		
		table = new JTable(dm);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 434, 261);
		contentPane.add(scrollPane);
		
	}
}
