package mypackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
public class Admin extends JFrame {
private JPanel contentPane;
/**
 * Launch the application.
 */
public static void main(String[] args) {
	 	 EventQueue.invokeLater(new Runnable() {
	 	 	 public void run() {
	 	 	 	 try {
	 	 	 	 	 Admin frame = new Admin();
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
String users,bal,books,stockname,price,qty;
void viewUsers(Connection cn)
{
System.out.println("DISPLAYING ALL USERS\n");
String dsp="SELECT * FROM users";
Statement stmt=null;
try
{	 

	 	 stmt=cn.createStatement();
	 	 ResultSet rs=stmt.executeQuery(dsp);
	 	 users="<html>";
	 	 books="<html>";
	 	 //bal="<html>";
	 	 while(rs.next())
	 	 {
	 	 	 int userid=rs.getInt("userid");
	 	 	 String name=rs.getString("name");
//	 	 	 int baln=rs.getInt("bal");
	 	 	 users+=name;
	 	 	 users+="<br>";
	 	 	 books+=books;
	 	 	 books+="<br>";
	 	 	 
//	 	 	 bal+=baln;
//	 	 	 bal+="<br>";
	 	 }
	 	 users+="</html>";
	 	 books+="</html>";
//	 	 bal+="</html>";
}
catch(SQLException e)
{
	 	 e.printStackTrace();
	 	 System.out.println("Error occured");
}
finally
 {
	 	 if (stmt != null)
	 	 {
	 	 	 try
	 	 	 {
	 	 	 	 stmt.close();
 }
 catch (SQLException ex)
 {
 ex.printStackTrace();
 }
	 	 }
 }
}
void viewBooks(Connection cn)
{
System.out.println("DISPLAYING ALL BOOKS\n");
String dsp="SELECT * FROM library";
Statement stmt=null;
try
{	 

	 	 stmt=cn.createStatement();
	 	 ResultSet rs=stmt.executeQuery(dsp);
	 	 stockname="<html>";
	 	 price="<html>";
	 	 qty="<html>";
	 	 while(rs.next())
	 	 {
	 	 	 int stockid=rs.getInt("stockid");
	 	 	 String stockname1=rs.getString("stockname");
	 	 	 int price1=rs.getInt("price");
	 	 	 int qty1=rs.getInt("qty");
	 	 	 stockname+=stockname1;
	 	 	 stockname+="<br>";
	 	 	 price+=price1;
	 	 	 price+="<br>";
	 	 	 qty+="<br>";
	 	 	 qty+=qty1;
	 	 }
	 	 stockname+="</html>";
	 	 price+="</html>";
	 	 qty+="</html>";
}
catch(SQLException e)
{
	 	 e.printStackTrace();
	 	 System.out.println("Error occured");
}
finally
 {
	 	 if (stmt != null)
	 	 {
	 	 	 try
	 	 	 {
	 	 	 	 stmt.close();
 }
 catch (SQLException ex)
 {
 ex.printStackTrace();
 }
	 	 }
 }
}
public Admin() {
		

	 	 Connection cn=null;
	 	 try
	 	 {
	 	 	 String url="jdbc:mysql://localhost:3306/librarydatabase";
	 	 	 String user="root";
	 	 	 String pwd="8221";
	 	 	 cn=DriverManager.getConnection(url,user,pwd);
	 	 	 if(cn!=null)
	 	 	 {
	 	 	 	 System.out.println("CONNECTION ESTABLISHED");
System.out.println("WELCOME TO ADMIN PAGE");
	 	 	 }
	 	 	 viewUsers(cn);
	 	 	 viewBooks(cn);
	 	 }
	 	 catch(SQLException ex)
	 	 {
	 	 	 System.out.println("Error Ocurred");
	 	 	 ex.printStackTrace();
	 	 }
	 	 finally
	 	 {
 if (cn != null)
 {
 try
 {
 cn.close();
 }
 catch (SQLException ex)
 {
 ex.printStackTrace();
 }
 }
	 	 }
		

	 	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	 setBounds(100, 100, 700, 500);
	 	 contentPane = new JPanel();
	 	 contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	 	 setContentPane(contentPane);
	 	 contentPane.setLayout(null);
		

	 	 JLabel lblNewLabel = new JLabel("Hello Admin !");
	 	 lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
	 	 lblNewLabel.setBounds(542, 6, 152, 47);
	 	 contentPane.add(lblNewLabel);
		

	 	 JButton btnNewButton = new JButton("Add Book +");
	 	 btnNewButton.addActionListener(new ActionListener() {
	 	 	 public void actionPerformed(ActionEvent e) {
	 	 	 	 setVisible(false);
//new AddStock().setVisible(true);
	 	 	 }
	 	 });
	 	 btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
	 	 btnNewButton.setBounds(259, 405, 202, 47);
	 	 contentPane.add(btnNewButton);
		

	 	 JLabel lblNewLabel_1 = new JLabel("Users");
	 	 lblNewLabel_1.setFont(new Font("Kefa", Font.BOLD, 18));
	 	 lblNewLabel_1.setBounds(107, 75, 97, 37);
	 	 contentPane.add(lblNewLabel_1);
		

	 	 JLabel lblNewLabel_2 = new JLabel("Names");
	 	 lblNewLabel_2.setBounds(35, 138, 61, 16);
	 	 contentPane.add(lblNewLabel_2);
		

	 	 JLabel lblNewLabel_3 = new JLabel("Books");
	 	 lblNewLabel_3.setBounds(191, 138, 61, 16);
	 	 contentPane.add(lblNewLabel_3);
		
	 	 

//	 	 JLabel lblNewLabel_4 = new JLabel("Stocks");
//	 	 lblNewLabel_4.setFont(new Font("Kefa", Font.BOLD, 18));
//	 	 lblNewLabel_4.setBounds(486, 75, 87, 37);
//	 	 contentPane.add(lblNewLabel_4);
//		
//
//	 	 JLabel lblNewLabel_5 = new JLabel("Stock Name");
//	 	 lblNewLabel_5.setBounds(400, 138, 80, 16);
//	 	 contentPane.add(lblNewLabel_5);
//		
//
//	 	 JLabel lblNewLabel_6 = new JLabel("Price");
//	 	 lblNewLabel_6.setBounds(524, 138, 61, 16);
//	 	 contentPane.add(lblNewLabel_6);
//		
//
//	 	 JLabel lblNewLabel_7 = new JLabel("Quantity");
//	 	 lblNewLabel_7.setBounds(618, 138, 61, 16);
//	 	 contentPane.add(lblNewLabel_7);
//		
//
//	 	 JLabel lblNewLabel_8 = new JLabel(users);
//	 	 lblNewLabel_8.setBounds(20, 157, 118, 213);
//	 	 contentPane.add(lblNewLabel_8);
//		
//
//	 	 JLabel lblNewLabel_9 = new JLabel(bal);
//	 	 lblNewLabel_9.setBounds(171, 157, 97, 213);
//	 	 contentPane.add(lblNewLabel_9);
//		
//
//	 	 JLabel lblNewLabel_10 = new JLabel(stockname);
//	 	 lblNewLabel_10.setBounds(381, 157, 118, 213);
//	 	 contentPane.add(lblNewLabel_10);
//		
//
//	 	 JLabel lblNewLabel_11 = new JLabel(price);
//	 	 lblNewLabel_11.setBounds(511, 157, 80, 213);
//	 	 contentPane.add(lblNewLabel_11);
//		
//
//	 	 JLabel lblNewLabel_12 = new JLabel(qty);
//	 	 lblNewLabel_12.setBounds(618, 157, 76, 213);
//	 	 contentPane.add(lblNewLabel_12);
}
}
