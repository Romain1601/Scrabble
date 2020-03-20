import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Valider_mot implements ActionListener{
	
	static JPanel Valider = new JPanel();
	static JButton ValiderBouton = new JButton("valider");
	String mot;
	static boolean valider = false;
	
	public Valider_mot() {
		ValiderBouton.setOpaque(true);
		ValiderBouton.setBorderPainted(true);
		ValiderBouton.addActionListener(this);
		Valider.add(ValiderBouton);
	}
	
	public JPanel Getvalider() {
		return Valider;
	}
	
	public static boolean booleanvalider() {
		return valider;
	}
	
	public static void changeEtatValider(boolean c) {
		valider=c;
	}
	
	public static void TraiterMotValider(ArrayList<int[]> k) {
		for(int i=0;i<k.size();i++) {
			
		}
	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stu
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == ValiderBouton){
			if(Vue_Plateau.getlist().size()>0) {
				changeEtatValider(true);
			}
			
				
				
		}
		
		}
		
	}

