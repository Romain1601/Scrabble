package com.sdz.model;

import java.util.ArrayList;
import java.util.Random;



public class Model_Chevalet {
	
	protected ArrayList<String> chevalet;
	protected ArrayList<String> LettreRemove;
	protected int[] chevaletEtat;
	Model_Pioche pioche;
	protected Random rnd = new Random();
	ArrayList<Integer> nombre;
	
	public Model_Chevalet(Model_Pioche p) {
		this.pioche = p;
		chevalet = new ArrayList<String>();
		chevaletEtat = new int[7];
	}
	
	public void addLettreHasardChevalet() {
		if(getChevaletSize()<7) {
			nombre = new ArrayList<Integer>();
			if(pioche.getLength()>7) {
				for(int i=0; i<(7-chevalet.size()); i++) {
					int rand =rnd.nextInt(pioche.getLength());
					while(nombre.contains(rand)==true) {
						rand =rnd.nextInt(pioche.getLength());
					}
					nombre.add(rand);
				}
			}
			else {
				for(int i=0; i<pioche.getLength(); i++) {
					int rand =rnd.nextInt(pioche.getLength());
					while(nombre.contains(rand)==true) {
						rand =rnd.nextInt(pioche.getLength());
					}
					nombre.add(rand);
				}
			}
			LettreRemove = new ArrayList<String>();
			for(int j=0; j<nombre.size();j++) {
				String lettre = pioche.getLettre(nombre.get(j));
				chevalet.add(lettre);
				LettreRemove.add(lettre);
			}
			pioche.removeLettre(LettreRemove);
			
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
