package Chapter_5;

final class Student extends Person {
	
	private int score;

	public Student(String n) {
		super(n);
		this.score = 100;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printClass() {
		// TODO Auto-generated method stub
         System.out.println("the student "+super.getName()+" score "+this.score);
	}
    public void jichengTest()
    {
    	System.out.println("this is from Child");
    }
    public void addTest()
    {
    	System.out.println("addTest work!");
    }
    public String toString()
    {
    	return super.toString()+"[score="+this.score+"]";
    }
}
