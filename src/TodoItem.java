import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class TodoItem {
	TodoItem(String todo, boolean stat ){
	JPanel panel_6 = new JPanel();
	panel_6.setSize(466, 21);
	//main_todo.add(panel_6);
	panel_6.setLayout(new BorderLayout(0, 0));
	
	JButton btnNewButton_1 = new JButton("Delete");
	btnNewButton_1.setIcon(new ImageIcon(Mainpage.class.getResource("/com/sun/java/swing/plaf/motif/icons/Error.gif")));
	panel_6.add(btnNewButton_1, BorderLayout.EAST);
	
	JCheckBox chckbxNewCheckBox = new JCheckBox(todo);
	if(stat==true){
		chckbxNewCheckBox.setSelected(true);
	}
	else chckbxNewCheckBox.setSelected(false);
	panel_6.add(chckbxNewCheckBox, BorderLayout.CENTER);
	}
}
