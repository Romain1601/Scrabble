package com.sdz.model;

import java.util.ArrayList;

import com.sdz.observer.Observable;
import com.sdz.observer.Observer;

public class Model_Choix_Joueur implements Observable  {
	
	ArrayList<Joueur> listejoueur = new ArrayList<Joueur>();
	public ArrayList<Observer> ListeChoixObserver = new ArrayList<Observer>();
	Joueur joueur;
	Model_Pioche pioche;
	
	public Model_Choix_Joueur(Model_Pioche p) {
		this.pioche=p;
	}
	
	
	
	
	public ArrayList<Joueur> getlisteJoueur() {
		return listejoueur;
	}
	
	
	public void addJoueur(ArrayList<String> l) {
		for(int i=0;i<l.size();i++) {
			joueur = new Joueur(l.get(i),i,0,pioche);
			listejoueur.add(joueur);
		}
		notifyObserver("start");
		
	}

	@Override
	public void addObserver(Observer obs) {
		this.ListeChoixObserver.add(obs);
		
	}

	@Override
	public void removeObserver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObserver(String str) {
		for(Observer obs : ListeChoixObserver) {
			obs.update(str);
		}
		
	}
	
	

	
	
	

}
