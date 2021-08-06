package res;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.List;
import java.awt.Font;

public class superior extends JFrame {

	private JPanel contentPane;
	private JTextField txtSname;
	private JTable table;
	private JButton btnback3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					superior frame = new superior();
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
	public superior() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter advisor name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(15, 11, 245, 29);
		contentPane.add(lblNewLabel);
		
		txtSname = new JTextField();
		txtSname.setBounds(15, 34, 165, 29);
		contentPane.add(txtSname);
		txtSname.setColumns(10);
		
		JButton btnsubmit = new JButton("Submit");
		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					   String url="jdbc:mysql://localhost:3306/ank";
					   String userName="root";
					   String passWord="root";
					   Class.forName("com.mysql.jdbc.Driver");
					  Connection con=DriverManager.getConnection(url,userName,passWord);
					Statement st=con.createStatement();
					String sql="SELECT Uname,ID,RDATA,advisor,APPROVAL FROM user Where advisor='"+txtSname.getText()+"'";
					ResultSet rs= st.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
						
				}
				catch(Exception e) {System.out.print(e);}
							
		
				
			}
		});
		btnsubmit.setBounds(193, 37, 89, 23);
		contentPane.add(btnsubmit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 77, 295, 173);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnback3 = new JButton("back<<");
		btnback3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
				
				
				
			}
		});
		btnback3.setBounds(310, 77, 89, 23);
		contentPane.add(btnback3);
	}
}
