package com.sdz.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


import com.sdz.model.DictionnaireMots;
import com.sdz.model.ListeJoueurs;
import com.sdz.model.Model_Choix_Joueur;
import com.sdz.model.Model_Plateau;
import com.sdz.vue.Vue;
import com.sdz.vue.Vue_Plateau;

public class Controleur_Plateau implements MouseListener, ActionListener {
	Vue_Plateau vue;
	Model_Plateau model;
	ListeJoueurs listeJoueurs;
	int NumJoueur;
	String lettreselect; 
	Integer EtatSelect; 
	Vue vueglobale;
	Model_Choix_Joueur choixJoueur;
	ArrayList<String> listelettre = new ArrayList<>();
	String motatester="";
	DictionnaireMots Dicos = new DictionnaireMots();
	String[][] matriceindice = new String[15][15];
    
	
	
	
	public Controleur_Plateau(Vue_Plateau v, Model_Plateau m, ListeJoueurs l, int num, Vue vg , Model_Choix_Joueur j) {
		this.choixJoueur =j;
		this.vue=v;
		this.model=m;
		this.listeJoueurs=l;
		this.NumJoueur=num;
		this.vueglobale=vg;
		for(int p = 0; p < matriceindice.length; p++){
	        matriceindice[p] = new String[15];
	    }
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	public void Controleur_Plateau_change(Vue_Plateau v, int num) {
		this.NumJoueur=num;
		this.vue=v;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int clic = e.getButton();
		Object source = e.getSource();
		int[] etat = listeJoueurs.GetChevaletEtat(NumJoueur);
		boolean exist = false;
		if(clic == MouseEvent.BUTTON1){
			for(int i=0;i<15;i++) {
				for(int j=0;j<15;j++) {
					if(source == vue.grilleButton[i][j]) {
						if(model.getMatriceLettre(j, i)!=null) {
							exist=true;
						}
					
					}
				}
			}
			if(exist!=true) {
				for(int k=0;k<etat.length;k++) {
					if(etat[k]==1) {
						lettreselect = listeJoueurs.GetlettreChevalet(NumJoueur,k);
						listeJoueurs.removeLettreChevalet(NumJoueur,lettreselect);
						listeJoueurs.changeChevaletEtat(NumJoueur,k,0);
					}
				}
				for(int i=0;i<15;i++) {
					for(int j=0;j<15;j++) {
						if(source == vue.grilleButton[i][j]) {
							if(lettreselect!=null) {
								if(model.getMatriceLettre(j, i)==null) {
									model.addLettrePlateau(i,j,lettreselect);					
									matriceindice[i][j]=lettreselect;
									lettreselect = null;
								}
							
							}
							
						}
					}
				}
			}
			
		}
		if(clic == MouseEvent.BUTTON3){
			for(int i=0;i<15;i++) {
				for(int j=0;j<15;j++) {
					if(source == vue.grilleButton[i][j]) {
						lettreselect = model.getMatriceLettre(j,i);
						EtatSelect = model.getMatriceEtatInt(j,i);
						if(lettreselect!=null && EtatSelect==1) {
							model.removeLettrePlateau(i,j);
							matriceindice[i][j]=null;
							listeJoueurs.addLettreChevalet(NumJoueur,lettreselect);
							for(int k=0;k<etat.length;k++) {
								listeJoueurs.changeChevaletEtat(NumJoueur,k,0);
								}	
							}
						lettreselect=null;
							
						}
						
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
		if(source == vue.Getboutonvalider()) {
			for(int m = 0; m < model.getMatriceLettre().length;m++){
	            for(int n = 0; n < model.getMatriceLettre()[m].length; n++){
	            	if(model.getMatriceLettre()[m][n]!=null) {
	            		motatester=motatester+model.getMatriceLettre()[m][n];
	            	}
	            }
	        }
			if(DictionnaireMots.motExistant(motatester)) {
				int i = NumJoueur+1;
				if(i>(listeJoueurs.getListeJoueur().size()-1)) {
					i=0;
				}
				motatester="";
				
				model.changeMatriceEtat(2);
				vueglobale.changeJoueur(choixJoueur,i);
			}
			else {
				System.out.println(motatester);
			}
		}
		
	}

}
