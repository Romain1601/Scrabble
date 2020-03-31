package com.sdz.model;

import java.util.ArrayList;
import java.util.Collections;

import com.sdz.observer.Observable;
import com.sdz.observer.Observer;


public class Model_Pioche implements Observable  {
	
	public ArrayList<String> Pioche = new ArrayList<String>();
	public ArrayList<Observer> PiocheObserver = new ArrayList<Observer>();
	
	public Model_Pioche() {
		for(int i=0;i<9;i++) {
			Pioche.add("A");
		}
		for(int i=0; i<2;i++) {
			Pioche.add("B");
			Pioche.add("C");
			Pioche.add("F");
			Pioche.add("G");
			Pioche.add("H");
			Pioche.add("P");
			Pioche.add("V");
		}
		
		for(int i=0; i<3;i++) {
			Pioche.add("D");
			Pioche.add("M");
		}
		
		for(int i=0; i<6;i++) {
			Pioche.add("R");
			Pioche.add("S");
			Pioche.add("T");
			Pioche.add("U");
			Pioche.add("N");
			Pioche.add("O");
		}
		
		for(int i=0; i<15;i++) {
			Pioche.add("E");
		}
		
		for(int i=0; i<5;i++) {
			Pioche.add("L");
		}
		
		for(int i=0; i<8;i++) {
			Pioche.add("I");
		}
		Pioche.add("J");
		Pioche.add("K");
		Pioche.add("Q");
		Pioche.add("W");
		Pioche.add("X");
		Pioche.add("Y");
		Pioche.add("Z");
		
		Collections.sort(Pioche);
    }
	
	public String getLettre(int i) {
		return Pioche.get(i);
	}
	
	public int getLength() {
		return Pioche.size();
	}
	
	public void removeLettre(ArrayList<String> l) {
		for(int i=0;i<l.size();i++) {
			Pioche.remove(l.get(i));
		}
		notifyObserver("remove");
		
	}
	
	
	public void addLettre(ArrayList<String> l) {
		for(int i=0;i<l.size();i++) {
			Pioche.add(l.get(i));
		}
		notifyObserver("remove");
		
	}
	
	public ArrayList<String> getList() {
		return Pioche;
	}

	@Override
	public void addObserver(Observer obs) {
		this.PiocheObserver.add(obs);
		
	}

	@Override
	public void removeObserver() {
		PiocheObserver = new ArrayList<Observer>();
		
	}

	@Override
	public void notifyObserver(String str) {
		PiocheObserver.get(0).update(str);
	}
		
	

	


}
