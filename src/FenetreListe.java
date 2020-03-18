import java.awt.FlowLayout;

import javax.swing.JComboBox;
//...
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreListe extends JFrame {
	private JComboBox liste1;
	private JComboBox liste2;

	//...

	private JPanel buildContentPane(){
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		Object[] elements = new Object[]{"Element 1", "Element 2", "Element 3", "Element 4", "Element 5"};

		liste1 = new JComboBox<Object>(elements);

		panel.add(liste1);



		return panel;
	}

	public JComboBox getListe1(){
		return liste1;
	}

	
}