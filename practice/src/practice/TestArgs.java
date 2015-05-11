package practice;
import java.util.*;
class TestArgs {

	private final static Integer one = new Integer(1);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
		Map a =new HashMap();
		for(int i=0;i<args.length;i++)
		{
			Integer f = (Integer)a.get(args[i]);
			a.put(args[i],f==null?one:new Integer(f+1));
		}
		System.out.println(a.size()+"字符出现的次数是"+a);
	}

}
