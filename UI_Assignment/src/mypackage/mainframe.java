package mypackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mainframe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainframe frame = new mainframe();
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
	public mainframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnNewButton = new JButton("Login As a Student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				student_login fsl = new student_login();
				fsl.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(132, 117, 167, 53);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login As an Admin");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_login al = new admin_login();
				al.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(132, 274, 167, 53);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sign Up as a Student");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student_registration sr = new student_registration();
				sr.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(132, 197, 167, 53);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Welcome To Library Management System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBounds(12, 31, 408, 53);
		getContentPane().add(lblNewLabel);
		
	}

}
