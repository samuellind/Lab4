import javax.swing.DefaultListModel;

public class Kö<Person> {
	
	private DefaultListModel _list;
	//Pre: true
	//Post: an empty stack has been created
	public Kö(){
		super();
		_list=new DefaultListModel();
	}
	//Pre: true
	//Post: element pushed to the stack
	public void push(Person person){
		_list.add(0, person);
		System.out.println(_list.getElementAt(0));
		}
	//Pre: !isEmpty()
	//Post: the top element of the stack has been
	//removed and returned
	public Person pop(){
		return (Person)_list.remove(0);
	}
	
	//Pre: !isEmpty()
	//Post: the object has been removed from DefaultList
	public void remove(Object selObj){
		_list.removeElement(selObj);
	}
	
	public void removeAtIndex(){
		_list.removeElementAt(0);
	}

	//Pre: true
	//Post: result = true if stack is empty,
	//otherwise false
	public boolean isEmpty() {
		return _list.isEmpty();
	}
	//Pre: true
	//Post: result = the stack sequence
	public DefaultListModel getList() {
		return _list;
	}
	
}
