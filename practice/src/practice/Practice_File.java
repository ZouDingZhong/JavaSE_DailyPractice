package practice;

import java.io.File;
import java.io.IOException;

import javax.imageio.IIOException;

class Practice_File {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//       String mydirectory = "test1"+"/test2";
//       String filename = "test.txt";
//       File f = new File(mydirectory,filename);
//       f.getParentFile().mkdirs(); 
//       try
//       {
//    	f.createNewFile();  
//       }
//       catch(IOException e)
//       {
//    	e.printStackTrace();   
//       }
		String s = "C:/Users/USER/workspace/practice/src/practice";
		File first = new File(s);
		showFile(first,0);
		
	}
	static void showFile(File f,int level)
	{
		if(f.exists())
		{
			File [] a =f.listFiles();
			String p = "  ";
			for(int i=0;i<level;i++)
			{
				p += "    ";
			}
		    for(int i=0;i<a.length;i++)
		    {
		    	System.out.println(p+a[i].getName());
		    	if(a[i].isDirectory())
		    	showFile(a[i],level+1);
		    }
			return;
		}
	}

}
