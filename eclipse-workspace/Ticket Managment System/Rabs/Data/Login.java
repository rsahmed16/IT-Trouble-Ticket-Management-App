package Data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JPasswordField tpassword;
	private JTextField tname;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 553, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(166, 45, 210, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("NAME");
		lblNewLabel_2.setBounds(26, 156, 71, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PASSWORD");
		lblNewLabel_3.setBounds(26, 230, 71, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		tpassword = new JPasswordField();
		tpassword.setBounds(143, 227, 155, 20);
		frame.getContentPane().add(tpassword);
		
		tname = new JTextField();
		tname.setBounds(146, 153, 152, 20);
		frame.getContentPane().add(tname);
		tname.setColumns(10);
		
		btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Name=tname.getText();
			
				String Password=tpassword.getText().toString();
				 try {
			            Connection connection = Dao.connect();
			            Statement stmt = connection.createStatement();
String sql="Select * from rsajj_users where User_Name='"+Name+"' and Passwords ='"+Password+"'";
			            // Execute create query
			            ResultSet rs=stmt.executeQuery(sql);
			           if(rs.next())
			           {
			        	   String sql2="Select * from rsajj_users where User_Name='"+Name+"' and Passwords ='"+Password+"'and Admin ='1'";
				            // Execute create query
				            ResultSet rst=stmt.executeQuery(sql2);
				            if(rst.next())
					           {
				            	JOptionPane.showMessageDialog(null, "Welcome Admin");
				            	
				            	Dao.main(null);
					           }else {
					        	   JOptionPane.showMessageDialog(null, "Welcome User");
					        	   Tickets.main(null);
					           }
			        	   
			           }else {
			        	   JOptionPane.showMessageDialog(null, "Failed");
			           }
			            
			            // Close the connection
			            connection.close();
			        } catch (SQLException se) {
			            // Handle errors for JDBC
			            se.printStackTrace();
			        }
				
				
			}
		});
		btnNewButton.setBounds(153, 308, 210, 64);
		frame.getContentPane().add(btnNewButton);
	}
}
