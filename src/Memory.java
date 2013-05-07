import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
	

public class Memory {

	private int _intAlder;
	private boolean _checkAlder=false;
	private JOptionPane _errorAlder;
	private Person _newPerson;
	private DefaultListModel _allaKunder, _listKo1, _listKo2;
	
	public Memory(){
		_allaKunder = new DefaultListModel();
		_listKo1 = new DefaultListModel();
		_listKo2 = new DefaultListModel();
	}
	
	public void createPerson(String fNamn, String eNamn, String alder){
		_allaKunder.addElement(new Person(fNamn,eNamn,_intAlder));
		_newPerson = (Person)_allaKunder.elementAt(0);
		//_newPerson = new Person(fNamn,eNamn,_intAlder);
	}
	
	public boolean checkAlder(String alder){
		try{
			_intAlder = Integer.parseInt(alder);
			_checkAlder=true;
			return true;
		}
		catch(NumberFormatException e){
			_errorAlder = new JOptionPane();
			JOptionPane.showMessageDialog(_errorAlder,
					"Ålder måste vara i siffror.",
					"Inmatningsfel",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
}
