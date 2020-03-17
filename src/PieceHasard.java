import java.util.Arrays;
import java.util.Random;

public class PieceHasard extends DictionnairePiece  {
	
	DictionnairePiece  dico = new DictionnairePiece();
	static String[] Piecedepart = new String[7];
	Random rnd = new Random();
	
	
	public PieceHasard() {
		for(int i=0;i<Piecedepart.length;i++) {
			int nombre = rnd.nextInt(109);
			Piecedepart[i] = DictionnairePiece.getPiece(nombre);
		}
	}
	
	public static String tirage() {
		return Arrays.toString(Piecedepart);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PieceHasard();
		System.out.println(tirage());	
	}

}
