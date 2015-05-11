package Array;

final class JiCheng extends Duixiang implements Comparable {

	private int shuzi;
	public JiCheng(String name, int number) {
		super(name, number);
		shuzi = 100;
		// TODO Auto-generated constructor stub
	}
	public String toString()
	{
		return super.toString()+"[shuzi"+shuzi+"]";
	}

//	public int compareTo(Object otherObject)
//	{
//		if(otherObject instanceof JiCheng) 
//		{
//			JiCheng e = (JiCheng)otherObject;
//			if (this.getNumber()<e.getNumber()) return -1;
//		}
//	}
}
