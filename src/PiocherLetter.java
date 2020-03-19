import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PiocherLetter implements ActionListener{
	
	static JPanel Valider = new JPanel();
	static JButton ValiderBouton = new JButton("Piocher");
	String mot;
	
	public PiocherLetter(String mot) {
		this.mot =mot;
		ValiderBouton.setOpaque(true);
		ValiderBouton.setBorderPainted(true);
		ValiderBouton.addActionListener(this);
		Valider.add(ValiderBouton);
	}
	
	public JPanel GetPiocher() {
		return Valider;
	}

	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == ValiderBouton){
			if(DictionnairePiece.getlength()>0 && PieceHasard.getsizedepart()<7) {
				int c=PieceHasard.getsizedepart();
				for(int i=0;i<7-c;i++) {
					PieceHasard.addletterHasard();
				}
				new Vue_piece();
				new Vue();
		}
		
		}
		
	}

}
