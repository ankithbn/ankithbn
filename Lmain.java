package res;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Font;

public class Lmain extends JFrame {
    public static String x,y;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lmain frame = new Lmain(y);
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
	public Lmain(String d) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnADMIN = new JButton("ADMIN (RESEARCHER)");
		btnADMIN.setBounds(5, 5, 186, 78);
		btnADMIN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				data1 admindata=new data1(d);
				admindata.setVisible(true);
					
				
				
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnADMIN);
		
		JButton btnSTUDENT = new JButton("SUPERIOR");
		btnSTUDENT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(d.equals("teach")||d.equals("123456")||d.equals("pass"))
				{
				
				superior su=new superior();
				su.setVisible(true);
				}
				else
				{   JOptionPane.showMessageDialog(null, "NOT AUTHORISED");                                        }
			}
		});
		btnSTUDENT.setBounds(201, 5, 127, 78);
		contentPane.add(btnSTUDENT);
		
		JButton btnUser = new JButton("USER");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c)
			{try {
				String url="jdbc:mysql://localhost:3306/ank";
				String userName="root";
				String passWord="root";
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(url,userName,passWord);
				Statement st=con.createStatement();
				String sql="SELECT * from User where Pass='"+d+"'and APPROVAL='"+'y'+"'";
				ResultSet rs= st.executeQuery(sql);
				
				if(rs.next())
				{    dispose();
					dataprint data=new dataprint(d);
					data.setVisible(true);
				}
				else
				{ 	JOptionPane.showMessageDialog(null, "NOT AUTHORISED");	
				dispose();
				}
			} 
			catch(Exception e) {System.out.print(e);}
			}
		});
		btnUser.setBounds(344, 5, 80, 78);
		contentPane.add(btnUser);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(5, 131, 140, 35);
		contentPane.add(lblNewLabel);
		
		JButton btnlogout = new JButton("LOGOUT");
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnlogout.setBounds(335, 212, 89, 23);
		contentPane.add(btnlogout);
	}
}
