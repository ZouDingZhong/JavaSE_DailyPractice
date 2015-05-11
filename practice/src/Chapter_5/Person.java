package Chapter_5;

abstract class Person {
	private String name;
	
	public Person(String n)
	{
		this.name = n;
	}
    abstract public void printClass();
    public String getName()
    {
    	return this.name;
    }
    public void jichengTest()
    {
    	System.out.println("this is from Super");
    }
    public String toString()
    {
    	return getClass().getName()+
    			"[name="+this.name+"]";
    }
}
