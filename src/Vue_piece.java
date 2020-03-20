import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Vue_piece implements ActionListener {
	
	static JPanel piece = new JPanel();
	static ArrayList<ButtonPiece> b = new ArrayList<ButtonPiece>();
	static int k=1;
	static int index;
	
	public Vue_piece() {
		if(k==1) {
			new PieceHasard();
		}
		/*if(DictionnairePiece.getlength()>0) {
			PieceHasard.addletterHasard();
		}*/
		piece.setLayout(new GridLayout(1,PieceHasard.getsizedepart()));
		piece.setPreferredSize(new Dimension(500,50));
	        for(int i=0;i<PieceHasard.getsizedepart();i++) {
	        	b.add(new ButtonPiece(i,PieceHasard.getdepart(i)));
	        	b.get(i).GetButton().addActionListener(this);
            	piece.add(b.get(i).GetButton());
	        	}
	        
	      
	        }
		
	
	
	public JPanel GetVuePiece() {
		return piece;
	}
	
	public static void removeButton(String i) {
		index = PieceHasard.indexListe(i);
		b.clear();	
	}
	
	
	
	public static void clearColorSelectButton() {
		for(int i=0;i<PieceHasard.getsizedepart();i++) {
			b.get(i).GetButton().setBackground(Color.ORANGE);
		}
		
		
			
	}
	
	public static void add(String name){
		b.clear();
		PieceHasard.reprendrePiece(name);
		piece.removeAll();	
		new Vue_piece();
	}
	
	
	public static void removePiece(String name){
		b.clear();
		PieceHasard.RemoveListe(index);
		piece.removeAll();	
		k=2;
		new Vue_piece();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		for(int i=0;i<PieceHasard.getsizedepart();i++) {
			if(source == b.get(i).GetButton()) {
				clearColorSelectButton();
				RecupPiece.changePiece(b.get(i).GetNameButton());
				b.get(i).GetButton().setBackground(Color.yellow);
			}	
		}
		 
			
		
	}
	
}
