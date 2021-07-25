package mypackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class remove_books extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					remove_books frame = new remove_books();
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
	public remove_books() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Remove Books");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 13, 408, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 97, 139, 25);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(163, 99, 257, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("- Remove Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url="jdbc:mysql://localhost:3306/librarydatabase";
				String user="root";
				String pwd="8221";
				String bookid=textField.getText();
				
				String str="delete from library where bookid="+bookid;
				
				try {
					Connection cn=DriverManager.getConnection(url,user,pwd);

					System.out.println("connection established");
					 Statement stmt = cn.createStatement();
					 
					 stmt.executeUpdate(str);
					 cn.close();
					 JOptionPane.showMessageDialog(null, "Book Removed Successful!");	
					 setVisible(false);
					 admin_view_page avp=new admin_view_page();
					 avp.setVisible(true);
					
				}
				catch(SQLException ex)
				{
					 	 	 	 	 
					 	 	 	 	 ex.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(96, 174, 120, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_view_page avp = new admin_view_page();
				avp.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(228, 174, 97, 50);
		contentPane.add(btnNewButton_1);
	}

}
