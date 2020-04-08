package com.sdz.vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import com.sdz.model.Model_Message;
import com.sdz.observer.Observer;

public class Vue_Message implements Observer {

	Model_Message message;
	ArrayList<String> error;
	ArrayList<String> success;
	JPanel PanelMessage = new JPanel();
	Color ColorSuccess = new Color(23, 102, 38);
	Color ColorError = new Color(193, 4, 4);
	GridBagConstraints gbc = new GridBagConstraints();
	
	public Vue_Message(Model_Message m) {
		this.message=m;
		message.addObserver(this);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		PanelMessage.setBounds(712,300,250,370);
		PanelMessage.setBorder(blackline);
		construireVueMessage();
	}
	
	
	
	public void construireVueMessage() {
		if(message.getListError().size()>0) {
			for(int i=0;i< message.getListError().size();i++) {
				JTextArea r = new JTextArea();
				r.setLineWrap(true);
				r.setWrapStyleWord(true);
				r.setBackground(null);
				r.setBounds(712, 300, 220, 30);
				r.setText("- " +message.getListError().get(i));
				r.setFont(new Font("Arial",Font.BOLD,17));
				r.setForeground(ColorError);
				PanelMessage.add(r, gbc);
			}
		}
		if(message.getListSuccess().size()>0) {
			for(int i=0;i< message.getListSuccess().size();i++) {
				JTextArea r = new JTextArea();
				r.setLineWrap(true);
				r.setWrapStyleWord(true);
				r.setBackground(null);
				r.setBounds(712, 300, 220, 30);
				r.setText("- " + message.getListSuccess().get(i));
				r.setFont(new Font("Arial",Font.BOLD,17));
				r.setForeground(ColorSuccess);
				PanelMessage.add(r, gbc);
			}
		}
	
	}
	
	public JPanel GetPanelMessage() {
		return PanelMessage;
	}
	
	
	
	
	
	
	
	
	
	@Override
	public void update(String str) {
		// TODO Auto-generated method stub
		PanelMessage.removeAll();
		construireVueMessage();
		PanelMessage.updateUI();
		
		
	}

}
