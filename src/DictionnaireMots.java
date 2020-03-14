import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionnaireMots {
	
	
	static ArrayList<String> dico;
	Scanner scan;

	
	
	public DictionnaireMots() {
        try {
            dico = new ArrayList<>();
            scan = new Scanner(new File("src/ressources/DicoMots.txt"));
            while (scan.hasNextLine()) {
                dico.add(scan.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		new DictionnaireMots();
	}

}
