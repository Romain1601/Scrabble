package com.sdz.vue;
import javax.swing.JButton;

public class LettreChevalet {
	
	int num;
	String name;
	JButton button;
	
	
	
	public LettreChevalet(int num, String name) {
		this.num = num;
        this.name = name;
        button = new JButton(name);
        button.setOpaque(true);
        button.setBorderPainted(true);
	}
	
	public JButton GetButton() {
        return button;
	}
	
	
	public String GetNameButton() {
        return name;
	}
	
	public int GetNumButton() {
        return num;
	}
	
	


	

	

}
