package com.sdz.model;

public class CalculPoint extends DictionnairePoint {
	
	static String mot;
	static int point;
	static DictionnairePoint liste = new DictionnairePoint();
	
	public CalculPoint(String m) {
		CalculPoint.mot = m;
		for(int i=0; i<m.length();i++) {
			String s = Character.toString(m.charAt(i));
			point+=getvalue(s);
		}
	}
	
	public static int Point() {
		return point;
	}


}
