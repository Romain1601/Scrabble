package com.sdz.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DictionnaireMots {


	public static List<String> dico;
	static Scanner scan;
	





	public DictionnaireMots() {
		try {
			dico = new ArrayList<>();
			scan = new Scanner(new File("./src/ressources/DicoMots.txt"));
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
