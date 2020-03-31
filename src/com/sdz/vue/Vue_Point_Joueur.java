package com.sdz.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sdz.model.ListeJoueurs;
import com.sdz.observer.Observer;

public class Vue_Point_Joueur implements Observer{

	ListeJoueurs lj;
	public JPanel panelPoint = new JPanel();
	public JPanel paneltitrePoint = new JPanel();
	public JPanel GridPoint = new JPanel();
	public JPanel OnePoint;
	JLabel titre = new JLabel("POINTS");
	JLabel Nom;
	JLabel point;
	
	Vue_Point_Joueur(ListeJoueurs l){
		this.lj = l;
		panelPoint.setBackground(Color.BLACK);
		panelPoint.setBounds(712,20,250,250);
		lj.addObserver(this);
		BuildVueJoueur();
	}
	
	
	public JPanel getVuePoint() {
		return panelPoint;	
	}
	
	
	
	
	
	public void BuildVueJoueur() {
		titre.setFont(new Font("Arial",Font.BOLD,20));
		titre.setForeground(Color.WHITE);
		paneltitrePoint.setBackground(Color.BLACK);
		paneltitrePoint.setPreferredSize( new Dimension(250,40));
		paneltitrePoint.add(titre);
		int c = lj.getListeJoueur().size();
		if(c==1) {
			GridPoint.setLayout(new GridLayout(1,1));
		}
		else if(c==2) {
			GridPoint.setLayout(new GridLayout(1,2));
		}
		else {
			GridPoint.setLayout(new GridLayout(2,2));
		}
		
		GridPoint.setBackground(Color.BLACK);
		GridPoint.setPreferredSize( new Dimension(240,170));
		for(int i =0; i<lj.getListeJoueur().size();i++) {
			OnePoint = new JPanel();
			OnePoint.setLayout(new GridLayout(2,1));
			OnePoint.setBackground(Color.BLACK);
			Nom = new JLabel(lj.getListeJoueur().get(i).getNameJoueur());
			point = new JLabel(String.valueOf(lj.getListeJoueur().get(i).getPointJoueur()));
			Nom.setForeground(Color.WHITE);
			Nom.setFont(new Font("Arial",Font.BOLD,16));
			Nom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			point.setForeground(Color.GREEN);
			point.setFont(new Font("Arial",Font.BOLD,20));
			point.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
			OnePoint.add(Nom);
			OnePoint.add(point);
			GridPoint.add(OnePoint);
		}
		panelPoint.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
		panelPoint.add(paneltitrePoint);
		panelPoint.add(GridPoint);
	}
	

	
	
	
	@Override
	public void update(String str) {
		panelPoint.removeAll();
		paneltitrePoint.removeAll();
		GridPoint.removeAll();
		BuildVueJoueur();
		panelPoint.updateUI();
		paneltitrePoint.updateUI();
		GridPoint.updateUI();
		
	}

	

}
