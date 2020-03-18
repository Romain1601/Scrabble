import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JPanel;

public class Vue_Plateau implements ActionListener {
	
	static JPanel plateau = new JPanel();
	int g[][] = MatricePlateau.GetMatrice();
	int o[][] = MatricePlateau.GetMatriceModify();
	static ButtonPlateau b[][] = new ButtonPlateau[15][15];
	static int k=1;

	
	public Vue_Plateau() {
		if(k==1) {
			new MatricePlateau();
		}
		 plateau.setLayout(new GridLayout(15,15));
	     plateau.setPreferredSize(new Dimension(700,600));
	     MatricePlateau.afficherMatriceModify() ;
	        for(int i=0;i<15;i++) {
	        	for(int j=0;j<15;j++) {
	        		
	        		b[i][j] = new ButtonPlateau(i,j,"");
	        		if(g[i][j] == 9) {
	        			b[i][j].ButtonRed();
	        		}
	        		else if(g[i][j] == 6) {
	        			b[i][j].ButtonPink();
	        		}
	        		else if(g[i][j] == 3) {
	        			b[i][j].ButtonBlue();
	        		}
	        		else if(g[i][j] == 2) {
	        			b[i][j].ButtonCyan();
	        		}
					
	        		else {
	        			b[i][j].ButtonGreen();
	        		}
	        		if(o[j][i] == 1) {
	        			b[i][j].setlabelButton(RecupPiece.Pieceselect());
	        			b[i][j].ButtonORANGE();
	        		}
	        		b[i][j].GetButton().addActionListener(this);
	            	plateau.add(b[i][j].GetButton());
	        	}
	        }
	}
	
	public JPanel GetVuePlateau() {
		return plateau;
	}
	
	
	public static void addPiecePlateau(){
		plateau.removeAll();
		new Vue_Plateau();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				if(source == b[i][j].GetButton()) {
					DictionnairePiece.removeletter(RecupPiece.Pieceselect());
					Vue_piece.removePiece(RecupPiece.Pieceselect());
					MatricePlateau.addlettre(b[i][j].GetxButton(),b[i][j].GetyButton());
					addPiecePlateau();
					new Vue();
				
				}	
			}
			
		}
		
	}


}
	
