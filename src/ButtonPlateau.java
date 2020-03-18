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
