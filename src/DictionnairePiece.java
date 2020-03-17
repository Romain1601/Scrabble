import java.util.ArrayList;
import java.util.Collections;


public class DictionnairePiece {
	
	public static ArrayList<String> listePiece = new ArrayList<String>();
	
	
	public DictionnairePiece() {
		for(int i=0;i<9;i++) {
			listePiece.add("a");
		}
		for(int i=0; i<2;i++) {
			listePiece.add("b");
			listePiece.add("c");
			listePiece.add("f");
			listePiece.add("g");
			listePiece.add("h");
			listePiece.add("p");
			listePiece.add("v");
		}
		
		for(int i=0; i<3;i++) {
			listePiece.add("d");
			listePiece.add("m");
		}
		
		for(int i=0; i<6;i++) {
			listePiece.add("r");
			listePiece.add("s");
			listePiece.add("t");
			listePiece.add("u");
			listePiece.add("n");
			listePiece.add("o");
		}
		
		for(int i=0; i<15;i++) {
			listePiece.add("e");
		}
		
		for(int i=0; i<5;i++) {
			listePiece.add("l");
		}
		
		for(int i=0; i<8;i++) {
			listePiece.add("i");
		}
		listePiece.add("j");
		listePiece.add("k");
		listePiece.add("q");
		listePiece.add("w");
		listePiece.add("x");
		listePiece.add("y");
		listePiece.add("z");
		
		Collections.sort(listePiece);
    }
	
	public static String getPiece(int i) {
		return listePiece.get(i);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DictionnairePiece();
		System.out.println(getPiece(5));
	}
	
	

}
