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
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JToolBar;
import javax.swing.JEditorPane;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.BoxLayout;

public class Mainpage extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	String username;
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private JPanel panel_6;
	private JPanel main_todo;
	private JTextArea txtrTodo;
	private JTable table;
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
		
		JButton btnNewButton = new JButton("Assistant");
		btnNewButton.setAction(action_1);
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		btnNewButton.setForeground(SystemColor.desktop);
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(400, 465, 85, 80);
		panel.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 11, 493, 126);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblHelloUser = new JLabel("Hello <dynamic>");
		lblHelloUser.setBounds(10, 11, 473, 104);
		panel_4.add(lblHelloUser);
		lblHelloUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelloUser.setFont(new Font("Calibri", Font.PLAIN, 40));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_5.setBackground(SystemColor.scrollbar);
		panel_5.setLayout(null);
		panel_5.setBounds(10, 148, 493, 306);
		panel.add(panel_5);
		
		JLabel lblNotifications = new JLabel("Notifications");
		lblNotifications.setBackground(SystemColor.activeCaption);
		lblNotifications.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotifications.setFont(new Font("Calibri", Font.PLAIN, 30));
		lblNotifications.setBounds(10, 11, 473, 50);
		panel_5.add(lblNotifications);
		
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
		button.setBounds(418, 465, 85, 80);
		panel_2.add(button);
		
		txtrTodo = new JTextArea();
		txtrTodo.setBackground(Color.LIGHT_GRAY);
		txtrTodo.setText("Todo");
		txtrTodo.setBounds(100, 465, 308, 41);
		panel_2.add(txtrTodo);
		
		
		
		JPanel main_todo = new JPanel();
		main_todo.setBounds(10, 11, 483, 443);
		panel_2.add(main_todo);
		main_todo.setLayout(null);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_todo.repaint();
			}
		});
		btnAdd.setAction(action_2);
		btnAdd.setBounds(10, 465, 85, 41);
		panel_2.add(btnAdd);
		
		try {
	        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", ""); //Creates a Connection with MYSQL Database
			Statement st = c.createStatement();
			st.execute("USE test");
			ResultSet rs = st.executeQuery("SELECT * FROM todo WHERE username='"+username+"' AND status!=-1");
			int i=0;
			while(rs.next()){
				String entry = rs.getString("todo");
				boolean status;
				int s=rs.getInt("status");
				if(s==0){
					status=false;
				}
				else status=true;
				
				//TodoItem td = new TodoItem(entry,status);
				JPanel panel_6 = new JPanel();
				panel_6.setBounds(0,21*i,466, 21);
				
				main_todo.add(panel_6);
				panel_6.setLayout(new BorderLayout(0, 0));
				
				JButton btnNewButton_1 = new JButton("Delete");
				btnNewButton_1.setIcon(new ImageIcon(Mainpage.class.getResource("/com/sun/java/swing/plaf/motif/icons/Error.gif")));
				panel_6.add(btnNewButton_1, BorderLayout.EAST);
			
				
				JCheckBox chckbxNewCheckBox = new JCheckBox(entry);
				if(status==true){
					chckbxNewCheckBox.setSelected(true);
				}
				else chckbxNewCheckBox.setSelected(false);
				panel_6.add(chckbxNewCheckBox, BorderLayout.CENTER);
				
				i++;
			}
			//System.out.println(' '+username+','+currentTime+','+todo+','+0);
		}
		catch(Exception ec) {System.out.println(ec);}
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(467, 0, 16, 443);
		main_todo.add(scrollBar);
		
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBackground(SystemColor.menu);
		tabbedPane.addTab("Schedule", null, panel_3, null);
		panel_3.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setBounds(10, 11, 493, 384);
		panel_3.add(table);
		
		JButton btnEdit = new JButton("Save schedule");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEdit.setBounds(10, 406, 136, 36);
		panel_3.add(btnEdit);
		tabbedPane.setEnabledAt(4, true);
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
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Delete");
			putValue(SHORT_DESCRIPTION, "Delete item and set status -1");
		}
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
