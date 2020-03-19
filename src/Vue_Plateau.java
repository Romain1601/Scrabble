import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JPanel;

public class Vue_Plateau implements ActionListener {
	
	static JPanel plateau = new JPanel();
	static ButtonPlateau b[][] = new ButtonPlateau[15][15];
	
	static int k=1;

	
	public Vue_Plateau() {
		if(k==1) {
			new MatricePlateau();
		}
		 plateau.setLayout(new GridLayout(15,15));
	     plateau.setPreferredSize(new Dimension(700,600));
	        for(int i=0;i<15;i++) {
	        	for(int j=0;j<15;j++) {
	        		
	        		b[i][j] = new ButtonPlateau(i,j,"");
	        		if(MatricePlateau.GetMatrice()[i][j] == 9) {
	        			b[i][j].ButtonRed();
	        		}
	        		else if(MatricePlateau.GetMatrice()[i][j] == 6) {
	        			b[i][j].ButtonPink();
	        		}
	        		else if(MatricePlateau.GetMatrice()[i][j] == 3) {
	        			b[i][j].ButtonBlue();
	        		}
	        		else if(MatricePlateau.GetMatrice()[i][j] == 2) {
	        			b[i][j].ButtonCyan();
	        		}
					
	        		else {
	        			b[i][j].ButtonWhite();
	        		}
	        		if(MatricePlateau.GetMatriceModify()[j][i]==1) {
	        			if(MatricePlateau.GetMatriceEtat()[j][i] == RecupPiece.Pieceselect()) {
	        				b[i][j].setlabelButton(RecupPiece.Pieceselect());
		        			b[i][j].ButtonORANGE();
	        			}else {
	        				b[i][j].setlabelButton(MatricePlateau.GetMatriceEtat()[j][i]);
		        			b[i][j].ButtonORANGE();
	        			}
	        			
	        		}
	        		b[i][j].GetButton().addActionListener(this);
	            	plateau.add(b[i][j].GetButton());
	        	}
	        }
	}
	
	public JPanel GetVuePlateau() {
		return plateau;
	}
	
	
	public static void updatePlateau(){
		plateau.removeAll();
		new Vue_Plateau();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				if(source == b[i][j].GetButton()) {
					if(RecupPiece.Pieceselect()!=null && MatricePlateau.GetMatriceModify()[j][i]!=1) {
						DictionnairePiece.removeletter(RecupPiece.Pieceselect());
						Vue_piece.removePiece(RecupPiece.Pieceselect());
						MatricePlateau.addlettre(b[i][j].GetxButton(),b[i][j].GetyButton(),RecupPiece.Pieceselect());
						updatePlateau();
						RecupPiece.changePiece(null);
						new Vue();
					}
					else {
						int[] c = {i,j};
						System.out.println(Arrays.toString(c));
						/*if(CoorPiecePlateau.ifexist(c) == -1) {
							new CoorPiecePlateau(i,j);
						}*/
						
						
						
					}
					
				
				}	
			}
			
		}
		
	}


}
	
