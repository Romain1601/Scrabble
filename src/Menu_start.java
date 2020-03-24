

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu_start implements ActionListener  {
	
	static JPanel menu = new JPanel();
	static JButton button = new JButton("Nouvelle partie");
	static JButton button2 = new JButton("Chargé partie");
	

	
	public Menu_start() {
		button.addActionListener(this);
		button2.addActionListener(this);
		menu.add(button);
		menu.add(button2);     
	}
	
	public JPanel GetMenu() {
		return menu;
	}
	
	public static JButton Getbutton(int i) {
		if(i==0) {
			return button;
		}
		else {
			return button2;
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*Object source = e.getSource();
		if(source == Menu_start.Getbutton(0)){
			Vue.removeMenu();
			Vue.jeu();
			Vue.addButtonValider();
			Vue.addButtonPiocher();
			new Vue();
		}*/
		
	}
	
	

	
	
	

}


