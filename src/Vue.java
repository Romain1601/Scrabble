import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Vue extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel plateau= new JPanel();
	JPanel dashboard= new JPanel();
	
	public Vue() {
    	
    	new MatricePlateau();
    	int g[][] = MatricePlateau.GetMatrice();
 
    	JFrame fenetre = new JFrame();            
		fenetre.setTitle("Scrabble");
		fenetre.setSize(600, 600);
		fenetre.setLocationRelativeTo(null); 
        fenetre.setResizable(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setLayout(new FlowLayout());
        fenetre.add(plateau);
        
        
       
        plateau.setLayout(new GridLayout(15,15));
        plateau.setPreferredSize(new Dimension(400,400));
        
        for(int i=0;i<15;i++) {
        	for(int j=0;j<15;j++) {
        		JButton button = new JButton();
        		if(g[i][j] == 9) {
        			button.setBackground(Color.red);
        		}
        		else if(g[i][j] == 6) {
        			button.setBackground(Color.pink);
        		}
        		else if(g[i][j] == 3) {
        			button.setBackground(Color.blue);
        		}
        		else if(g[i][j] == 2) {
        			button.setBackground(Color.cyan);
        		}
        		else {
        			button.setBackground(Color.green);
        		}
            	button.setOpaque(true);
            	button.setBorderPainted(true);
            	plateau.add(button);
        	}
        	
        	
        	
        }
        fenetre.setVisible(true); 
    }
     
    public static void main(String[] args) {
    
        new Vue();
   }

	
	
	
	
	
	

};
