package com.sdz.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionnaireMots {
	
	
	static ArrayList<String> dico;
	Scanner scan;
	String rep = "src";
	File path = new File(rep);
	String chemin = path.getAbsolutePath() + "/ressources/dictionnaire.txt";


	
	
	public DictionnaireMots() {
        try {
            dico = new ArrayList<>();
            scan = new Scanner(new File(chemin));
            while (scan.hasNextLine()) {
                dico.add(scan.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static boolean motExistant(String mot) {
        return dico.contains(mot);
    }
	
	
}
