package mypackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class return_books extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					return_books frame = new return_books();
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
	public return_books() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Return a book");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 13, 408, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Name of book");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(29, 97, 146, 31);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(199, 102, 221, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Return Book");
		String roll=student_login.getroll();
		String url="jdbc:mysql://localhost:3306/librarydatabase";
		String user="root";
		String pwd="8221";

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String book=textField.getText();

				String query1="Update users set books=null where roll='"+roll+"'";
				String query2="Update library set quantity=quantity+'"+1+"'where book_name='"+book+"'";
				try 
				{
					Connection cn=DriverManager.getConnection(url,user,pwd);
					Statement st=cn.createStatement();
					st.executeUpdate(query1);
					st.executeUpdate(query2);
					JOptionPane.showMessageDialog(null, "Book Returned Successfully!");
					 setVisible(false);
					 student_menu sm = new student_menu();
					 sm.setVisible(true);
				}
				catch (SQLException e )
				{
					e.printStackTrace();
					System.out.println("Error occured");
				}
				
				
			}
		});
		btnNewButton.setBounds(78, 240, 117, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				student_menu sm = new student_menu();
				sm.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(224, 240, 97, 25);
		contentPane.add(btnNewButton_1);
	}

}
