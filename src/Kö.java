import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
	

public class Kš {

	private int _intAlder;
	private JOptionPane _errorAlder;
	private DefaultListModel _allaKunder, _listKo1, _listKo2;
	
	public Kš(DefaultListModel defAlla, DefaultListModel defKo1, DefaultListModel defKo2){
		_allaKunder = defAlla;
		_listKo1 = defKo1;
		_listKo2 = defKo2;
	}
	
	public void createPerson(String fNamn, String eNamn, String alder){
		_allaKunder.addElement(new Person(fNamn,eNamn,_intAlder));
		System.out.println("Listitem: " + _allaKunder.elementAt(0));
	}
	
	public boolean checkAlder(String alder){
		try{
			_intAlder = Integer.parseInt(alder);
			return true;
		}
		catch(Exception f){
			_errorAlder = new JOptionPane();
			JOptionPane.showMessageDialog(_errorAlder,
					"Inmatning Šr felaktig, se šver inmatningen.",
					"Inmatningsfel",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	public void moveToQueue1(Object selObj){
		_listKo1.addElement(selObj);
		_allaKunder.removeElement(selObj);
	}
	
	public void moveToQueue2(Object selObj){
		_listKo2.addElement(selObj);
		_allaKunder.removeElement(selObj);
	}
	
	public void serveQueue1(){
		try{
			_listKo1.removeElementAt(0);}
		catch(Exception e){_errorAlder = new JOptionPane();
		JOptionPane.showMessageDialog(_errorAlder,
				"Inget i kš1",
				"FEL!",
				JOptionPane.ERROR_MESSAGE);}
	}
	
	public void serveQueue2(){
		try{
			_listKo2.removeElementAt(0);}
		catch(Exception e){_errorAlder = new JOptionPane();
		JOptionPane.showMessageDialog(_errorAlder,
				"Inget i kš2",
				"FEL!",
				JOptionPane.ERROR_MESSAGE);}
	}
}
