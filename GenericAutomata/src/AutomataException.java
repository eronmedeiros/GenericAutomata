
@SuppressWarnings("serial")
public class AutomataException extends Exception {
	
	private String errorMessage;
	
	public AutomataException(String s)
	{
		this.errorMessage = s;
	}
	
	public void printErrorMessage()
	{
		System.out.println(this.errorMessage);
	}

}
