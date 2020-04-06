package com.sdz.vue;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.sdz.controler.Controleur_Plateau;
import com.sdz.model.ListeJoueurs;
import com.sdz.model.Model_Choix_Joueur;
import com.sdz.model.Model_Plateau;
import com.sdz.observer.Observer;


public class Vue_Plateau extends JPanel implements Observer {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	
	public JPanel plateau = new JPanel();
	public JPanel valider = new JPanel();
	public JButton grilleButton[][] = new JButton[15][15];
	JButton validerbouton  = new JButton("VALIDER");
	Model_Plateau ModelPlateau = new Model_Plateau();
	Controleur_Plateau controleur;
	ListeJoueurs listeJoueurs;
	Model_Choix_Joueur choixJoueur;
	Vue vueglobale;
	int NumJoueur;
	Color colorMT = new Color(225, 33, 110);
	Color colorMD = new Color(254, 139, 112);
	Color colorLT = new Color(17, 119, 179);
	Color colorLD = new Color(146, 206, 255);
	Color colorCV = new Color(232, 234, 241);
	Color colorDep = new Color(252, 255, 170);
	Color colorNewPiece = new Color(255, 178, 51);
	Color colorPiece = new Color(239, 210, 80);
	
	
	Color colorBorder = new Color(244, 242, 247);
	

	

	public Vue_Plateau(ListeJoueurs l, int num, Vue v, Model_Choix_Joueur j) {
		this.choixJoueur =j;
		this.listeJoueurs=l;
		this.NumJoueur = num;
		this.vueglobale = v;
		controleur = new Controleur_Plateau(this, ModelPlateau, listeJoueurs, NumJoueur, vueglobale, choixJoueur);
		ModelPlateau.addObserver(this);
		plateau.setLayout(new GridLayout(15,15));
		plateau.setBounds(20,20,650,650);
		plateau.setBackground(colorBorder);
		validerbouton.addActionListener(controleur);
		valider.setBounds(575,700,100,50);
		valider.add(validerbouton);
		this.ConstruireVuePlateau();
	}
	
	public JPanel GetVuePlateau() {
		return plateau;
	}
	public JPanel GetVuevalider() {
		return valider;
	}
	
	public JButton Getboutonvalider() {
		return validerbouton;
	}
	
	public void changeControleur(int i) {
		controleur.Controleur_Plateau_change(this, i);
		
	}
	
	
	
	public JButton GetButtonPlateau(int x,int y) {
		return grilleButton[x][y];
	}
	
	
	public void ConstruireVuePlateau() {
	        for(int i=0;i<15;i++) {
	        	for(int j=0;j<15;j++) {
	        		grilleButton[i][j]=new JButton();
	        		grilleButton[i][j].setBorder(BorderFactory.createLineBorder(colorBorder,2));
	        		Color colorPiece = new Color(239, 210, 80);
	        		Font ButtonFont = new Font("Arial", Font.PLAIN, 20);
	        		grilleButton[i][j].addMouseListener(controleur);
	        		grilleButton[i][j].setOpaque(true);
	        		grilleButton[i][j].setVerticalTextPosition(AbstractButton.CENTER);
	        		
	        		grilleButton[i][j].setFont(ButtonFont);
	  
	        		switch(ModelPlateau.getMatriceEtat()[j][i]) {
	        		 
	        		case 0:
	        			switch(ModelPlateau.getMatriceStatique()[j][i]) {
	        			case 9:
	        				grilleButton[i][j].setBackground(colorMT);
	        				grilleButton[i][j].setText("MT");
	        				break;
	        			case 6:
	        				grilleButton[i][j].setBackground(colorMD);
	        				grilleButton[i][j].setText("MD");
	        				break;
	        			case 3:
	        				grilleButton[i][j].setBackground(colorLT);
	        				grilleButton[i][j].setText("LT");
	        				break;
	        			case 2:
	        				grilleButton[i][j].setBackground(colorLD);
	        				grilleButton[i][j].setText("LD");
	        				break;
	        			case 1:
	        				grilleButton[i][j].setBackground(colorDep);
	        				grilleButton[i][j].setText("MD");
	        				break;
	        			case 0:
	        				grilleButton[i][j].setBackground(colorCV);
	        				break;
	        			}
	        			break;
	        		case 1:
	        			if(ModelPlateau.getMatriceLettre()[j][i] == ModelPlateau.getLettreSelect()) {
	        				grilleButton[i][j].setText(ModelPlateau.getLettreSelect());
		        			grilleButton[i][j].setBackground(colorPiece);
		        			grilleButton[i][j].setBorder(BorderFactory.createLineBorder(colorPiece,2));
	        			}
	        			else {
	        				grilleButton[i][j].setText(ModelPlateau.getMatriceLettre()[j][i]);
	        				grilleButton[i][j].setBackground(colorNewPiece);
	        				grilleButton[i][j].setBorder(BorderFactory.createLineBorder(colorNewPiece,2));
	        			}
	        			break;
	        		case 2:
	        			grilleButton[i][j].setText(ModelPlateau.getMatriceLettre()[j][i]);
	        			grilleButton[i][j].setBackground(colorPiece);
	        			grilleButton[i][j].setBorder(BorderFactory.createLineBorder(colorPiece,2));
	        		}
	            	plateau.add(grilleButton[i][j]);
	        	}
	        }
	}
	
	
	@Override
	public void update(String str) {
		plateau.removeAll();
		ConstruireVuePlateau();
		plateau.updateUI();
	
	}



	


}
	
