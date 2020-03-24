package com.sdz.vue;



import javax.swing.JButton;
import javax.swing.JFrame;

import com.sdz.model.ListeJoueurs;
import com.sdz.model.Model_Pioche;
import com.sdz.vue.Vue_Plateau;






public class Vue extends JFrame   {
	private static final long serialVersionUID = 1L;
	

	
	Model_Pioche modelPioche = new Model_Pioche(); 
	ListeJoueurs listeJoueurs = new ListeJoueurs();
	Vue_Chevalet_Joueur Vue_chevalet_joueur = new Vue_Chevalet_Joueur(1, modelPioche, listeJoueurs);
	Vue_Plateau vue_plateau = new Vue_Plateau(listeJoueurs, 1);
	Vue_Pioche vue_pioche = new Vue_Pioche(modelPioche);
	
	//Controleur_Plateau c = new Controleur_Plateau(vue_plateau,Model_plateau);
	/*static PiocherLettre Piocher = new PiocherLettre();
	static Valider_mot Valider = new Valider_mot();
	static Vue_piece piece = new Vue_piece();
	static Menu_start menu = new Menu_start();*/
	JFrame fenetre = new JFrame(); 
	
	public Vue() {
		fenetre.setTitle("Scrabble");
		fenetre.setSize(1000, 1000);
		fenetre.setLocationRelativeTo(null); 
        fenetre.setResizable(false);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setLayout(null);
        fenetre.setVisible(true);
        fenetre.add(vue_plateau.GetVuePlateau());
        fenetre.add(vue_pioche.GetVuePioche());
        fenetre.add(Vue_chevalet_joueur.GetVueNomJoueur());
        fenetre.add(Vue_chevalet_joueur.GetVueChevaletJoueur());
        fenetre.add(Vue_chevalet_joueur.GetVueChevaletBoutton());
        
        
    }
	
	
	/*public void addPlateauMouseListener() {
		 for(int i=0;i<15;i++) {
				for(int j=0;j<15;j++) {
					vue_plateau.GetButtonPlateau(i,j).addMouseListener(c);
					
				}
		 }
	}*/
	
	
	
	public JFrame getVue() {
		return fenetre;
	}
	
	
	public JButton getbuttonsPlateau(int x,int y) {
		return vue_plateau.GetButtonPlateau(x,y);
	}


	
	
	
	
	
	/*public static void menu() {
		fenetre.add(menu.GetMenu());
	}
	
	public static void removeMenu() {
		fenetre.remove(menu.GetMenu());
	}
	
	public static void jeu() {
		fenetre.add(plateau.GetVuePlateau());
        fenetre.add(piece.GetVuePiece());
	}
	
	public static void addButtonPiocher() {
		fenetre.add(Piocher.GetPiocher());  
	}
	
	public static void addButtonValider() {
		fenetre.add(Valider.Getvalider());  
	}*/

	
  
	
	




	

	
	
	
	
	
	
	

};
