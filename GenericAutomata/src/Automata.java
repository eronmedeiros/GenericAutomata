import java.util.Scanner;

public class Automata {

	private State[] states, finalStates;
	private State initialState;
	private State[][] delta;
	private Element[] elements;
	private String[] input;
	private boolean output;
	private Scanner in;
	
	// OK
	public Automata()
	{}

	// OK
	private void setElements()
	{
		int i;
		String aux;
		String[] aux2;
		
		// Creating the Array of Elements and filling it.
		System.out.print("Σ : ");
		aux = in.nextLine();
		aux2 = aux.split(" ");
		
		this.elements = new Element[aux2.length];
		
		for(i = 0; i < aux2.length; i++)
			this.elements[i] = new Element(aux2[i]);
		
	}
	
	// OK
	private void setStates()
	{
		int i, lenght;
		String str;
		// Creating the Array of States and filling it.
		System.out.print("Q : ");
		str = in.nextLine();
		lenght = Integer.parseInt(str);
		
		this.states = new State[lenght];
		
		for(i = 0; i < lenght; i++)
			this.states[i] = new State();
	}

	// OK
	private void setDelta() throws AutomataException
	{
		String aux;
		String[] aux2;
		int i, j, element, previousState, nextState;
		
		// Creating the Deltas Transition Table and filling it.
		System.out.print("δ : ");
		aux = in.nextLine();
		aux2 = aux.split(" ");
		this.delta = new State[this.states.length][this.elements.length];
		
		// After split the string and get different strings, we can organize our Delta Transition Table
		for (i = 0; i < aux2.length; i++)
		{
			previousState = aux2[i].charAt(0) - '0' - 1;
			nextState = aux2[i].charAt(2) - '0' - 1;
			
			if (previousState < 0 || previousState >= this.states.length ||
				nextState < 0 || nextState >= this.states.length)
				throw new AutomataException("Invalid State in δ. (" + previousState + ")");
			
			// find which element have aux2[i].charAt(1) like its symbol
			for (j = 0; j < this.elements.length; j++)
			{
				// Converting the character at 'i' index to a string to compare with the element symbol
				// if they are equals, so I found it and we can break the loop.
				if (this.elements[j].getSymbol().equals(Character.toString(aux2[i].charAt(1))))
					break;
			}
			// if the next if statement is true, the previous loop didn't find any element with that symbol.
			// So we should abort the process.
			if(j == this.elements.length)
				throw new AutomataException("Invalid Element Symbol in δ. (" + Character.toString(aux2[i].charAt(1)) + ")" );
			
			// if not, element will took that element value
			element = this.elements[j].getValue();
			
			delta[previousState][element] = this.states[nextState];
		}
	}
	
	// OK
	private void setInitialState() throws AutomataException
	{
		int n;
		String aux;
		String[] aux2;
		
		// Setting up Initial State.
		System.out.print("i : ");
		aux = in.nextLine();
		aux2 = aux.split(" ");
		
		if(aux2.length > 1)
			throw new AutomataException("Too many Initial States!");
		
		n = Integer.parseInt(aux2[0]) -1; // Transform String in int type
		
		if (n >= this.states.length)
			throw new AutomataException("Invalid Initial State! Its over then state array lenght.");
		
		this.states[n].setType('i');
		this.initialState = this.states[n];
	}
	
	// OK
	private void setFinalStates()
	{
		int i, n;
		String aux;
		String[] aux2;

		// Setting up Final States
		System.out.print("F : ");
		aux = in.nextLine();
		aux2 = aux.split(" ");
		
		this.finalStates = new State[aux2.length];
		
		for (i = 0; i < aux2.length; i++)
		{
			n = Integer.parseInt(aux2[i]) - 1;
			this.states[n].setType('f');
			this.finalStates[i] = this.states[n];
		}
	}
	
	// OK
	public void setProperties() throws AutomataException
	{
		System.out.println("All inputs for each line should be separated with a space.");

		this.in = new Scanner(System.in);
		setElements();
		setStates();
		setDelta();
		setInitialState();
		setFinalStates();
	}

	// OK
	public void checkInput() throws AutomataException
	{
		String aux;
		int i, j;
		State actualState;
		
		System.out.print("Input: ");
		aux = in.nextLine();
		this.in.close();
		
		this.input = aux.split("");
		
		actualState = this.initialState;
		
		for(i = 0; i < this.input.length; i++)
		{
			for(j = 0; j < this.elements.length; j++)
			{
				if (this.input[i].equals(this.elements[j].getSymbol()))
					break;
			}
			
			if(j == this.elements.length)
				throw new AutomataException("Invalid input. " + this.input[i] + " not part of the alphabet");
			
			actualState = delta[actualState.getValue()][this.elements[j].getValue()];
			
			if(actualState == null)
				throw new AutomataException("This state is invalid! Actual state is a Rejection State!");
		}
		
		if(actualState.getType() == 'f')
				this.output = true;
		
		if(!this.output)
			throw new AutomataException("Invalid Final Stage at end of process!");
	}
	
	// OK
	public boolean isValid()
	{
		return this.output;
	}
	
}

