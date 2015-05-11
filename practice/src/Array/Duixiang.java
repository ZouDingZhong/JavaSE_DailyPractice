package Array;

class Duixiang implements Comparable{
	private String name;
	private int number;
	public Duixiang(String name,int number)
	{
		this.name = name;
		this.number = number;
	}
    public String toString()
    {
    	return getClass().getName()+"[name="+this.name+"]"+"[number="+
                                    this.number+"]";
    }
    public int getNumber()
    {
    	return this.number;
    }
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		Duixiang com = (Duixiang)arg0;
		if (arg0 instanceof JiCheng) return -1;
		if (this.number<com.number)  return -1;
		if (this.number>com.number)  return  1;
		return 0;
	}
}
