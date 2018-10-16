import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.Action;
import javax.swing.JPasswordField;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final Action action = new SwingAction();
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		System.out.println("Register Constructor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblUsername = new JLabel("Username : ");
		lblUsername.setBounds(229, 223, 112, 40);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(229, 264, 112, 22);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password : ");
		lblConfirmPassword.setBounds(189, 296, 112, 22);
		contentPane.add(lblConfirmPassword);
		
		textField = new JTextField();
		textField.setBounds(293, 234, 250, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setAction(action);
		btnRegister.setBounds(364, 327, 85, 21);
		contentPane.add(btnRegister);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(293, 266, 250, 19);
		passwordField.setEchoChar('*');
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(293, 298, 250, 19);
		passwordField_1.setEchoChar('*');
		contentPane.add(passwordField_1);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Register");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			String username = textField.getText();
			String password = new String(passwordField.getPassword());
			String conf_password = new String(passwordField_1.getPassword());
			try
			{
				if (password.equals(conf_password))
				{
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", ""); //Creates a Connection with MYSQL Database
					Statement st = con.createStatement();
					st.execute("USE test");
					st.execute("INSERT INTO people (username,password) VALUE ('"+username+"','"+password+"')");
					System.out.println("Account Created");
					dispose();
					PlannerMain plan = new PlannerMain(username);
				}
				else 
					System.out.println("Passwords Don't match");
			}
			catch(Exception exc)
			{
				System.out.println(exc);
			}
		}
	}
}
