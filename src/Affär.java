import javax.swing.JFrame;

public class Affär extends JFrame {

	private GUI _newGUI;
	
	public Affär(){
		super("Affär");
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_newGUI = new GUI();
		this.add(_newGUI);
		this.setVisible(true);
	}
	
	public static void main(String[] argv){
		new Affär();
	}
	
	
}
