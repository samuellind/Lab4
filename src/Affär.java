import javax.swing.JFrame;

public class Aff�r extends JFrame {

	private JFrame _aff�r;
	private GUI _newGUI;
	
	public Aff�r(){
		super("Aff�r");
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_newGUI = new GUI();
		this.add(_newGUI);
		this.setVisible(true);
	}
	
	public static void main(String[] argv){
		new Aff�r();
	}
	
	
}
