import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PiocherLettre implements ActionListener{
	
	static JPanel Piocher = new JPanel();
	static JButton PiocherBouton = new JButton("Piocher");
	String mot;
	
	public PiocherLettre() {
		PiocherBouton.setOpaque(true);
		PiocherBouton.setBorderPainted(true);
		PiocherBouton.addActionListener(this);
		Piocher.add(PiocherBouton);
	}
	
	public JPanel GetPiocher() {
		return Piocher;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == PiocherBouton){
			if(Valider_mot.booleanvalider()==true) {
				Valider_mot.changeEtatValider(false);
				if(DictionnairePiece.getlength()>0 && PieceHasard.getsizedepart()<7){
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

}
