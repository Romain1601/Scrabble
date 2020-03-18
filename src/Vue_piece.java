import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class Vue_piece implements ActionListener {
	
	static JPanel piece = new JPanel();
	PieceHasard liste = new PieceHasard();
	String h[] = liste.tirage();
	static ButtonPiece b[] = new ButtonPiece[7];
	
	
	public Vue_piece() {
		
		 piece.setLayout(new GridLayout(1,7));
		 piece.setPreferredSize(new Dimension(350,40));
	        for(int i=0;i<7;i++) {
	        	b[i] = new ButtonPiece(i,h[i]);
	        	b[i].GetButton().setBackground(Color.orange);
	        	b[i].GetButton().setOpaque(true);
	        	b[i].GetButton().setBorderPainted(true);
	        	b[i].GetButton().addActionListener(this);
            	piece.add(b[i].GetButton());
	        	}
	        }
	
	public JPanel GetVuePiece() {
		return piece;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		for(int i=0;i<7;i++) {
			if(source == b[i].GetButton()) {
				System.out.println(b[i].GetNameButton());
			}	
		}
		 
			
		
	}
	
}
