
import java.awt.Color;
import javax.swing.JButton;

public class ButtonPiece {
	
	int num;
	String name;
	JButton button;
	
	
	
	public ButtonPiece(int num, String name) {
		this.num = num;
        this.name = name;
        button = new JButton(name);
        button.setBackground(Color.orange);
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
