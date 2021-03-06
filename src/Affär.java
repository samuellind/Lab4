import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
	

public class Affär {

	private int _intAlder;
	private JOptionPane _errorAlder;
	private Kö _allaKunder, _listKo1, _listKo2;
	
	//Pre: defAlla/defKo1/defKo2 != null
	//Post: tre listor har tagits emot
	public Affär(Kö defAlla, Kö defKo1, Kö defKo2){
		_allaKunder = defAlla;
		_listKo1 = defKo1;
		_listKo2 = defKo2;
	}
	
	//Pre: alder = string
	//Post: personen har lagts till i listan
	public void createPerson(String fNamn, String eNamn, String alder){
		_allaKunder.push(new Person(fNamn,eNamn,_intAlder));
		//System.out.println("Listitem: " + _allaKunder.elementAt(0));
	}
	
	//Pre: true
	//Post: kollar om alder är en string, tolkar det som en int och returnera true
	// om inte så för man ett felmedelande och false returneras
	public boolean checkAlder(String alder){
		try{
			_intAlder = Integer.parseInt(alder);
			return true;
		}
		catch(Exception f){
			_errorAlder = new JOptionPane();
			JOptionPane.showMessageDialog(_errorAlder,
					"Inmatning �r felaktig, se �ver inmatningen.",
					"Inmatningsfel",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	//Pre: det finns ett markerat objekt
	//Post: det markerade obektet flyttas till ko1
	public void moveToQueue1(Object selObj){
		_listKo1.push(selObj);
		_allaKunder.remove(selObj);
	}
	
	//Pre: det finns ett markerat objekt
	//Post: det markerade obektet flyttas till ko2
	public void moveToQueue2(Object selObj){
		_listKo2.push(selObj);
		_allaKunder.remove(selObj);
	}
	
	//Pre: true
	//Post: tar bort objektet på första platsen i _listKo1
	//om det inte finns något får man ett felmeddelande
	public void serveQueue1(Object selObj){
		try{
			_listKo1.removeAtIndex();}
		catch(Exception e){_errorAlder = new JOptionPane();
		JOptionPane.showMessageDialog(_errorAlder,
				"Inget i k�1",
				"FEL!",
				JOptionPane.ERROR_MESSAGE);}
	}
	
	//Pre: true
	//Post: tar bort objektet på första platsen i _listKo2
	//om det inte finns något får man ett felmeddelande
	public void serveQueue2(Object selObj){
		try{
			_listKo2.removeAtIndex();}
		catch(Exception e){_errorAlder = new JOptionPane();
		JOptionPane.showMessageDialog(_errorAlder,
				"Inget i k�2",
				"FEL!",
				JOptionPane.ERROR_MESSAGE);}
	}
}
