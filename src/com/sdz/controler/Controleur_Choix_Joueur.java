package com.sdz.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.JTextField;

import com.sdz.model.Model_Choix_Joueur;
import com.sdz.vue.Vue_Choix_Joueur;

public class Controleur_Choix_Joueur implements ActionListener{

	Vue_Choix_Joueur vue;
	Model_Choix_Joueur model;
	ArrayList<JTextField> jtextfield;
	ArrayList<String> liste = new ArrayList<String>();
	String r;
	
	 public Controleur_Choix_Joueur(Vue_Choix_Joueur v, Model_Choix_Joueur m) {
		 this.vue=v;
		 this.model=m;
	 }
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == vue.GetAjouter()) {
			vue.update("add Gamer");
		}
		else {
			jtextfield = vue.getformulaireList();
			
			for(int i=0;i<jtextfield.size();i++) {
				r = jtextfield.get(i).getText();
				liste.add(r);
				
				
			}
			model.addJoueur(liste);
			
			
		}
	}

}
