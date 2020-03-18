import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class Vue_Plateau implements ActionListener {
	
	static JPanel plateau = new JPanel();
	MatricePlateau matrice = new MatricePlateau();
	int g[][] = matrice.GetMatrice();
	static ButtonPlateau b[][] = new ButtonPlateau[15][15];

	
	public Vue_Plateau() {
		 plateau.setLayout(new GridLayout(15,15));
	     plateau.setPreferredSize(new Dimension(400,400));
	        
	        for(int i=0;i<15;i++) {
	        	for(int j=0;j<15;j++) {
	        		b[i][j] = new ButtonPlateau(i,j,"");
	        		if(g[i][j] == 9) {
	        			b[i][j].GetButton().setBackground(Color.red);
	        		}
	        		else if(g[i][j] == 6) {
	        			b[i][j].GetButton().setBackground(Color.pink);
	        		}
	        		else if(g[i][j] == 3) {
	        			b[i][j].GetButton().setBackground(Color.blue);
	        		}
	        		else if(g[i][j] == 2) {
	        			b[i][j].GetButton().setBackground(Color.cyan);
	        		}
	        		else {
	        			b[i][j].GetButton().setBackground(Color.green);
	        		}
	        		b[i][j].GetButton().setOpaque(true);
	        		b[i][j].GetButton().addActionListener(this);
	        		b[i][j].GetButton().setBorderPainted(true);
	            	plateau.add(b[i][j].GetButton());
	        	}
	        }
	}
	
	public JPanel GetVuePlateau() {
		return plateau;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				if(source == b[i][j].GetButton()) {
					System.out.println(b[i][j].GetxButton() +","+ b[i][j].GetyButton());
					
				}	
			}
			
		}
		
	}


}
	
