
public class Main {

	public static void main(String[] args) {
		
		Automata a1 = new Automata();
		
		try {
			a1.setProperties();
			a1.checkInput();
		} catch (AutomataException e) {
			e.printErrorMessage();
			//e.printStackTrace();
		}

		System.out.println(a1.isValid());
		
		// teste: 101 112 203 212 302 312
	}

}
