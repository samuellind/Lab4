
public class Person {
	
	private String _fNamn, _eNamn;
	private int _alder;
	
	public Person(String fNamn, String eNamn, int alder){
		_fNamn = fNamn;
		_eNamn = eNamn;
		_alder = alder;
		System.out.println("Person skapad" + _fNamn + _eNamn + _alder);
	}
	
	public String toString(){
				String person=(_fNamn + " " + _eNamn + " " + _alder);
				//System.out.print(person);
				return person;
		 	}
}
