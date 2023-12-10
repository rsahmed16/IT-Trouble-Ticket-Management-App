package Data;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;
import java.awt.Color;

public class Dao{
 private String TNUM;
	private JFrame frame;
	private JTextField txt_uname;
	private JTextField txt_status;
	private JTable table;
	private JTextField txt_tsearch;
	private JTextField uname;
	private JTextField ustat;
	private JTextField ustart;
	private JTextField uend;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dao window = new Dao();
					
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
	
	

	
	
	
	public Dao() {
		initialize();
		//Table1();
		//Table2();
		ShowTable();
		
	}
	
	public void ShowTable() {
		
        try {
            Connection connection = connect();
          
          PreparedStatement pst;
ResultSet rs;



            
                
                try {
                	
                	
                	pst=connection.prepareStatement("select * from RSAJJ");
                	rs= pst.executeQuery();
                	table.setModel(DbUtils.resultSetToTableModel(rs));
                	
                }catch(SQLException E){
                	
                	E.printStackTrace();
                }
                
                
                
            // Close the connection
            connection.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    

		
	}
	
	

	    // Code database URL
	    static final String DB_URL = "jdbc:mysql://www.papademas.net:3307/tickets?autoReconnect=true&useSSL=false";
	    // Database credentials
	    static final String USER = "fp411", PASS = "411";
	    private JTextField txt_des;
	    private JTextField udes;
	    
	    
	    public static Connection connect() throws SQLException {
	        return DriverManager.getConnection(DB_URL, USER, PASS);
	    }
	   
	    
	    
	    public void Table1() {
	        try {
	            Connection connection = connect();
	            Statement statement = connection.createStatement();

	            // Execute create query
	            String sql= "CREATE TABLE RSAJJ("
	                    + "tid INTEGER not NULL AUTO_INCREMENT, "
	                    + "User_Name VARCHAR(20) NOT NULL, "
	                    
	                    + "Start_Date VARCHAR(20) NOT NULL, " 
	                    + "End_Date VARCHAR(20) NOT NULL, "
	                    + "Status VARCHAR(20) NOT NULL, "
	                    + "Ticket_Description VARCHAR(30) NOT NULL, "
	                    + "PRIMARY KEY (tid) "
	                    + ")";

	            statement.executeUpdate(sql);
	            System.out.println("Created table in the given database...");

	            // Close the connection
	            connection.close();
	        } catch (SQLException se) {
	            // Handle errors for JDBC
	            se.printStackTrace();
	        }
	    }

	    
	    
	    public void Table2() {
	        try {
	            Connection connection = connect();
	            Statement statement = connection.createStatement();

	            // Execute create query
	            String sql= "CREATE TABLE RSAJJ_USERS("
	                    + "uid INTEGER not NULL AUTO_INCREMENT, "
	                    + "User_Name VARCHAR(20) NOT NULL, "
	                    
	                    + "Passwords VARCHAR(20) NOT NULL, " 
	                    + "Admin INTEGER not NULL, "
	                    + "PRIMARY KEY (uid) "
	                    + ")";

	            statement.executeUpdate(sql);
	            System.out.println("Created table in the given database...");

	            // Close the connection
	            connection.close();
	        } catch (SQLException se) {
	            // Handle errors for JDBC
	            se.printStackTrace();
	        }
	    }


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 756, 725);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   Ticket Managment Application");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(156, 11, 415, 68);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 90, 324, 245);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setBounds(28, 34, 76, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ticket Status");
		lblNewLabel_2.setBounds(28, 84, 76, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Start Date");
		lblNewLabel_3.setBounds(28, 141, 76, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("End Date");
		lblNewLabel_4.setBounds(28, 188, 76, 14);
		panel.add(lblNewLabel_4);
		
		txt_uname = new JTextField();
		txt_uname.setBounds(132, 31, 162, 20);
		panel.add(txt_uname);
		txt_uname.setColumns(10);
		
		txt_status = new JTextField();
		txt_status.setBounds(132, 81, 162, 20);
		panel.add(txt_status);
		txt_status.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(132, 141, 162, 20);
		panel.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(132, 188, 162, 20);
		panel.add(dateChooser_1);
		
		JButton btn_reg = new JButton("Register");
		btn_reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user_name,tstatus,tdes;
			String sdate,edate;
			user_name=txt_uname.getText();
			tstatus=txt_status.getText();
			tdes=txt_des.getText();
			
			sdate=(new java.text.SimpleDateFormat("MM/dd/yy")).format(dateChooser.getDate());
			edate=(new java.text.SimpleDateFormat("MM/dd/yy")).format(dateChooser_1.getDate());
			
			
	        try {
	            Connection connection = connect();
	            Statement statement = connection.createStatement();
	            String sql;
	


	            // Include all object data to the database table
	            
	                sql = "INSERT INTO RSAJJ(User_Name , Start_Date,End_Date,Status,Ticket_Description)VALUES ('"+user_name +"','"+ sdate +"','" + edate +"','"+ tstatus +"','"+ tdes+"')";

	                statement.executeUpdate(sql);
	                txt_uname.setText("");
	                txt_status.setText("");
	                txt_des.setText("");
	                ShowTable();
	                
	                
	            // Close the connection
	            connection.close();
	        } catch (SQLException se) {
	            se.printStackTrace();
	        }
	    

			
			}}
		);
		btn_reg.setBounds(130, 222, 89, 23);
		panel.add(btn_reg);
		
		txt_des = new JTextField();
		txt_des.setBounds(132, 112, 162, 18);
		panel.add(txt_des);
		txt_des.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Description");
		lblNewLabel_5.setBounds(25, 114, 79, 14);
		panel.add(lblNewLabel_5);
		
		JScrollPane table_1 = new JScrollPane();
		table_1.setBounds(334, 90, 396, 245);
		frame.getContentPane().add(table_1);
		
		table = new JTable();
		table_1.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(25, 346, 299, 66);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ticket No.");
		lblNewLabel_2_1.setBounds(10, 25, 76, 14);
		panel_1.add(lblNewLabel_2_1);
		
		txt_tsearch = new JTextField();
		txt_tsearch.setForeground(new Color(0, 0, 0));
		txt_tsearch.setColumns(10);
		txt_tsearch.setBounds(114, 22, 162, 20);
		panel_1.add(txt_tsearch);
		
		JButton btn_search = new JButton("Search");
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				 try {
					 Connection con = connect();
					 PreparedStatement pst;
                     String id = txt_tsearch.getText();
                         pst = con.prepareStatement("select User_Name , Start_Date,End_Date,Status,Ticket_Description from RSAJJ where tid = ?");
                         pst.setString(1, id);
                         ResultSet rs = pst.executeQuery();
                     if(rs.next()==true)
                     {
                       TNUM=id;
                         String name = rs.getString(1);
                         String sdate = rs.getString(2);
                         String edate = rs.getString(3);
                         String sta = rs.getString(4);
                         String des = rs.getString(5);
                         uname.setText(name);
                         ustat.setText(sta);
                         ustart.setText(sdate);
                         uend.setText(edate);
                         udes.setText(des);
                         
                     }   
                     else
                     {
                    	 uname.setText("ty");
                         ustat.setText("");
                         ustart.setText("");
                         uend.setText("");
                         udes.setText("");
                          
                     }
                 } 
             
              catch (SQLException ex) {
                    
                 }
				
				
			}
		});
		btn_search.setBounds(188, 43, 89, 23);
		panel_1.add(btn_search);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(0, 412, 324, 245);
		frame.getContentPane().add(panel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("User Name");
		lblNewLabel_1_1.setBounds(28, 34, 76, 14);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Ticket Status");
		lblNewLabel_2_2.setBounds(28, 84, 76, 14);
		panel_2.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("Start Time");
		lblNewLabel_3_1.setBounds(28, 141, 76, 14);
		panel_2.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("End Time");
		lblNewLabel_4_1.setBounds(28, 188, 76, 14);
		panel_2.add(lblNewLabel_4_1);
		
		uname = new JTextField();
		uname.setColumns(10);
		uname.setBounds(132, 31, 162, 20);
		panel_2.add(uname);
		
		ustat = new JTextField();
		ustat.setColumns(10);
		ustat.setBounds(132, 81, 162, 20);
		panel_2.add(ustat);
		
		ustart = new JTextField();
		ustart.setColumns(10);
		ustart.setBounds(132, 138, 162, 20);
		panel_2.add(ustart);
		
		uend = new JTextField();
		uend.setColumns(10);
		uend.setBounds(132, 185, 162, 20);
		panel_2.add(uend);
		
		JButton btn_update = new JButton("Update");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
                String id = txt_tsearch.getText();
				
				
                String user_name,tstatus;
    			String sdate,edate,tdes;
    			
    			
    		
    			user_name=uname.getText();
    			tstatus=ustat.getText();
    		
    			
    			sdate=ustart.getText();
    			edate=uend.getText();
    			
    			tdes=udes.getText();
				 try {
					 Connection con = connect();
					 PreparedStatement pst;
                     pst = con.prepareStatement("update RSAJJ set User_Name= ?,Start_Date=?,End_Date=?,Status=?,Ticket_Description=? where tid =?");
                     pst.setString(1, user_name);
                     pst.setString(2, sdate);
                     pst.setString(3, edate);
                     pst.setString(4, tstatus);
                     pst.setString(5, tdes);
                     pst.setString(6, id);
                     pst.executeUpdate();
                     
                     ShowTable();
                    
                     uname.setText("");
                     ustat.setText("");
                     ustart.setText("");
                     uend.setText("");
                     txt_tsearch.setText("");
                     udes.setText("");
                 }
                 catch (SQLException e1) {
                     
                     e1.printStackTrace();
                 }
			}
		});
		btn_update.setBounds(87, 222, 89, 23);
		panel_2.add(btn_update);
		
		JButton btn_delete = new JButton("Delete");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String id = txt_tsearch.getText();
				
				try {Connection con = connect();
				 PreparedStatement pst;
	                   pst = con.prepareStatement("delete from RSAJJ where tid =?");
	           
	                   pst.setString(1, id);
	                   pst.executeUpdate();
	                   
	                   ShowTable();
	                    
	                     uname.setText("");
	                     ustat.setText("");
	                     ustart.setText("");
	                     uend.setText("");
	                     txt_tsearch.setText("");
	                     udes.setText("");
	               }
	               catch (SQLException e1) {
	                   
	                   e1.printStackTrace();
	               }
				
				
				
				
				
				
				
			}
		});
		btn_delete.setBounds(183, 222, 89, 23);
		panel_2.add(btn_delete);
		
		JLabel lblNewLabel_5_1 = new JLabel("Description");
		lblNewLabel_5_1.setBounds(28, 111, 79, 14);
		panel_2.add(lblNewLabel_5_1);
		
		udes = new JTextField();
		udes.setColumns(10);
		udes.setBounds(135, 109, 162, 18);
		panel_2.add(udes);
		
		
	}
}
