import java.awt.Color;
import javax.swing.JButton;


public class ButtonPlateau {
	
	int x;
	int y;
	String name;
	JButton button;

	public ButtonPlateau(int x, int y, String name) {
		this.x = x;
		this.y = y;
        this.name = name;
        button = new JButton(name);
        button.setOpaque(true);
        button.setBorderPainted(true);
	}
	
	public void ButtonRed() {
		button.setBackground(Color.RED);
	}
	
	public void ButtonPink() {
		button.setBackground(Color.PINK);
	}
	
	public void ButtonBlue() {
		button.setBackground(Color.BLUE);
	}
	
	public void ButtonCyan() {
		button.setBackground(Color.CYAN);
	}
	
	public void ButtonGreen() {
		button.setBackground(Color.GREEN);
	}
	
	public void ButtonORANGE() {
		button.setBackground(Color.ORANGE);
	}
	
	public void setlabelButton(String i) {
		button.setText(i);
	}
	
	
	
	public JButton GetButton() {
        return button;
	}
	
	
	public int GetxButton() {
        return x;
	}
	
	public int GetyButton() {
        return y;
	}
	
	public String GetNameButton() {
        return name;
	}

}
