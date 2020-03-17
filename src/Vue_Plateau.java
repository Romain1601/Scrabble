import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Vue_Plateau {
	
	static JPanel plateau = new JPanel();
	MatricePlateau matrice = new MatricePlateau();
	int g[][] = matrice.GetMatrice();

	
	public Vue_Plateau() {
		 plateau.setLayout(new GridLayout(15,15));
	     plateau.setPreferredSize(new Dimension(400,400));
	        
	        for(int i=0;i<15;i++) {
	        	for(int j=0;j<15;j++) {
	        		JButton button = new JButton();
	        		if(g[i][j] == 9) {
	        			button.setBackground(Color.red);
	        		}
	        		else if(g[i][j] == 6) {
	        			button.setBackground(Color.pink);
	        		}
	        		else if(g[i][j] == 3) {
	        			button.setBackground(Color.blue);
	        		}
	        		else if(g[i][j] == 2) {
	        			button.setBackground(Color.cyan);
	        		}
	        		else {
	        			button.setBackground(Color.green);
	        		}
	            	button.setOpaque(true);
	            	button.setBorderPainted(true);
	            	plateau.add(button);
	        	}
	        }
	}
	
	public JPanel GetVuePlateau() {
		return plateau;
	}


}
	
