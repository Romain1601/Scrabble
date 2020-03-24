package com.sdz.vue;


import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import com.sdz.observer.Observer;
import com.sdz.model.Model_Pioche;

public class Vue_Pioche extends JPanel implements Observer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JPanel pioche = new JPanel();
	JLabel titre = new JLabel();
	JLabel lettre = new JLabel();
	JLabel label = new JLabel();
	Model_Pioche modelPioche; 
	
	public Vue_Pioche(Model_Pioche m) {
		this.modelPioche=m;
		pioche.setBackground(Color.BLACK);
		pioche.setBounds(800,850,150,60);
		this.construireVuePioche();
	}
	
	
	public JPanel GetVuePioche() {
		return pioche;
	}
	
	public void construireVuePioche() {
		modelPioche.addObserver(this);
		titre.setText("PIOCHE :");
		lettre.setText(""+modelPioche.getLength());
		label.setText("lettres restantes");
		titre.setFont(new Font("Arial",Font.BOLD,15));
		lettre.setFont(new Font("Arial",Font.BOLD,20));
		label.setFont(new Font("Arial",Font.BOLD,15));
		titre.setForeground(Color.WHITE);
		lettre.setForeground(Color.GREEN);
		label.setForeground(Color.WHITE);
		pioche.add(titre);
		pioche.add(lettre);
		pioche.add(label);
	}
	
	
	public void update(String str) {
		pioche.removeAll();
		construireVuePioche();
		pioche.updateUI();;
		
	}

}
