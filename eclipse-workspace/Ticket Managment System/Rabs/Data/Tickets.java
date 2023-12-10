package Data;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Tickets {

	private JFrame frame;
	private JTable table3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tickets window = new Tickets();
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
	public Tickets() {
		initialize();
		ShowTable3();
	}
public void ShowTable3() {
		
        try {
            Connection connection = Dao.connect();
          
          PreparedStatement pst;
ResultSet rs;



            
                
                try {
                	
                	
                	pst=connection.prepareStatement("select * from RSAJJ");
                	rs= pst.executeQuery();
                	table3.setModel(DbUtils.resultSetToTableModel(rs));
                	
                }catch(SQLException E){
                	
                	E.printStackTrace();
                }
                
                
                
            // Close the connection
            connection.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 836, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table3 = new JTable();
		scrollPane.setViewportView(table3);
	}

}
