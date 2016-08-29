
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

		System.out.println("Automata can exist? " + a1.isValid());
			
		/*
		 *  Testes:
		 *  
		 *  Slide:
		 *  Σ : 0 1
		 *  Q : 3
		 *  δ : 101 112 203 212 302 312
		 *  i : 1
		 *  F : 2 3
		 *  
		 *  Numeros binários impares:
		 *  
		 *  Σ : 0 1
		 *  Q : 2
		 *  δ : 101 112 201 212
		 *  i : 1
		 *  F : 2
		 *    
		 *  Numeros Inteiros:
		 *  
		 *  Σ : + - 0 1 2 3 4 5 6 7 8 9
		 *  Q : 3
		 *  δ : 1+2 1-2 103 113 123 133 143 153 163 173 183 193 203 213 223 233 243 253 263 273 283 293 303 313 323 333 343 353 363 373 383 393
		 *  i : 1
		 *  F : 3
		 *  
		 *  Numeros Naturais:
		 *  
		 *  Σ : + 0 1 2 3 4 5 6 7 8 9
		 *  Q : 3
		 *  δ : 1+2 103 113 123 133 143 153 163 173 183 193 203 213 223 233 243 253 263 273 283 293 303 313 323 333 343 353 363 373 383 393
		 *  i : 1
		 *  F : 3
		 *  
		 */
	}

}
