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
		piece.setLayout(new GridLayout(1,PieceHasard.getsizedepart()));
		piece.setPreferredSize(new Dimension(350,40));
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
		b.remove(index);
		
			
	}
	
	
	public static void removePiece(String name){
		removeButton(name);
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
				RecupPiece.changePiece(b.get(i).GetNameButton());
			}	
		}
		 
			
		
	}
	
}
