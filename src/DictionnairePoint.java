import java.util.TreeMap;

public class DictionnairePoint {
	
	static TreeMap<String, Integer> liste = new TreeMap<>();
	
	public DictionnairePoint() {
		liste.put("a", 1);
		liste.put("b", 3);
		liste.put("c", 3);
		liste.put("d", 2);
		liste.put("e", 1);
		liste.put("f", 4);
		liste.put("g", 2);
		liste.put("h", 4);
		liste.put("i", 1);
		liste.put("j", 8);
		liste.put("k", 10);
		liste.put("l", 1);
		liste.put("m", 2);
		liste.put("n", 1);
		liste.put("o", 1);
		liste.put("p", 3);
		liste.put("q", 8);
		liste.put("r", 1);
		liste.put("s", 1);
		liste.put("t", 1);
		liste.put("u", 1);
		liste.put("v", 4);
		liste.put("w", 10);
		liste.put("x", 10);
		liste.put("y", 10);
		liste.put("z", 10);
    }
	
	
	public static int getvalue(String lettre) {
		return liste.get(lettre);
	}
	
	

	
	
}