
public class Person {
	
	private String _fNamn, _eNamn;
	private int _alder;
	
	//Pre: true
	//Post: en ny person har skapats
	public Person(String fNamn, String eNamn, int alder){
		_fNamn = fNamn;
		_eNamn = eNamn;
		_alder = alder;
		//System.out.println("Person skapad" + _fNamn + _eNamn + _alder);
	}
	
	//Pre: Person är ett objekt
	//Post: Person-objektet har omvandlats till string, returneras som string
	public String toString(){
				String person=(_fNamn + " " + _eNamn + " " + _alder);
				return person;
		 	}
}
