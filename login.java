package res;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
public class login extends JFrame {
	public static String a;
	private JPanel contentPane;
	public JTextField user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 396, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("research artefact laboratory project");
		JLabel lblNewLabel = new JLabel("RESEARCH ARTEFACT ACCESS LOGIN");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(10, 11, 347, 42);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setBounds(20, 50, 122, 36);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblUsername);
		
		user = new JTextField();
		user.setBounds(10, 83, 251, 30);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(20, 125, 170, 30);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblPassword);
		
		JPasswordField pass = new JPasswordField();
		pass.setBounds(10, 164, 251, 30);
		contentPane.add(pass);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(10, 205, 89, 23);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae)
			{try {a=user.getText();
				String url="jdbc:mysql://localhost:3306/ank";
				String userName="root";
				String passWord="root";
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection(url,userName,passWord);
				Statement st=con.createStatement();
				String sql="SELECT * from User where Uname='"+user.getText()+"'and Pass='"+pass.getText().toString()+"'";
				ResultSet rs= st.executeQuery(sql);
				if(rs.next())
					{JOptionPane.showMessageDialog(null, "login successful");
					dispose();
					a=pass.getText();
					System.out.println(a);
					Lmain log=new Lmain(a);
					log.setVisible(true);
					dispose();
					}
					
				else
					JOptionPane.showMessageDialog(null, "login failed");
			}
			catch(Exception e) {System.out.print(e);}
			}
		});
		contentPane.add(btnLogin);
	}
}
