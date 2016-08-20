
public class Main {

	public static void main(String[] args) {
		
		Automaton a1 = new Automaton();
		
		a1.setProperties2();
		
		try {
			a1.input();
			a1.calculate();
		} catch (AutomatonException e) {
			e.printErrorMessage();
			//e.printStackTrace();
		}
		
		a1.isValid();
		
	}

}
