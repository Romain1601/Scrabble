package com.sdz.model;

import java.util.TreeMap;

public class DictionnairePoint {
	
	static TreeMap<String, Integer> liste = new TreeMap<>();
	
	public DictionnairePoint() {
		liste.put("A", 1);
		liste.put("B", 3);
		liste.put("C", 3);
		liste.put("D", 2);
		liste.put("E", 1);
		liste.put("F", 4);
		liste.put("G", 2);
		liste.put("H", 4);
		liste.put("I", 1);
		liste.put("J", 8);
		liste.put("K", 10);
		liste.put("L", 1);
		liste.put("M", 2);
		liste.put("N", 1);
		liste.put("O", 1);
		liste.put("P", 3);
		liste.put("Q", 8);
		liste.put("R", 1);
		liste.put("S", 1);
		liste.put("T", 1);
		liste.put("U", 1);
		liste.put("V", 4);
		liste.put("W", 10);
		liste.put("X", 10);
		liste.put("Y", 10);
		liste.put("Z", 10);
    }
	
	
	public static int getvalue(String lettre) {
		return liste.get(lettre);
	}
	
	

	
	
}