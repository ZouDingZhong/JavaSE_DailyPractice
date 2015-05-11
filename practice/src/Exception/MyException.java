package Exception;

class MyException extends Exception {

	private int ID ;
	public MyException()
	{
		super();
		ID = 101;
	}
	public MyException(String message,int ID)
	{
		super(message);
		this.ID = ID;
	}
	public String toString()
	{
		return "Err "+ID;
	}
	public int getID()
	{
		return ID;
	}
}
