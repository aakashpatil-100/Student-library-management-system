package mypackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class view_users extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_users frame = new view_users();
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
	public view_users() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 86, 334, 189);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Roll No.", "Name", "Books"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Users");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(12, 13, 408, 30);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_view_page avp = new admin_view_page();
				avp.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(162, 319, 97, 55);
		contentPane.add(btnNewButton);
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		try
		{
			String url="jdbc:mysql://localhost:3306/librarydatabase";
			String user="root";
			String pwd="8221";
			
			Connection cn=DriverManager.getConnection(url,user,pwd);
			String str="select * from users";
			
			Statement stmt = cn.createStatement();
			ResultSet rs = stmt.executeQuery(str);
			
			while(rs.next())
			{
				int roll=rs.getInt("roll");
				String name=rs.getString("name");
				String books = rs.getString("books");
				
				model.addRow(new Object[] {roll,name,books});
			}

		System.out.println("connection established");
		  
		 
		 
		 

		}
		catch(SQLException ex)
		{
			 	 	 	 	 
			 	 	 	 	 ex.printStackTrace();
		}
		
		
	}

}
