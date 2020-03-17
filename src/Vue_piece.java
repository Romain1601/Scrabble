import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Vue_piece {
	
	static JPanel piece = new JPanel();
	PieceHasard liste = new PieceHasard();
	String h[] = liste.tirage();

	
	public Vue_piece() {
		
		
		 piece.setLayout(new GridLayout(1,7));
		 piece.setPreferredSize(new Dimension(350,40));
	        
	        for(int i=0;i<7;i++) {
	        	JButton button = new JButton(h[i]);
	        	button.setBackground(Color.orange);
            	button.setOpaque(true);
            	button.setBorderPainted(true);
            	piece.add(button);
	        	}
	        }

	
	public JPanel GetVuePiece() {
		return piece;
	}

}
