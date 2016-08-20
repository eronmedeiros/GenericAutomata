
@SuppressWarnings("serial")
public class AutomatonException extends Exception {
	
	private String errorMessage;
	
	public AutomatonException(String s)
	{
		this.errorMessage = s;
	}
	
	public void printErrorMessage()
	{
		System.out.println(this.errorMessage);
	}

}
