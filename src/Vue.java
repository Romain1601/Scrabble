import java.awt.FlowLayout;
import javax.swing.JFrame;


public class Vue extends JFrame {
	private static final long serialVersionUID = 1L;
	
	Vue_Plateau plateau = new Vue_Plateau();
	Vue_piece piece = new Vue_piece();
	
	
	public Vue() {
		
		
		plateau.GetVuePlateau();
		JFrame fenetre = new JFrame();            
		fenetre.setTitle("Scrabble");
		fenetre.setSize(600, 600);
		fenetre.setLocationRelativeTo(null); 
        fenetre.setResizable(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setLayout(new FlowLayout());
        fenetre.add(plateau.GetVuePlateau());
        fenetre.add(piece.GetVuePiece());
        fenetre.setVisible(true); 
    }
     
    public static void main(String[] args) {
    
        new Vue();
   }

	
	
	
	
	
	

};
