package com.sdz.model;

import java.util.ArrayList;

public class CalculPoint extends DictionnairePoint {

	String mot;
	int point;
	DictionnairePoint liste;


	public CalculPoint() {
		liste = new DictionnairePoint();
	}

	public int Point(String mt, ArrayList<Integer> mlt) {
		int multiplicateur=1;
		point=0;
		boolean motd=false;
		boolean mott=false;
		for(int i=0; i<mt.length();i++) {
			if(mlt.get(i)==1 || mlt.get(i)==6) {
				motd=true;
			}
			else if(mlt.get(i)==9) {
				mott=true;

			}
			else if(mlt.get(i)==3) {
				multiplicateur=3;
			}
			else if(mlt.get(i)==2) {
				multiplicateur=2;				
			}
			else {
				multiplicateur=1;
			}
			
			String s = Character.toString(mt.charAt(i));
			point=point+(getvalue(s)*multiplicateur);
			System.out.println(point);
		}
		if (motd==true) {
			point=point*2;
			
		}
		else if (mott==true) {
			point=point*3;
		}
		return point;
	}


}
