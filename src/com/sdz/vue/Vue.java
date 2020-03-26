package com.sdz.vue;



import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.sdz.model.ListeJoueurs;
import com.sdz.model.Model_Choix_Joueur;
import com.sdz.model.Model_Pioche;
import com.sdz.vue.Vue_Plateau;






public class Vue extends JFrame   {
	private static final long serialVersionUID = 1L;
	

	
	Model_Pioche modelPioche = new Model_Pioche(); 
	Vue_Pioche vue_pioche = new Vue_Pioche(modelPioche);
	Vue_Choix_Joueur menuJoueur = new Vue_Choix_Joueur(modelPioche,this);
	
	

	ListeJoueurs listeJoueurs;
	Vue_Chevalet_Joueur Vue_chevalet_joueur;
	Vue_Plateau vue_plateau;
	Vue_Point_Joueur vue_point;
	JFrame fenetre = new JFrame(); 
	JPanel inside = new JPanel(); 
	
	public Vue() {
		fenetre.setTitle("Scrabble");
		fenetre.setSize(1000, 1000);
		fenetre.setLocationRelativeTo(null); 
        fenetre.setResizable(false);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setLayout(null);
        fenetre.setVisible(true);
        inside.add(menuJoueur.Getformulaire());
        inside.setBounds(0,0,1000,1000);
        inside.setLayout(null);
        fenetre.add(inside);
       
    }
	
	
	public void start(Model_Choix_Joueur j) {
		inside.removeAll();
		listeJoueurs = new ListeJoueurs(modelPioche , j.getlisteJoueur());
		Vue_chevalet_joueur = new Vue_Chevalet_Joueur(j.getlisteJoueur().get(0).getNumJoueur(), modelPioche, listeJoueurs);
		vue_plateau = new Vue_Plateau(listeJoueurs, j.getlisteJoueur().get(0).getNumJoueur());
		vue_point = new Vue_Point_Joueur(listeJoueurs);
		inside.add(vue_plateau.GetVuePlateau());
		inside.add(vue_pioche.GetVuePioche());
		inside.add(Vue_chevalet_joueur.GetVueNomJoueur());
		inside.add(Vue_chevalet_joueur.GetVueChevaletJoueur());
		inside.add(Vue_chevalet_joueur.GetVueChevaletBoutton());
		inside.add(vue_point.getVuePoint());
		inside.updateUI();
	}
	
	
	
	
	public JFrame getVue() {
		return fenetre;
	}
	
	
	public JButton getbuttonsPlateau(int x,int y) {
		return vue_plateau.GetButtonPlateau(x,y);
	}


	
	


};
