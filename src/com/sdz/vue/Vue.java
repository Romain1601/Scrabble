import java.awt.FlowLayout;
import javax.swing.JFrame;



public class Vue extends JFrame    {
	private static final long serialVersionUID = 1L;
	
	static Vue_Plateau plateau = new Vue_Plateau();
	static PiocherLettre Piocher = new PiocherLettre();
	static Valider_mot Valider = new Valider_mot();
	static Vue_piece piece = new Vue_piece();
	static Menu_start menu = new Menu_start();
	static JFrame fenetre = new JFrame(); 
	
	public Vue() {
		plateau.GetVuePlateau();       
		fenetre.setTitle("Scrabble");
		fenetre.setSize(800, 1000);
		fenetre.setLocationRelativeTo(null); 
        fenetre.setResizable(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setLayout(new FlowLayout());
        fenetre.setVisible(true);    
    }
	
	
	public static void menu() {
		fenetre.add(menu.GetMenu());
	}
	
	public static void removeMenu() {
		fenetre.remove(menu.GetMenu());
	}
	
	public static void jeu() {
		fenetre.add(plateau.GetVuePlateau());
        fenetre.add(piece.GetVuePiece());
	}
	
	public static void addButtonPiocher() {
		fenetre.add(Piocher.GetPiocher());  
	}
	
	public static void addButtonValider() {
		fenetre.add(Valider.Getvalider());  
	}

	
    public static void main(String[] args) {
    	menu();
        new Vue();
       
       
   }





	

	
	
	
	
	
	
	

};