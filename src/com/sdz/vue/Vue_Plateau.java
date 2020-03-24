import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Vue_Plateau implements ActionListener,MouseListener {
	
	static JPanel plateau = new JPanel();
	static ButtonPlateau b[][] = new ButtonPlateau[15][15];
	static ArrayList<String> u = new ArrayList<String>();
	int c;
	static int k=1;

	
	public Vue_Plateau() {
		if(k==1) {
			new MatricePlateau();
		}
		 plateau.setLayout(new GridLayout(15,15));
	     plateau.setPreferredSize(new Dimension(700,600));
	        for(int i=0;i<15;i++) {
	        	for(int j=0;j<15;j++) {
	        		
	        		b[i][j] = new ButtonPlateau(i,j,"");
	        		if(MatricePlateau.GetMatrice()[i][j] == 9) {
	        			b[i][j].ButtonRed();
	        		}
	        		else if(MatricePlateau.GetMatrice()[i][j] == 6) {
	        			b[i][j].ButtonPink();
	        		}
	        		else if(MatricePlateau.GetMatrice()[i][j] == 3) {
	        			b[i][j].ButtonBlue();
	        		}
	        		else if(MatricePlateau.GetMatrice()[i][j] == 2) {
	        			b[i][j].ButtonCyan();
	        		}
					
	        		else {
	        			b[i][j].ButtonWhite();
	        		}
	        		if(MatricePlateau.GetMatriceModify()[j][i]==1) {
	        			b[i][j].GetButton().addMouseListener(this);
	        			if(MatricePlateau.GetMatriceEtat()[j][i] == RecupPiece.Pieceselect()) {
	        				b[i][j].setlabelButton(RecupPiece.Pieceselect());
		        			b[i][j].ButtonORANGE();
	        			}else {
	        				
	        				b[i][j].setlabelButton(MatricePlateau.GetMatriceEtat()[j][i]);
		        			b[i][j].ButtonORANGE();
	        			}
	        		}
	        		else if(MatricePlateau.GetMatriceModify()[j][i]==2) {
	        				b[i][j].GetButton().addMouseListener(this);
	        				b[i][j].setlabelButton(MatricePlateau.GetMatriceEtat()[j][i]);
		        			b[i][j].ButtonYellow();
	        			
	        		}
	        		b[i][j].GetButton().addActionListener(this);
	            	plateau.add(b[i][j].GetButton());
	        	}
	        }
	}
	
	public JPanel GetVuePlateau() {
		return plateau;
	}
	
	
	public static void updatePlateau(){
		plateau.removeAll();
		new Vue_Plateau();
		
	}


	
	public static void add(String n) {
		u.add(n);
	}
	
	public static void remove(String n) {
		u.remove(n);
	}
	
	public static boolean ifexist(String n) {
		for(int i=0; i<u.size();i++) {
			String l = u.get(i);
			if(l==n) {
				return true;
				}
			}
		
		return false;
	}
	
	public static ArrayList<String> getlist() {
		return u;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				if(source == b[i][j].GetButton()) {
					if(RecupPiece.Pieceselect()!=null && MatricePlateau.GetMatriceModify()[j][i]==0) {
						Vue_piece.removePiece(RecupPiece.Pieceselect());
						MatricePlateau.addlettre(b[i][j].GetxButton(),b[i][j].GetyButton(),RecupPiece.Pieceselect());
						updatePlateau();
						RecupPiece.changePiece(null);
						new Vue();
					}
					
					
		
					}
					
				
				}	
			}
			
		}
		
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int buttonDown = e.getButton();
		Object source = e.getSource();
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
		if(buttonDown == MouseEvent.BUTTON3 && source == b[i][j].GetButton()) {
			if(MatricePlateau.GetMatriceModify()[j][i]==1) {
				Vue_piece.add(MatricePlateau.GetMatriceEtat()[j][i]);
				MatricePlateau.removelettre(b[i][j].GetxButton(),b[i][j].GetyButton());
				updatePlateau();
				new Vue_piece();
				new Vue();
			}
			else if(MatricePlateau.GetMatriceModify()[j][i]==2) {
				remove(MatricePlateau.GetMatriceEtat()[j][i]);
				System.out.println(u);
				MatricePlateau.unselectlettre(b[i][j].GetxButton(),b[i][j].GetyButton());
				updatePlateau();
				new Vue();
				}
			
			
			
	    }
		if(buttonDown == MouseEvent.BUTTON1 && source == b[i][j].GetButton()){
			if(MatricePlateau.GetMatriceModify()[j][i]==1) {
				add(MatricePlateau.GetMatriceEtat()[j][i]);
				System.out.println(u);
				MatricePlateau.selectlettre(b[i][j].GetxButton(),b[i][j].GetyButton());
				updatePlateau();
				new Vue();
				
			}
		}
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
	
