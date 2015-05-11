package Chapter_4;

import java.util.Random;

class Employee {
	private String name;
	private double salary;
	private int ID;
	private static int IDset;
	
		static
	{
	    Random generator = new Random();
		IDset = generator.nextInt(1000);
		System.out.println("use morenchengxukuai");
	}
	{
		this.ID =IDset;
		IDset++;
		System.out.println("use chengxukuai");
	}

	public Employee(String name,double salary)
	{
		this.name=name;
		this.salary=salary;
		System.out.println("construction way 1");
	}
	public Employee()
	{
		this("dafulte name",0);
		System.out.println("construction way 2");		
	}
	
	public double getSalary()
	{
		return this.salary;
	}
	public String getName()
	{
		return this.name;
	}
	public void addSalary(double n)
	{
		this.salary+=(1+n)*this.salary;
	}
	public void printEmloyee()
	{
		System.out.println(this.name+"\t"+this.salary+"\t"+this.ID);
	}
    public static void main()
    {
    	System.out.println("Unit Test Succeed!");
    }
}

