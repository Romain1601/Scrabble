import java.util.ArrayList;
import java.util.Random;

public class PieceHasard extends DictionnairePiece  {
	
	 
	static ArrayList<String> Piecedepart = new ArrayList<String>();
	static Random rnd = new Random();
	
	public PieceHasard() {
		for(int i=0;i<7;i++) {
			int nombre = rnd.nextInt(DictionnairePiece.getlength());
			Piecedepart.add(DictionnairePiece.getPiece(nombre));
		}
	}
	
	public static  String getdepart(int i) {
		return Piecedepart.get(i);
	}
	
	public static void addletterHasard() {
		int nombre = rnd.nextInt(DictionnairePiece.getlength());
		Piecedepart.add(DictionnairePiece.getPiece(nombre));
		
		
	}
	
	public static ArrayList<String> getPiecedepart() {
		return Piecedepart;
	}
	
	public static int indexListe(String i) {
		return Piecedepart.indexOf(i);
	}
	
	public static void RemoveListe(int i) {
		Piecedepart.remove(i);
	}
	public static int getsizedepart() {
		return Piecedepart.size();
	}
	
	
	
	
	
	
	
	


}