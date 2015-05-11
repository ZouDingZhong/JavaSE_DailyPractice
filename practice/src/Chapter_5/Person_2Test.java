package Chapter_5;

class Person_2Test {

private String name;
	
	public Person_2Test(String n)
	{
		this.name = n;
	}
    
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
