package com.sdz.controler;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.sdz.model.ListeJoueurs;
import com.sdz.model.Model_Plateau;
import com.sdz.vue.Vue_Plateau;

public class Controleur_Plateau implements MouseListener {
	Vue_Plateau vue;
	Model_Plateau model;
	ListeJoueurs listeJoueurs;
	int NumJoueur;
	String lettreselect; 
	
	public Controleur_Plateau(Vue_Plateau v, Model_Plateau m, ListeJoueurs l, int num) {
		this.vue=v;
		this.model=m;
		this.listeJoueurs=l;
		this.NumJoueur=num;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
						if(lettreselect!=null) {
							model.removeLettrePlateau(i,j);
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

}
