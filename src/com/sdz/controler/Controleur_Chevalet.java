package com.sdz.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import com.sdz.model.ListeJoueurs;
import com.sdz.model.Model_Choix_Joueur;
import com.sdz.model.Model_Message;
import com.sdz.model.Model_Pioche;
import com.sdz.vue.Vue;
import com.sdz.vue.Vue_Chevalet_Joueur;



public class Controleur_Chevalet implements MouseListener, ActionListener {
	
	Vue_Chevalet_Joueur vue;
	Model_Pioche modelPioche;
	ListeJoueurs listeJoueurs;
	ArrayList<String> listLettre;
	Vue vueglobale;
	Model_Message ModelMessage;
	Model_Choix_Joueur choixJoueur;
	
	
	public Controleur_Chevalet(Vue_Chevalet_Joueur v, Model_Pioche m, ListeJoueurs l, Vue vg, Model_Choix_Joueur cj, Model_Message me) {
		this.vue=v;
		this.modelPioche=m;
		this.listeJoueurs=l;
		this.vueglobale =vg;
		this.choixJoueur= cj;
		this.ModelMessage =me;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		 
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object source = e.getSource();
		
		int buttonDown = e.getButton();
		for(int i=0;i<listeJoueurs.GetsizeChevalet(vue.GetNumJoueur());i++) {
			if(buttonDown == MouseEvent.BUTTON1) {
				if(e.isControlDown() && source == vue.getListeButtonChevalet().get(i).GetButton()) {
					listeJoueurs.changeChevaletEtat(vue.GetNumJoueur(),i,2);
					vue.GetButtonChangerLettre().setVisible(true);
			    }
				else if(source == vue.getListeButtonChevalet().get(i).GetButton()) {
					listeJoueurs.changeChevaletEtat(vue.GetNumJoueur(),i,1);
					
					//changerLettre.setEnabled(false);
				}
			}
			else if(buttonDown == MouseEvent.BUTTON3) {
				if(source == vue.getListeButtonChevalet().get(i).GetButton()) {
					listeJoueurs.changeChevaletEtat(vue.GetNumJoueur(),i,0);
				}
			}
			
		
		
	}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == vue.GetButtonChangerLettre()) {
			modelPioche.addLettre(vue.getListeLettreChevaletselectGreen());
			listeJoueurs.removeListLettreChevalet(vue.GetNumJoueur(),vue.getListeLettreChevaletselectGreen());
			for(int i=0;i<vue.getListeLettreChevaletselectGreen().size();i++) {
				listeJoueurs.changeChevaletEtat(vue.GetNumJoueur(),i,0);
				int k = vue.GetNumJoueur()+1;
				if(k>(listeJoueurs.getListeJoueur().size()-1)) {
					k=0;
				};
				vueglobale.changeJoueur(choixJoueur,k);
			}
			vue.GetButtonChangerLettre().setVisible(false);
			
			
			
			
		}
		
		
	}
	
}
