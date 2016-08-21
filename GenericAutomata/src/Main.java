
public class Main {

	public static void main(String[] args) {
		
		
		
		
		
		
		
		Automaton a1 = new Automaton();
		
		try {
			a1.setProperties();
			a1.checkInput();
		} catch (AutomatonException e) {
			e.printErrorMessage();
			//e.printStackTrace();
		}
		
		a1.isValid();
		
		
		// 101 112 203 212 302 312
	}

}
