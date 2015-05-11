import java.io.File;


public class ListFileTest {

	public static void main(String[] args) {
		String str = "F:/workspace/practice/src/a";
		File f = new File(str);
		tree(f,1);
	}
	public static void tree(File f,int level)
	{
		String s = "";
		for(int i=0;i<level;i++)
		{
			s += "    ";
		}
		File child[] = f.listFiles();
		System.out.println(s+f.getName());
		for(int i=0;i<child.length;i++)
		{
			if(child[i].isDirectory())
			{
				tree(child[i],level+1);
			}
		}
	}

}
