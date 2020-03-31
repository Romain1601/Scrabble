package com.sdz.model;
import java.util.ArrayList;

import com.sdz.observer.Observable;
import com.sdz.observer.Observer;



public abstract class Abstract_Model_Plateau implements Observable{
	
	
	protected int[][] matriceStatique = new int[15][15];
	protected int[][] matriceEtat = new int[15][15];
	protected String[][] matriceLettre = new String[15][15];
	String lettreSelect;
	private ArrayList<Observer> PlateauObserver = new ArrayList<Observer>();  
	
	
	public abstract void MotTriple(int[][] matrice);
	public abstract void MotDouble(int[][] matrice);
	public abstract void LettreTriple(int[][] matrice);
	public abstract void LettreDouble(int[][] matrice);
	public abstract void LettreDepart(int[][] matrice);
	
	
	public abstract int[][] getMatriceStatique();
	
	public abstract int[][] getMatriceEtat();
	
	public abstract String[][] getMatriceLettre();
	
	public abstract String getLettreSelect();
	
	
	public abstract void addLettrePlateau(int x,int y,String lettre);
	
	
	public abstract void selectLettrePlateau(int x,int y);
	
	public abstract void unselectLettrePlateau(int x,int y);
	
	
	public abstract void removeLettrePlateau(int x,int y);
	
	public abstract void lettreSelect(String l);
	
	
	public void addObserver(Observer obs) {
		 this.PlateauObserver.add(obs);
	}

	public void notifyObserver(String str) {;
		 for(Observer obs : PlateauObserver) {
			 obs.update(str);
		  }
	}

	public void removeObserver() {
		PlateauObserver = new ArrayList<Observer>();
	}
		  
		  
	}
	
	
	



