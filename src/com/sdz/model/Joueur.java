package com.sdz.model;

public class Joueur {
	
	String name;
	int numero;
	Model_Chevalet chevalet;
	int point;
	
	public Joueur(String nom, int num, int p) {
		this.name =nom;
		this.numero =num;
		chevalet = new Model_Chevalet();
		this.point = p;
	}
	
	public String getNameJoueur() {
		return name;
	}
	
	public int getPointJoueur() {
		return point;
	}
	
	public void addPointJoueur(int p) {
		point+=p;
	}
	
	public Model_Chevalet getChevaletJoueur() {
		return chevalet;
	}
	
	public int getNumJoueur() {
		return numero;
	}

}
