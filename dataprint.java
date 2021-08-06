package res;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;

public class dataprint extends JFrame {
public static String name;
	private JPanel contentPane;
 public String a,b,c;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dataprint frame = new dataprint(name);
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
	public dataprint(String p) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(5, 5, 80, 48);
		contentPane.add(lblNewLabel);
		
		JTextArea USERNAME = new JTextArea();
		USERNAME.setEditable(false);
		USERNAME.setText("no access");
		USERNAME.setBounds(140, 11, 233, 31);
		contentPane.add(USERNAME);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(5, 79, 104, 41);
		contentPane.add(lblNewLabel_1);
		
		JTextArea id = new JTextArea();
		id.setEditable(false);
		id.setText("na");
		id.setBounds(140, 79, 233, 32);
		contentPane.add(id);
		
		JLabel lblNewLabel_2 = new JLabel("PROJECTS");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 165, 75, 48);
		contentPane.add(lblNewLabel_2);
		
		JTextArea rdata = new JTextArea();
		rdata.setText("not approved");
		rdata.setBounds(140, 165, 233, 36);
		contentPane.add(rdata); 
		
		JButton btnback = new JButton("back<<");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Lmain log=new Lmain(p);
				log.setVisible(true);	
				
			}
		});
		btnback.setBounds(298, 227, 89, 23);
		contentPane.add(btnback);
		
		JButton btnNEWFILE = new JButton("Add new files");
		btnNEWFILE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				filechooser abc=new filechooser();
				abc.setVisible(true);
		
				
					
				
				
			}
		});
		btnNEWFILE.setBounds(90, 227, 119, 23);
		contentPane.add(btnNEWFILE);
		
		Button update = new Button("UPDATE");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			
			
			
			{try {
				
				String url="jdbc:mysql://localhost:3306/ank";
				String userName="root";
				String passWord="root";
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(url,userName,passWord);
				Statement st=con.createStatement();
				String sql="UPDATE  user SET RDATA='"+rdata.getText()+"'where Pass='"+p+"'AND APPROVAL='"+"Y"+"'";
				int rs1= st.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "project data updated");		
				dispose();
			}
			catch(Exception f) {System.out.print(f);}
			}
		});
		update.setBounds(222, 228, 70, 22);
		contentPane.add(update);
		
		JLabel lblNewLabel_3 = new JLabel("KINDLY ENTER THE PROJECT LABEL AND CLICK ON UPDATE TO SAVE CHANGES");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 8));
		lblNewLabel_3.setBounds(114, 125, 314, 29);
		contentPane.add(lblNewLabel_3);
		try {
			
		String url="jdbc:mysql://localhost:3306/ank";
		String userName="root";
		String passWord="root";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,userName,passWord);
		Statement st=con.createStatement();
		String sql="SELECT * from User where Pass='"+p+"'AND APPROVAL='"+"Y"+"'";
		ResultSet rs= st.executeQuery(sql);
		while(rs.next())
			{a=rs.getString("uname");
			 b=rs.getString("ID");
			 c=rs.getString("RDATA");
			USERNAME.setText(a);
	         id.setText(b);
	         rdata.setText(c);
			 	
			}
			
		dispose();
		
	}
	catch(Exception e) {System.out.print(e);}
	
}	
}