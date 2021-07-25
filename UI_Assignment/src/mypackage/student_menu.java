package mypackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class student_menu extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student_menu frame = new student_menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public student_menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(12, 13, 408, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 102, 142, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Roll No.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(12, 73, 142, 16);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(197, 102, 114, 16);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name"
			}
		));
		
		String roll=student_login.getroll();
		
		scrollPane.setColumnHeaderView(table);
		
		JButton btnNewButton = new JButton("Borrow Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Borrow_book bb = new Borrow_book();
				bb.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(156, 191, 114, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Return Book");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				return_books rb = new return_books();
				rb.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(282, 191, 114, 45);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainframe mf = new mainframe();
				mf.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(156, 261, 114, 45);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("Book");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(12, 131, 142, 16);
		contentPane.add(lblNewLabel_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(197, 131, 114, 16);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Book"
			}
		));
		scrollPane_1.setColumnHeaderView(table_1);
		
		JButton btnNewButton_3 = new JButton("View Books");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view_books_students vbs = new view_books_students();
				vbs.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(29, 191, 114, 45);
		contentPane.add(btnNewButton_3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(197, 74, 114, 16);
		contentPane.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Roll No"
			}
		));
		scrollPane_2.setColumnHeaderView(table_2);
		
		String url="jdbc:mysql://localhost:3306/librarydatabase";
		String user="root";
		String pwd="8221";
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		DefaultTableModel model2 = (DefaultTableModel)table_1.getModel();
		DefaultTableModel model3 = (DefaultTableModel)table_2.getModel();
		try
		{
			
			
			Connection cn=DriverManager.getConnection(url,user,pwd);
			String str="select * from users where roll="+roll;
			
			Statement stmt = cn.createStatement();
			ResultSet rs = stmt.executeQuery(str);
			
			while(rs.next())
			{
				
				String Name=rs.getString("name");
				String Book=rs.getString("books");
				String Rollnumber = rs.getString("roll");
				
				model2.addRow(new Object[] {Book});				
				model.addRow(new Object[] {Name});
				model3.addRow(new Object[] {Rollnumber});
			}

		System.out.println("connection established");
		  
		 
		 
		 

		}
		catch(SQLException ex)
		{
			 	 	 	 	 
			 	 	 	 	 ex.printStackTrace();
		}
	}
}
