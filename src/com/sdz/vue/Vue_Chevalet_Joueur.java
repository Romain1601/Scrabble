package com.sdz.vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sdz.controler.Controleur_Chevalet;
import com.sdz.model.ListeJoueurs;
import com.sdz.model.Model_Chevalet;
import com.sdz.model.Model_Choix_Joueur;
import com.sdz.model.Model_Pioche;
import com.sdz.observer.Observer;

public class Vue_Chevalet_Joueur implements Observer {
	
	public JPanel ChevaletJoueur = new JPanel();
	public JPanel NomJoueur = new JPanel();
	public JPanel BoutonChevalet = new JPanel();
	JLabel name = new JLabel();
	JButton changerLettre = new JButton("CHANGER");
	
	ListeJoueurs listeJoueurs;
	Model_Pioche modelPioche;
	Controleur_Chevalet controleur;
	ArrayList<LettreChevalet> ListeVueLettreChevalet;
	ArrayList<String> ListeLettreChevaletselectGreen;
	LettreChevalet lettreChevalet;
	int numJoueur;
	Color colorPiece = new Color(239, 210, 80);
	Vue vueglobale;
	Model_Choix_Joueur choixJoueur;
	
	
	public Vue_Chevalet_Joueur(int num, Model_Pioche m, ListeJoueurs l, Vue vg, Model_Choix_Joueur cj) {
		this.modelPioche =m;
		this.numJoueur = num;
		this.listeJoueurs = l;
		this.vueglobale=vg;
		this.choixJoueur=cj;
		controleur = new Controleur_Chevalet(this, modelPioche, listeJoueurs, vueglobale, choixJoueur);
		listeJoueurs.addObserver(this);
		modelPioche.addObserver(this);
		NomJoueur.setBounds(100 ,750,450,50);
		ChevaletJoueur.setLayout(new GridLayout(1,listeJoueurs.GetJoueur(num).getChevaletJoueur().getChevaletSize()));
		ChevaletJoueur.setBounds(100 ,800,450,50);
		BoutonChevalet.setBounds(100 ,900,450,50);
		if(listeJoueurs.GetsizeChevalet(numJoueur)==0) {
			changerLettre.setVisible(false);
		}
		
		
			
			
			
			
		BoutonChevalet.add(changerLettre);
		this.changerLettre.addActionListener(controleur);
		listeJoueurs.addLettreHasardChevalet(num);
	}
	
	
	public JPanel GetVueChevaletJoueur() {
		return ChevaletJoueur;
	}
	
	public JPanel GetVueNomJoueur() {
		return NomJoueur;
	}
	
	public int GetNumJoueur() {
		return numJoueur;
	}
	
	public JPanel GetVueChevaletBoutton() {
		return BoutonChevalet;
	}
	
	
	public JButton GetButtonChangerLettre() {
		return changerLettre;
	}
	
	public ArrayList<LettreChevalet> getListeButtonChevalet(){
		return ListeVueLettreChevalet;
	}
	
	public ArrayList<String> getListeLettreChevaletselectGreen(){
		return ListeLettreChevaletselectGreen;
	}
	

	
	
	
	public void construireVueChevaletJoueur(int n) {
		String nom = listeJoueurs.GetJoueur(n).getNameJoueur();
		name.setText("Joueur : " + nom);
		JButton emplacement = new JButton();
		name.setFont(new Font("Arial",Font.BOLD,18));
		name.setForeground(Color.BLACK);
		NomJoueur.add(name);
		Model_Chevalet  chevalet = listeJoueurs.GetJoueur(n).getChevaletJoueur();
		
		
		if(chevalet.getChevaletSize()!=0) {
			ChevaletJoueur.remove(emplacement);
			ListeVueLettreChevalet = new ArrayList<LettreChevalet>();
			ListeLettreChevaletselectGreen = new ArrayList<String>();
			Font ButtonFont = new Font("Arial", Font.PLAIN, 30);
			
			int[] etat = listeJoueurs.GetChevaletEtat(n);
			for(int i=0;i<chevalet.getChevaletSize();i++) {
				lettreChevalet = new LettreChevalet(i,chevalet.getStringChevalet(i));
				lettreChevalet.GetButton().addMouseListener(controleur);
				lettreChevalet.GetButton().setFont(ButtonFont);
				if(etat[i]==0) {
					lettreChevalet.GetButton().setBackground(colorPiece);
					
				}
				else if(etat[i]==1) {
					lettreChevalet.GetButton().setBackground(Color.YELLOW);
				}
				else {
					lettreChevalet.GetButton().setBackground(Color.GREEN);
					ListeLettreChevaletselectGreen.add(lettreChevalet.GetButton().getText());
				}
				ListeVueLettreChevalet.add(lettreChevalet);
			}
			for(int j=0;j<ListeVueLettreChevalet.size();j++) {
				ListeVueLettreChevalet.get(j).GetButton().addActionListener(controleur);
				ChevaletJoueur.add(ListeVueLettreChevalet.get(j).GetButton());
			
			}	
		}
		
		for(int i=0;i<7-chevalet.getChevaletSize();i++) {
			emplacement = new JButton();
			emplacement.setOpaque(false);
			emplacement.setEnabled(false);
			ChevaletJoueur.add(emplacement);
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void update(String str) {
		if(str!="remove") {
			ChevaletJoueur.removeAll();
			construireVueChevaletJoueur(Integer.parseInt(str));
			ChevaletJoueur.updateUI();
		}
		
		
	}

}
