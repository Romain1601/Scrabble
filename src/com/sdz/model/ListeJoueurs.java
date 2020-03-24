package com.sdz.model;

import java.util.ArrayList;
import com.sdz.observer.Observable;
import com.sdz.observer.Observer;

public class ListeJoueurs implements Observable{
	
	public ArrayList<Joueur> ListeJoueur = new ArrayList<Joueur>();
	public ArrayList<Observer> ListeJoueurObserver = new ArrayList<Observer>();
	
	public ListeJoueurs() {
		Joueur j = new Joueur("loic", 1, 0);
		Joueur j2 = new Joueur("yoan", 2, 0);
		addJoueur(j);
		addJoueur(j2);
	}
	
	
	
	public ArrayList<Joueur> getListeJoueur() {
		return ListeJoueur;
	}
	
	public void addJoueur(Joueur j) {
		ListeJoueur.add(j);
	}
	
	public Joueur GetJoueur(int num) {
		for(int i=0;i<ListeJoueur.size();i++) {
			if(ListeJoueur.get(i).getNumJoueur()==num) {
					return ListeJoueur.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<String> GetChevalet(int num) {
		for(int i=0;i<ListeJoueur.size();i++) {
			if(ListeJoueur.get(i).getNumJoueur()==num) {
					return ListeJoueur.get(i).getChevaletJoueur().getChevalet();
			}
		}
		return null;
	}
	
	public String GetlettreChevalet(int num,int index) {
		for(int i=0;i<ListeJoueur.size();i++) {
			if(ListeJoueur.get(i).getNumJoueur()==num) {
					return ListeJoueur.get(i).getChevaletJoueur().getStringChevalet(index);
			}
		}
		return null;
	}
	
	public void changeChevaletEtat(int num, int v, int etat) {
		for(int i=0;i<ListeJoueur.size();i++) {
			if(ListeJoueur.get(i).getNumJoueur()==num) {
				for(int j=0;j<ListeJoueur.get(i).getChevaletJoueur().getSelectLettreChevalet().length;j++) {
					if(j==v) {
						ListeJoueur.get(i).getChevaletJoueur().getSelectLettreChevalet()[j]=etat;
					}
					else if(etat!=2) {
						ListeJoueur.get(i).getChevaletJoueur().getSelectLettreChevalet()[j]=0;
					}
					else if (etat==2 && ListeJoueur.get(i).getChevaletJoueur().getSelectLettreChevalet()[j]==1) {
						ListeJoueur.get(i).getChevaletJoueur().getSelectLettreChevalet()[j]=0;
					}
				}	
			}
		}
		notifyObserver(String.valueOf(num));
	}
	
	
	public int[] GetChevaletEtat(int num) {
		for(int i=0;i<ListeJoueur.size();i++) {
			if(ListeJoueur.get(i).getNumJoueur()==num) {
					return ListeJoueur.get(i).getChevaletJoueur().getSelectLettreChevalet();
			}
		}
		return null;
	}
	
	public int GetsizeChevalet(int num) {
		for(int i=0;i<ListeJoueur.size();i++) {
			if(ListeJoueur.get(i).getNumJoueur()==num) {
					return ListeJoueur.get(i).getChevaletJoueur().getChevaletSize();
			}
		}
		return 0;
	}
	
	public void addLettreHasardChevalet(int num) {
		for(int i=0;i<ListeJoueur.size();i++) {
			if(ListeJoueur.get(i).getNumJoueur()==num) {
					ListeJoueur.get(i).getChevaletJoueur().addLettreHasardChevalet();
					notifyObserver(String.valueOf(num));
			}
		}
	}
	
	public void addLettreChevalet(int num,String r) {
		for(int i=0;i<ListeJoueur.size();i++) {
			if(ListeJoueur.get(i).getNumJoueur()==num) {
					ListeJoueur.get(i).getChevaletJoueur().addLettreChevalet(r);
					notifyObserver(String.valueOf(num));
			}
		}
	}
	
	
	public void removeLettreChevalet(int num, String r) {
		for(int i=0;i<ListeJoueur.size();i++) {
			if(ListeJoueur.get(i).getNumJoueur()==num) {
				ListeJoueur.get(i).getChevaletJoueur().removeLettreChevalet(r);
				notifyObserver(String.valueOf(num));
					
			}
		}
	}
	
	public void removeListLettreChevalet(int num, ArrayList<String> r) {
		for(int i=0;i<ListeJoueur.size();i++) {
			if(ListeJoueur.get(i).getNumJoueur()==num) {
				for(int j=0;j<r.size();j++) {
					ListeJoueur.get(i).getChevaletJoueur().removeLettreChevalet(r.get(j));
				}
				notifyObserver(String.valueOf(num));
				
					
			}
		}
		
	}
	
	
	@Override
	public void addObserver(Observer obs) {
		this.ListeJoueurObserver.add(obs);
		
	}

	@Override
	public void removeObserver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObserver(String str) {
		for(Observer obs : ListeJoueurObserver) {
			obs.update(str);
		}
		
	}
	
	
	

}
