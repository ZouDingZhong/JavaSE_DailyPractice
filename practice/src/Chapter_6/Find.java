package Chapter_6;

class Find {
	static class Fair
	{
		public int max;
		public int min;
		public Fair(int max,int min)
		{
			this.max=max;
			this.min=min;
		}
		public int getMin()
		{
			return min;
		}
		public int getMax()
		{
			return max;
		}
	}
	public static Fair findMaxMin(int[] a)
	{
		int amax;
		int amin;
		amax=amin=a[0];
		for(int i=0;i<a.length;i++)
		{
			if(a[i]>amax) amax=a[i];
			if(a[i]<amin) amin=a[i];
		}
		Fair e = new Fair(amax,amin);
		return e;
	}

}
