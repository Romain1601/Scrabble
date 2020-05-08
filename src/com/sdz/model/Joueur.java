package com.sdz.model;

public class Joueur {
	
	String name;
	int numero;
	Model_Chevalet chevalet;
	Model_Pioche pioche;
	int point;
	
	public Joueur(String nom, int num, int p, Model_Pioche pi) {
		this.pioche = pi;
		this.name =nom;
		this.numero =num;
		chevalet = new Model_Chevalet(pioche);
		this.point = p;
	}
	
	public String getNameJoueur() {
		return name;
	}
	
	public int getPointJoueur() {
		return point;
	}
	
	public void addPointJoueur(int p) {
		this.point+=p;
		System.out.println(this.name+ "="+this.point+"et"+p);
	}
	
	public Model_Chevalet getChevaletJoueur() {
		return chevalet;
	}
	
	public int getNumJoueur() {
		return numero;
	}

}
