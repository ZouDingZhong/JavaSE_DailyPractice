package Chapter_5;

final class StudentTest extends Person_2Test {

	private int score = 1000;
	public StudentTest(String n) {
		super(n);
		this.score=100000;
		// TODO Auto-generated constructor stub
	}
    public String toString()
    {
    	return super.toString()+"[score"+score+"]";
    }
}
