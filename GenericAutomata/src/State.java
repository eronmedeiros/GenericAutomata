
public class State {
	
	static private int serial = 0;
	private int value;
	private char type;
	
	/*
	 * type = i = initial
	 * type = c = common
	 * type = f = final
	 */
	
	public State()
	{
		this.value = serial;
		this.type = 'c';
		State.serial++;
	}
	
	public void setType(char type)
	{
		this.type = type;
	}
	
	public char getType()
	{
		return this.type;
	}
	
	public int getValue()
	{
		return this.value;
	}
}
