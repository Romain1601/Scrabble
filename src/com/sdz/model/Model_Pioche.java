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
			Pioche.add("a");
		}
		for(int i=0; i<2;i++) {
			Pioche.add("b");
			Pioche.add("c");
			Pioche.add("f");
			Pioche.add("g");
			Pioche.add("h");
			Pioche.add("p");
			Pioche.add("v");
		}
		
		for(int i=0; i<3;i++) {
			Pioche.add("d");
			Pioche.add("m");
		}
		
		for(int i=0; i<6;i++) {
			Pioche.add("r");
			Pioche.add("s");
			Pioche.add("t");
			Pioche.add("u");
			Pioche.add("n");
			Pioche.add("o");
		}
		
		for(int i=0; i<15;i++) {
			Pioche.add("e");
		}
		
		for(int i=0; i<5;i++) {
			Pioche.add("l");
		}
		
		for(int i=0; i<8;i++) {
			Pioche.add("i");
		}
		Pioche.add("j");
		Pioche.add("k");
		Pioche.add("q");
		Pioche.add("w");
		Pioche.add("x");
		Pioche.add("y");
		Pioche.add("z");
		
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
		PiocheObserver.get(1).update(str);
		
		
		
	}
		
	

	


}
