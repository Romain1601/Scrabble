package com.sdz.vue;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sdz.controler.Controleur_Choix_Joueur;
import com.sdz.model.Model_Choix_Joueur;
import com.sdz.model.Model_Pioche;
import com.sdz.observer.Observer;

public class Vue_Choix_Joueur implements Observer{

	JTextField jtf;
	ArrayList<JPanel> listeformulaire = new ArrayList<JPanel>();
	ArrayList<JTextField> listejtc = new ArrayList<JTextField>();
	JLabel label;
	JButton Start = new JButton("Commencer la partie");
	JButton Ajouter = new JButton("Ajouter un joueur");
	JPanel areaJoueur;
	JPanel formulaire = new JPanel();
	Controleur_Choix_Joueur controleur;
	Model_Choix_Joueur modeleChoixJoueur;
	Vue vue;
	
	
	
	public Vue_Choix_Joueur(Model_Pioche p, Vue v){
		this.vue=v;
		modeleChoixJoueur = new Model_Choix_Joueur(p);
		controleur = new Controleur_Choix_Joueur(this, modeleChoixJoueur);
		formulaire.setBounds(400,100,250,300);
		formulaire.setLayout(new GridLayout(6,1));
		Start.addActionListener(controleur);
		Ajouter.addActionListener(controleur);
		modeleChoixJoueur.addObserver(this);
		addGamer();
		BuildVueChoixJoueur();
		
	}
	
	
	public void BuildVueChoixJoueur() {
		System.out.println(listejtc);
		formulaire.add(Start);
		formulaire.add(Ajouter);
		if(listeformulaire.size()>1) {
			Start.setVisible(true);
		}
		else {
			Start.setVisible(false);
		}
		if(listeformulaire.size()==4) {
			Ajouter.setVisible(false);
		}
		if(listeformulaire.size()!=0){
			for(int i=0;i<listeformulaire.size();i++) {
				formulaire.add(listeformulaire.get(i));
			}
		}
		
		
		
		
	}
	
	public void addGamer() {
		areaJoueur = new JPanel();
		areaJoueur.setLayout(new GridLayout(2,1));
		label = new JLabel("Entrer un nom");
		int num = listeformulaire.size()+1;
		jtf = new JTextField("Joueur " + num);
		areaJoueur.add(label);
		areaJoueur.add(jtf);
		listejtc.add(jtf);
		listeformulaire.add(areaJoueur);
	}
	
	

	public ArrayList<JTextField> getformulaireList(){
		return listejtc;
	}
	
	
	
	
	public JPanel Getformulaire() {
		return formulaire;
	}
	
	public JButton GetStart() {
		return Start;
	}
	
	public JButton GetAjouter() {
		return Ajouter;
	}
	
	
	@Override
	public void update(String str) {
		if(str=="start") {
			System.out.println("coucou");
			vue.start(modeleChoixJoueur);
		}
		else {
			formulaire.removeAll();
			addGamer();
			BuildVueChoixJoueur();
			formulaire.updateUI();
		}
		
	
		
	}
	

}
