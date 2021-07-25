package mypackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class view_books_students extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_books_students frame = new view_books_students();
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
	public view_books_students() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 459);
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
		scrollPane.setBounds(53, 158, 319, 175);
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
				student_menu sm = new student_menu();
				sm.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(134, 354, 157, 47);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Search Book");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(35, 56, 119, 19);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(166, 56, 254, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		String url="jdbc:mysql://localhost:3306/librarydatabase";
		String user="root";
		String pwd="8221";
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String book=textField.getText();
				String query1="select * from Library where book_name='"+book+"' and quantity>0";
				try 
				{
					Connection cn=DriverManager.getConnection(url,user,pwd);
					Statement stmt=cn.createStatement();
					ResultSet rs=stmt.executeQuery(query1);
					
					if(rs.next())
						JOptionPane.showMessageDialog(null, "Book Available!");
					else
						JOptionPane.showMessageDialog(null, "Book Unavailable!");
					 
				}
				catch (SQLException e )
				{
					e.printStackTrace();
					System.out.println("Error occured");
				}
			}
		});
		btnNewButton_1.setBounds(176, 91, 97, 40);
		contentPane.add(btnNewButton_1);
		
		
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				
				try
				{
					
					
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
