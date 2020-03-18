



import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPiece {
	
	int num;
	String name;
	JButton button;
	JPanel r;
	
	
	
	public ButtonPiece(int num, String name) {
		this.num = num;
        this.name = name;
        button = new JButton(name);
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
