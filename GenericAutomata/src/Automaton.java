import java.util.Scanner;

public class Automaton {

	private State[] states, finalStates;
	private State initialState;
	private State[][] delta;
	private Element[] elements;
	private String[] input;
	private boolean output;
	
	public Automaton()
	{}
	
	private void setElements()
	{
		int i;
		String aux;
		String[] aux2;
		Scanner input = new Scanner(System.in);
		
		// Creating the Array of Elements and filling it.
		System.out.print("Σ : ");
		aux = input.nextLine();
		aux2 = aux.split(" ");
		
		this.elements = new Element[aux2.length];
		
		for(i = 0; i < aux2.length; i++)
			this.elements[i] = new Element(aux2[i]);
		
		input.close();
	}
	
	private void setStates()
	{
		int i;
		int lenght;
		Scanner input = new Scanner(System.in);
		
		// Creating the Array of States and filling it.
		System.out.print("Q : ");
		lenght = input.nextInt();
		input.nextLine();
		
		this.states = new State[lenght];
		
		for(i = 0; i < lenght; i++)
			this.states[i] = new State();
		
		input.close();
	}

	private void setDelta() throws AutomatonException
	{
		String aux;
		String[] aux2;
		int i, j, element, previousState, nextState;
		
		Scanner input = new Scanner(System.in);
		
		// Creating the Deltas Transition Table and filling it.
		System.out.print("δ : ");
		aux = input.nextLine();
		aux2 = aux.split(" ");
		
		// After split the string and get different strings, we can organize our Delta Transition Table
		for (i = 0; i < aux2.length; i++)
		{
			previousState = aux2[i].charAt(0) - '0';
			// find which element have aux2[i].charAt(0) like its symbol
			for (j = 0; j < this.elements.length; j++)
			{
				// Converting the character at 'i' index to a string to compare with the element symbol
				// if they are equals, so I found it and we can break the loop.
				if (this.elements[j].getSymbol() == Character.toString(aux2[i].charAt(1)))
					break;
			}
			// if the next if statement is true, the previous loop didn't find any element with that symbol.
			// So we should abort the process.
			if(j == this.elements.length)
				throw new AutomatonException("Invalid Element Symbol.");
			
			// if not, element will took that element value
			element = this.elements[j].getValue();
			
			// find which state have aux2[i].charAt(0) like its value
			nextState = aux2[i].charAt(2) - '0';
			
			if(nextState >= this.states.length)
				throw new AutomatonException("Invalid Next State in δ.");
			
			delta[previousState][element] = this.states[nextState];
		}
		
		input.close();
	}
	
	private void setInitialState() throws AutomatonException
	{

		int i;
		String aux;
		String[] aux2;
		Scanner input = new Scanner(System.in);
		
		// Setting up Initial State.
		System.out.print("i : ");
		aux = input.nextLine();
		aux2 = aux.split(" ");
		
		if(aux2.length > 1)
			throw new AutomatonException("Too many Initial States!");
		
		for (i = 0; i < this.states.length; i++)
		{
			if ((aux2[0].charAt(0) - '0') == this.states[i].getValue())
			{
				this.states[i].setType('i');
				break;
			}
		}
		
		if(i == this.states.length)
			throw new AutomatonException("Invalid Initial State!");
		
		this.initialState = this.states[i];
		
		input.close();
	}
	
	private void setFinalStates()
	{
		int i;
		String aux;
		String[] aux2;
		Scanner input = new Scanner(System.in);

		// Setting up Final States
		System.out.print("F : ");
		aux = input.nextLine();
		aux2 = aux.split(" ");
		
		for (i = 0; i < aux2.length; i++)
		{
			if ((aux2[0].charAt(0) - '0') == this.states[i].getValue())
			{
				this.states[i].setType('f');
			}
		}
		
		input.close();
	}
	
	public void setProperties() throws AutomatonException
	{
		System.out.println("All inputs for each line should be separated with a space.");
		
		setElements();
		setStates();
		setDelta();
		setInitialState();
		setFinalStates();
		
	}
	
	public void setProperties2()
	{
		this.elements[0] = new Element("0");
		this.elements[1] = new Element("1");
		
		this.states[0] = new State();
		this.states[1] = new State();
		this.states[2] = new State();
		
		this.delta[0] = "101";
		this.delta[1] = "112";
		this.delta[2] = "203";
		this.delta[3] = "212";
		this.delta[4] = "302";
		this.delta[5] = "312";
		
		this.initialState = this.states[1];
		
		this.finalStates[0] = this.states[1];
		this.finalStates[1] = this.states[2];
		
		this.output = true;
	}

	public void input() throws AutomatonException
	{
		String aux;
		int i, j;
		boolean ok;
		
		Scanner in = new Scanner(System.in);
		aux = in.nextLine();
		in.close();
		
		this.input = aux.split("");
		
		for(i = 0; i < this.input.length; i++)
		{
			ok = false;
			for(j = 0; j < this.elements.length; j++)
			{
				if (this.input[i] == this.elements[j])
					ok = true; // part of the alphabet
			}
			if(!ok)
			{
				throw new AutomatonException("Invalid input. " + this.input[i] + "not part of the alphabet");
			}
		}
		
	}

	public void calculate()
	{
		
		
	}
	
	public boolean isValid()
	{
		return this.output;
	}
	
}

