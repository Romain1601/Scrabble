package com.sdz.vue;
import java.awt.Color;

import java.awt.GridLayout;


import javax.swing.JButton;
import javax.swing.JPanel;

import com.sdz.controler.Controleur_Plateau;
import com.sdz.model.ListeJoueurs;
import com.sdz.model.Model_Plateau;
import com.sdz.observer.Observer;


public class Vue_Plateau extends JPanel implements Observer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public JPanel plateau = new JPanel();
	public JButton grilleButton[][] = new JButton[15][15];
	Model_Plateau ModelPlateau = new Model_Plateau();
	Controleur_Plateau controleur;
	ListeJoueurs listeJoueurs;
	int NumJoueur;
	

	public Vue_Plateau(ListeJoueurs l, int num) {
		this.listeJoueurs=l;
		this.NumJoueur = num;
		controleur = new Controleur_Plateau(this, ModelPlateau, listeJoueurs, NumJoueur);
		ModelPlateau.addObserver(this);
		plateau.setLayout(new GridLayout(15,15));
		plateau.setBounds(20,20,650,600);
		this.ConstruireVuePlateau();
	}
	
	public JPanel GetVuePlateau() {
		return plateau;
	}
	
	public JButton GetButtonPlateau(int x,int y) {
		return grilleButton[x][y];
	}
	
	
	public void ConstruireVuePlateau() {
	        for(int i=0;i<15;i++) {
	        	for(int j=0;j<15;j++) {
	        		grilleButton[i][j]=new JButton();
	        		grilleButton[i][j].addMouseListener(controleur);
	        		switch(ModelPlateau.getMatriceEtat()[j][i]) {
	        		 
	        		case 0:
	        			switch(ModelPlateau.getMatriceStatique()[j][i]) {
	        			case 9:
	        				grilleButton[i][j].setBackground(Color.red);
	        				break;
	        			case 6:
	        				grilleButton[i][j].setBackground(Color.pink);
	        				break;
	        			case 3:
	        				grilleButton[i][j].setBackground(Color.blue);
	        				break;
	        			case 2:
	        				grilleButton[i][j].setBackground(Color.cyan);
	        				break;
	        			case 0:
	        				grilleButton[i][j].setBackground(Color.white);
	        				break;
	        			}
	        			break;
	        		case 1:
	        			if(ModelPlateau.getMatriceLettre()[j][i] == ModelPlateau.getLettreSelect()) {
	        				grilleButton[i][j].setText(ModelPlateau.getLettreSelect());
		        			grilleButton[i][j].setBackground(Color.orange);
	        			}
	        			else {
	        				grilleButton[i][j].setText(ModelPlateau.getMatriceLettre()[j][i]);
	        				grilleButton[i][j].setBackground(Color.orange);
	        			}
	        			break;
	        		case 2:
	        			grilleButton[i][j].setText(ModelPlateau.getMatriceLettre()[j][i]);
	        			grilleButton[i][j].setBackground(Color.yellow);
	        			
	        		}
	            	plateau.add(grilleButton[i][j]);
	        	}
	        }
	}
	
	



	/*@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				if(source == b[i][j].GetButton()) {
					if(RecupPiece.Pieceselect()!=null && MatricePlateau.getMatriceEtat()[j][i]==0) {
						Vue_piece.removePiece(RecupPiece.Pieceselect());
						MatricePlateau.addlettre(b[i][j].GetxButton(),b[i][j].GetyButton(),RecupPiece.Pieceselect());
						updatePlateau();
						RecupPiece.changePiece(null);
						new Vue();
					}
					
					
		
					}
					
				
				}	
			}
			
		}
		
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int buttonDown = e.getButton();
		Object source = e.getSource();
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
		if(buttonDown == MouseEvent.BUTTON3 && source == b[i][j].GetButton()) {
			if(MatricePlateau.getMatriceEtat()[j][i]==1) {
				Vue_piece.add(MatricePlateau.GetMatriceEtat()[j][i]);
				MatricePlateau.removelettre(b[i][j].GetxButton(),b[i][j].GetyButton());
				updatePlateau();
				new Vue_piece();
				new Vue();
			}
			else if(MatricePlateau.getMatriceEtat()[j][i]==2) {
				remove(MatricePlateau.GetMatriceEtat()[j][i]);
				System.out.println(u);
				MatricePlateau.unselectlettre(b[i][j].GetxButton(),b[i][j].GetyButton());
				updatePlateau();
				new Vue();
				}
			
			
			
	    }
		if(buttonDown == MouseEvent.BUTTON1 && source == b[i][j].GetButton()){
			if(MatricePlateau.getMatriceEtat()[j][i]==1) {
				add(MatricePlateau.GetMatriceEtat()[j][i]);
				System.out.println(u);
				MatricePlateau.selectlettre(b[i][j].GetxButton(),b[i][j].GetyButton());
				updatePlateau();
				new Vue();
				
			}
		}
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}*/

	


	@Override
	public void update(String str) {
		plateau.removeAll();
		ConstruireVuePlateau();
		plateau.updateUI();;
	
	}



	


}
	
