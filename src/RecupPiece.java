
public class RecupPiece {
	
	static String valeur;
	
	RecupPiece(String v){
		RecupPiece.valeur = v;
	}
	
	public static void changePiece(String v) {
		valeur=v;
	}
	
	public static String Pieceselect() {
		return valeur;
	}
}
