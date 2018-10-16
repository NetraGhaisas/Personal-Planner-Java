import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPasswordField;

public class FrameMain extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMain frame = new FrameMain();
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
	/**
	 * 
	 */
	public FrameMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 10, 10));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setAction(action);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setBounds(352, 345, 107, 29);
		contentPane.add(btnLogin);
		
		textField = new JTextField();
		textField.setBounds(272, 263, 291, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setBounds(198, 258, 90, 29);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setBounds(198, 299, 90, 28);
		contentPane.add(lblPassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setAction(action_1);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegister.setBounds(352, 384, 107, 32);
		contentPane.add(btnRegister);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(272, 304, 291, 19);
		passwordField.setEchoChar('*');
		contentPane.add(passwordField);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Login");
			putValue(SHORT_DESCRIPTION, "Verifies Username and Password");
		}
		public void actionPerformed(ActionEvent e) {
			 try
			 {  
		        String username = textField.getText();
		        String password = new String(passwordField.getPassword());
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", ""); //Creates a Connection with MYSQL Database
				Statement st = con.createStatement();
				st.execute("USE test");
				ResultSet res = st.executeQuery("SELECT * FROM people");
				boolean flag = false;
				while(res.next())
				{
					//System.out.println(res.getString("username")+" "+res.getString("password")+" "+username+ " "+password);
					if(res.getString("username").equals(username) && res.getString("password").equals(password))
					{
						System.out.println("LOG IN successful");
						dispose();
						PlannerMain plan = new PlannerMain(username);
						flag = true;
						break;
					}
				}	
			 }
			 catch(Exception ex)
			 {
				 System.out.println(ex);
			 }  
		}  
		}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Register");
			putValue(SHORT_DESCRIPTION, "Register if the user doesn't have a account");
		}
		public void actionPerformed(ActionEvent e) {
			dispose();
			Register regis = new Register();
			regis.setVisible(true);
		}
	}
	}