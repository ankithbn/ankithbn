package res;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class data1 extends JFrame {
  public static String z;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					data1 frame = new data1(z);
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
	public data1(String a) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnload = new JButton("loader");
		btnload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(a.equals("pass"))
				{	
				    try {
					
					   String url="jdbc:mysql://localhost:3306/ank";
					   String userName="root";
					   String passWord="root";
					   Class.forName("com.mysql.jdbc.Driver");
					  Connection con=DriverManager.getConnection(url,userName,passWord);
					Statement st=con.createStatement();
					String sql="SELECT Uname,ID,RDATA,advisor,APPROVAL FROM user";
					ResultSet rs= st.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
						
					
				}
				catch(Exception e) {System.out.print(e);}
				}
				else
				{	JOptionPane.showMessageDialog(null, "You are not authorised to access this data");	
				}
				System.out.println();
			}
		});
		btnload.setBounds(321, 66, 103, 23);
		contentPane.add(btnload);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 303, 194);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnback2 = new JButton("back<<");
		btnback2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Lmain log=new Lmain(a);
				log.setVisible(true);	
				dispose();
			}
		});
		btnback2.setBounds(321, 121, 103, 23);
		contentPane.add(btnback2);
	}
}
