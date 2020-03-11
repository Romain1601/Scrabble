import java.awt.Color; 
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Vue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame fenetre = new JFrame();            
		fenetre.setTitle("Ma première fenêtre Java");
		fenetre.setSize(400, 400);
		fenetre.setLocationRelativeTo(null);               

		//Instanciation d'un objet JPanel
		JPanel pan = new JPanel();
		//Définition de sa couleur de fond
		pan.setBackground(Color.ORANGE);        
		//On prévient notre JFrame que notre JPanel sera son content pane
		fenetre.setContentPane(pan);               
		fenetre.setVisible(true);
	}     

};
