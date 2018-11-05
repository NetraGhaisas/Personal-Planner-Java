import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.border.BevelBorder;

public class Mainpage extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	String username;
	private final Action action_2 = new SwingAction_2();
	private JTextArea txtrTodo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainpage frame = new Mainpage("user");
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
	public Mainpage(String username) {
		setResizable(false);
		setBackground(Color.WHITE);
		this.username = username;
		setTitle("Planner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setBackground(Color.WHITE);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(SystemColor.menu);
		tabbedPane.addTab("Home\r\n", null, panel, null);
		tabbedPane.setForegroundAt(0, Color.BLACK);
		tabbedPane.setEnabledAt(0, true);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		panel.setLayout(null);
		
		JLabel lblHelloUser = new JLabel("Hello "+username);
		lblHelloUser.setFont(new Font("Calibri", Font.PLAIN, 40));
		lblHelloUser.setBounds(123, 98, 261, 63);
		panel.add(lblHelloUser);
		
		JButton btnNewButton = new JButton("Assistant");
		btnNewButton.setAction(action_1);
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		btnNewButton.setForeground(SystemColor.desktop);
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(400, 465, 85, 80);
		panel.add(btnNewButton);
		
		JPanel Notes = new JPanel();
		Notes.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Notes.setBackground(SystemColor.menu);
		tabbedPane.addTab("Notes", null, Notes, null);
		tabbedPane.setEnabledAt(1, true);
		tabbedPane.setBackgroundAt(1, Color.WHITE);
		Notes.setLayout(null);
		
		JButton button_1 = new JButton("Assistant");
		button_1.setBounds(426, 465, 77, 80);
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Calibri", Font.PLAIN, 11));
		button_1.setBackground(SystemColor.activeCaption);
		Notes.add(button_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBackground(SystemColor.menu);
		tabbedPane.addTab("To-do", null, panel_2, null);
		tabbedPane.setEnabledAt(2, true);
		panel_2.setLayout(null);
		
		JButton button = new JButton("Assistant");
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Calibri", Font.PLAIN, 11));
		button.setBackground(SystemColor.activeCaption);
		button.setBounds(400, 465, 85, 80);
		panel_2.add(button);
		
		txtrTodo = new JTextArea();
		txtrTodo.setBackground(Color.LIGHT_GRAY);
		txtrTodo.setText("Todo");
		txtrTodo.setBounds(115, 111, 223, 41);
		panel_2.add(txtrTodo);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setAction(action_2);
		btnAdd.setBounds(184, 162, 85, 21);
		panel_2.add(btnAdd);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(SystemColor.menu);
		tabbedPane.addTab("Reminders", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnAssistant = new JButton("Assistant");
		btnAssistant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAssistant.setAction(action);
		btnAssistant.setForeground(Color.BLACK);
		btnAssistant.setFont(new Font("Calibri", Font.PLAIN, 11));
		btnAssistant.setBackground(SystemColor.activeCaption);
		btnAssistant.setBounds(405, 465, 80, 80);
		panel_1.add(btnAssistant);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Assistant");
			putValue(SHORT_DESCRIPTION, "Dont ask silly questions :)");
		}
		public void actionPerformed(ActionEvent e) {
			AssTest a = new AssTest();
			a.speech(username);
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Add todo");
			putValue(SHORT_DESCRIPTION, "Add data to todo table");
		}
		public void actionPerformed(ActionEvent e) {
			Date dt = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentTime = sdf.format(dt);
			String todo = txtrTodo.getText();
			try {
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", ""); //Creates a Connection with MYSQL Database
				Statement st = con.createStatement();
				st.execute("USE test");
				st.execute("INSERT INTO todo (username,time,todo,status) VALUE ('"+username+"','"+currentTime+"','"+todo+"','"+0+"')");
				System.out.println(' '+username+','+currentTime+','+todo+','+0);
			}
			catch(Exception ec) {System.out.println(ec);}
		}
	}
}
