
public class Person {
	
	private String _fNamn, _eNamn;
	private int _alder;
	
	public Person(String fNamn, String eNamn, String alder){
		_fNamn = fNamn;
		_eNamn = eNamn;
		_alder = Integer.parseInt(alder);
		System.out.println("Person skapad" + _fNamn + _eNamn + alder);
	}
	
	public String getFNamn(){
		return _fNamn;
	}
	
	public String getENamn(){
		return _eNamn;
	}
	
	public int getAlder(){
		return _alder;
	}
}
