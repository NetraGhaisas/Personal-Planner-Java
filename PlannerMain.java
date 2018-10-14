import javax.swing.*;
import java.awt.*;

class PlannerMain{
	JFrame f;
	JPanel p1,p2,p3;
	PlannerMain(){
		f = new JFrame("Personal Planner");
		
		//init panels
		p1=new JPanel();
		p1.setLayout(new BoxLayout(p1,BoxLayout.PAGE_AXIS));
		//p1.add(lab,BorderLayout.CENTER);
		p2=new JPanel();  
		p3=new JPanel();  
		p1.setBackground(Color.WHITE);
		p2.setBackground(Color.WHITE);
		p3.setBackground(Color.WHITE);
		
		this.createHome();
		
		//panels added to tabbed pane aligned to LEFT
		JTabbedPane tp=new JTabbedPane(JTabbedPane.LEFT); 
		//tp.setBackground(Color.GRAY);
		tp.add("Home",p1);
		tp.add("To-do",p2);  
		tp.add("Notes",p3);    

		//frame has tabbed pane as top level content pane
		//and default inits are specified below
		f.setContentPane(tp);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500,500);
		f.setVisible(true);
		f.setResizable(false);
		f.setLayout(null);	
	}
	
	void createHome(){
		//p1 has box layout.YAXIS 
		//add label hello to 'labels' which has flow layout by default
		//stack that on top of buttons panel which has box layout.XAXIS
		JLabel hello = new JLabel("<html><br><br><center><b>Hello User</b><br>Login or Register to begin!</center><br></html>");
		hello.setFont(new Font("Georgia",Font.PLAIN,25));
		hello.setAlignmentX(Component.CENTER_ALIGNMENT);
		JPanel labels = new JPanel();
		labels.add(hello);
		labels.setMinimumSize(new Dimension(500, 200));
		labels.setPreferredSize(new Dimension(500, 200));
		labels.setMaximumSize(new Dimension(500, 200));		//to define size of panel
		labels.setBackground(Color.WHITE);					//test size functionality by commenting this line or set color to gray
		
		//create buttons panel and add buttons
		JButton login = new JButton("Login");
		login.setFont(new Font("Georgia",Font.PLAIN,18));
		JButton reg = new JButton("Register");
		reg.setFont(new Font("Georgia",Font.PLAIN,18));
		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons,BoxLayout.LINE_AXIS));
		buttons.add(login);
		buttons.add(Box.createRigidArea(new Dimension(20,0)));		//adding filler between buttons
		buttons.add(reg);
		buttons.setBackground(Color.WHITE);	
		//p1.add(hello);
		//p1.add(login);
		//p1.add(reg);
		p1.add(labels);
		p1.add(buttons);
		
	}
	
	public static void main(String[] args){
		PlannerMain plan = new PlannerMain();
	}
}
/*
<applet src="PlannerMain.java" width=500 height=500></applet>
*/