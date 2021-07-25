package mypackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class student_login extends JFrame {

	private JPanel contentPane;
	public JTextField textField;
	public JPasswordField passwordField;
	static String roll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student_login frame = new student_login();
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
	public student_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(12, 13, 408, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Roll No.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(158, 68, 116, 25);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(158, 106, 116, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(158, 176, 116, 25);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(158, 214, 116, 25);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String url="jdbc:mysql://localhost:3306/librarydatabase";
				String user="root";
				String pwd="8221";
				
				roll=textField.getText();
				String pass=passwordField.getText();
				
				
				
				String str="select * from Users where roll='"+roll+"' and pass='"+pass+"'";
				
				try {
					Connection cn=DriverManager.getConnection(url,user,pwd);

					System.out.println("connection established");
					 Statement stmt = cn.createStatement();
					 
					 ResultSet rs = stmt.executeQuery(str);
					
					 //System.out.println(rs.getString("pass"));
					 
					 if(rs.next())
					 {
						 
							 JOptionPane.showMessageDialog(null, "User Login Successful!");
							 setVisible(false);
							 student_menu sm = new student_menu();
							 sm.setVisible(true);
							 
//							 sm.rollno.setText(roll);
							 
							 dispose();
						 
						
					 }
					 else
					 {
						 JOptionPane.showMessageDialog(null, "User Login Unsuccessful!");
						 setVisible(false);
						 mainframe mf = new mainframe();
						 mf.setVisible(true);
					 }
						 
					 
					 
					 
					 cn.close();
					 
					
				}
				catch(SQLException ex)
				{
					 	 	 	 	 
					 	 	 	 	 ex.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(50, 291, 148, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainframe mf = new mainframe();
				mf.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(210, 291, 148, 45);
		contentPane.add(btnNewButton_1);
		
		
		
		
	}
	public static String getroll()
	{
		return roll;
	}

}
