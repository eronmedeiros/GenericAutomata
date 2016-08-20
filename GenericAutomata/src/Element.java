
public class Element {
	
	static private int serial = 0;
	private int value;
	private String symbol;
	
	public Element(String symbol)
	{
		this.value = serial;
		this.symbol = symbol;
		Element.serial++;
	}
	
	public String getSymbol()
	{
		return this.symbol;
	}
	
	public int getValue()
	{
		return this.value;
	}
	
}
