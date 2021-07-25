package mypackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.*;

public class view_books extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_books frame = new view_books();
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
	public view_books() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Books");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(12, 13, 408, 30);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 69, 319, 175);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},	
			new String[] {
				"Book ID", "Book Name", "Quantity"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_view_page avp = new admin_view_page();
				avp.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(137, 268, 157, 47);
		contentPane.add(btnNewButton);
		
		
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				
				try
				{
					String url="jdbc:mysql://localhost:3306/librarydatabase";
					String user="root";
					String pwd="8221";
					
					Connection cn=DriverManager.getConnection(url,user,pwd);
					String str="select * from library";
					
					Statement stmt = cn.createStatement();
					ResultSet rs = stmt.executeQuery(str);
					
					while(rs.next())
					{
						int bookid=rs.getInt("bookid");
						String bookname=rs.getString("book_name");
						int quantity = rs.getInt("quantity");
						
						model.addRow(new Object[] {bookid,bookname,quantity});
					}

				System.out.println("connection established");
				  
				 
				 
				 

				}
				catch(SQLException ex)
				{
					 	 	 	 	 
					 	 	 	 	 ex.printStackTrace();
				}
				
				
				
			
		
	}
}
