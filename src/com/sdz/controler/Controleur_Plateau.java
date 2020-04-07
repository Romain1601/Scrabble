package com.sdz.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


import com.sdz.model.DictionnaireMots;
import com.sdz.model.ListeJoueurs;
import com.sdz.model.Model_Choix_Joueur;
import com.sdz.model.Model_Message;
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
	Model_Message modelMessage;
	ArrayList<String> listelettre = new ArrayList<>();
	String motatester="";
	boolean checkmot=true;
	DictionnaireMots Dicos = new DictionnaireMots();
	ArrayList<String> mot;
	ArrayList<Integer> changementDirection;
	ArrayList<ArrayList<String>> listemot;
	ArrayList<Integer> multiplicateur;
	ArrayList<ArrayList<Integer>> listemultiplicateur;
	ArrayList<String> erreur =  new ArrayList<String>();

	int x1;
	int x2;
	int position;
	int newlettrepose=0;
	boolean premiertour;





	public Controleur_Plateau(Vue_Plateau v, Model_Plateau m, ListeJoueurs l, int num, Vue vg , Model_Choix_Joueur j, Model_Message me) {
		this.choixJoueur =j;
		this.vue=v;
		this.model=m;
		this.modelMessage =me;
		this.listeJoueurs=l;
		this.NumJoueur=num;
		this.vueglobale=vg;
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
			modelMessage.resetListError();
			modelMessage.resetSuccess();
			mot = new ArrayList<String>();
			listemot = new ArrayList<ArrayList<String>>();
			multiplicateur = new ArrayList<Integer>();
			listemultiplicateur = new ArrayList<ArrayList<Integer>>();
			boolean placementbon = true;
			premiertour = true;
			changementDirection = new ArrayList<Integer>();
			x1=0;
			x2=0;
			newlettrepose=0;

			for(int m = 0; m < model.getMatriceLettre().length;m++){
				for(int n = 0; n < model.getMatriceLettre()[m].length; n++){
					if(model.getMatriceEtatInt(m, n)==1) {
						newlettrepose+=1;
						if(x1==m) {
							position=1;
						}
						else if(x2==n) {
							position=2;

						}
						else if(newlettrepose==1) {
							position=2;
						}
						else {
							position=0;
						}
						changementDirection.add(position);
						x1=m;
						x2=n;
					}
					else if(model.getMatriceEtatInt(m, n)==2) {
						premiertour=false;
					}

				}
			}

			if(changementDirection.size()>1) {
				if(changementDirection.get(1)!= changementDirection.get(changementDirection.size()-1)) {
					placementbon=false;
					modelMessage.addError("vous devez placer vos lettre soit horizontalement ou soit verticalement, pas les deux a la fois");
				}
			}

			if(placementbon==true) {
				if(position==0 ){
					mot = new ArrayList<String>();
					if(newlettrepose<=1) {
						modelMessage.addError("vous devez placer plus de 2 lettres");
					}
					else {
						modelMessage.addError("vous devez placer vos lettres verticalement ou horizontalement");
					}

				}
				else if(position==1) {
					for(int n = 0; n < model.getMatriceLettre()[x1].length; n++){
						if(model.getMatriceEtatInt(x1, n)==1 || model.getMatriceEtatInt(x1, n)==2 ) {
							mot.add(model.getMatriceLettre(x1, n));
							multiplicateur.add(model.getMatriceStatique(x1, n));
						}
					}
					listemot.add(mot);
					listemultiplicateur.add(multiplicateur);
					multiplicateur = new ArrayList<Integer>();
					mot = new ArrayList<String>();
					for(int n = 0; n < model.getMatriceLettre()[x1].length; n++) {
						if(model.getMatriceEtatInt(x1, n)==1 && model.getMatriceEtatInt(x1-1, n)==2) {
							int i=0;
							while(model.getMatriceEtatInt(x1-i, n)!=0) {
								i+=1;
							}
							for(int m=x1-i; m< model.getMatriceLettre().length;m++) {
								if(model.getMatriceEtatInt(m, n)==2 || model.getMatriceEtatInt(m, n)==1 ) {
									mot.add(model.getMatriceLettre(m, n));
									multiplicateur.add(model.getMatriceStatique(m, n));
								}

							}
							listemot.add(mot);
							mot = new ArrayList<String>();
							listemultiplicateur.add(multiplicateur);
							multiplicateur = new ArrayList<Integer>();
						}
					}
					for(int n = 0; n < model.getMatriceLettre()[x1].length; n++) {
						if(model.getMatriceEtatInt(x1, n)==1 && model.getMatriceEtatInt(x1+1, n)==2) {
							int i=0;
							while(model.getMatriceEtatInt(x1+i, n)!=0) {
								i+=1;
							}
							for(int m=x1; m<x1+i;m++) {
								if(model.getMatriceEtatInt(m, n)==2 || model.getMatriceEtatInt(m, n)==1 ) {
									mot.add(model.getMatriceLettre(m, n));
									multiplicateur.add(model.getMatriceStatique(m, n));
								}

							}
							listemot.add(mot);
							mot = new ArrayList<String>();
							listemultiplicateur.add(multiplicateur);
							multiplicateur = new ArrayList<Integer>();
						}
					}
				}
				else {
					for(int m = 0; m < model.getMatriceLettre().length;m++){
						if(model.getMatriceEtatInt(m, x2)==1 || model.getMatriceEtatInt(m, x2)==2 ) {
							mot.add(model.getMatriceLettre(m, x2));
							multiplicateur.add(model.getMatriceStatique(m, x2));
						}
					}
					listemot.add(mot);
					mot = new ArrayList<String>();
					listemultiplicateur.add(multiplicateur);
					multiplicateur = new ArrayList<Integer>();

					for(int m = 0; m < model.getMatriceLettre().length;m++){
						if(model.getMatriceEtatInt(m, x2)==1 && model.getMatriceEtatInt(m, x2-1)==2) {
							int i=0;
							while(model.getMatriceEtatInt(m, x2-i)!=0) {
								i+=1;
							}
							for(int n=x2-i; n < model.getMatriceLettre()[m].length;n++) {
								if(model.getMatriceEtatInt(m, n)==2 || model.getMatriceEtatInt(m, n)==1 ) {
									mot.add(model.getMatriceLettre(m, n));
									multiplicateur.add(model.getMatriceStatique(m, n));
								}

							}
							listemot.add(mot);
							mot = new ArrayList<String>();
							listemultiplicateur.add(multiplicateur);
							multiplicateur = new ArrayList<Integer>();
						}
					}

					for(int m = 0; m < model.getMatriceLettre().length;m++){
						if(model.getMatriceEtatInt(m, x2)==1 && model.getMatriceEtatInt(m, x2+1)==2) {
							int i=0;
							while(model.getMatriceEtatInt(m, x2+i)!=0) {
								i+=1;
							}
							for(int n=x2; n < x2+i;n++) {
								if(model.getMatriceEtatInt(m, n)==2 || model.getMatriceEtatInt(m, n)==1 ) {
									mot.add(model.getMatriceLettre(m, n));
									multiplicateur.add(model.getMatriceStatique(m, n));
								}

							}
							listemot.add(mot);
							mot = new ArrayList<String>();
							listemultiplicateur.add(multiplicateur);
							multiplicateur = new ArrayList<Integer>();
						}
					}
				}	
			}

		}

		if(premiertour==false) {
			int k=0;
			int v=0;
			for(int m = 0; m < model.getMatriceLettre().length;m++){
				for(int n = 0; n < model.getMatriceLettre()[m].length; n++){
					if(model.getMatriceEtatInt(m, n)==1){
						k+=1;
						if(model.getMatriceEtatInt(m+1, n)!=2 && model.getMatriceEtatInt(m-1,n)!=2 && model.getMatriceEtatInt(m ,n+1)!=2 &&  model.getMatriceEtatInt(m ,n-1)!=2) {
							v+=1;
						}
					}
				}
			}
			if(k==v) {
				modelMessage.addError("vous devez placer vos lettres a cot� de celle deja plac�");
			}
		}

		if(modelMessage.getListError().size()==0) {
			if(listemot.size()>0) {
				checkmot=true;
				System.out.println(listemot);
				System.out.println(listemultiplicateur);
				for(int p = 0; p< listemot.size();p++){
					for(int a = 0; a< listemot.get(p).size();a++){
						motatester=motatester + listemot.get(p).get(a);
					} 			
					if(!DictionnaireMots.motExistant(motatester)) {
						checkmot=false;						
					}
					motatester="";

				}
				if(checkmot==false) {
					modelMessage.addError("Au moins un des mots est faux !");
				}
				else {
					int i = NumJoueur+1;
					if(i>(listeJoueurs.getListeJoueur().size()-1)) {
						i=0;
					}
					motatester="";
					model.changeMatriceEtat(2);
					vueglobale.changeJoueur(choixJoueur,i);
				}

			}			
		}































		/*for(int m = 0; m < model.getMatriceLettre().length;m++){
	            for(int n = 0; n < model.getMatriceLettre()[m].length; n++){
	            	if(model.getMatriceLettre()[m][n]!=null) {
	            		motatester=motatester+model.getMatriceLettre()[m][n];
	            	}
	            }
	        }
			if(DictionnaireMots.motExistant(motatester)) {
				System.out.println("good");
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
			}*/
	}

}


