import javax.swing.JFrame;

public class Main extends JFrame {

	private GUI _newGUI;
	
	//Pre: true
	//Post: en ny affär har skapats
	public Main(){
		super("Affär");
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_newGUI = new GUI();
		this.add(_newGUI);
		this.setVisible(true);
	}
	
	public static void main(String[] argv){
		new Main();
	}
	
	
}
