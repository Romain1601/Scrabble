package com.sdz.model;

import java.util.ArrayList;
import java.util.Random;



public class Model_Chevalet {
	
	protected ArrayList<String> chevalet;
	protected int[] chevaletEtat;
	protected Model_Pioche pioche = new Model_Pioche();
	protected Random rnd = new Random();
	
	public Model_Chevalet() {
		chevalet = new ArrayList<String>();
		chevaletEtat = new int[7];
	}
	
	public void addLettreHasardChevalet() {
		if(getChevaletSize()<7) {
		for(int i=0; i<7; i++) {
			int nombre = rnd.nextInt(pioche.getLength());
			chevalet.add(pioche.getLettre(nombre));
		}
			
		}
	}
	
	public void addLettreChevalet(String Lettre) {
		if(getChevaletSize()<7) {
			chevalet.add(Lettre);
		}
	}
	
	public void removeLettreChevalet(String Lettre) {
		if(getChevaletSize()>0) {
			chevalet.remove(Lettre);
		}
	}
	
	public void selectLettreChevalet(int i) {
		chevaletEtat[i]=1;
	}
	
	public int[] getSelectLettreChevalet() {
		return chevaletEtat;
	}


	public ArrayList<String> getChevalet() {
		return chevalet;
	}
	
	public String getStringChevalet(int i) {
		return chevalet.get(i);
	}

	
	public int getChevaletSize() {
		return chevalet.size();
	}








}
