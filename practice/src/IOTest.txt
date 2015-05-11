import java.io.*;
public class IOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		FileInputStream in =null;
		FileOutputStream out = null;
		File l = new File("C:/Users/USER/workspace/practice/src/IOTest.java");
		try {
		 in = new FileInputStream(l);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 out = new FileOutputStream("C:/Users/USER/workspace/practice/src/IOTest.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int a;
		
		try {
			while((a=in.read())!=-1)
			{
				out.write(a);
				
			}
			System.out.println("succeed!≥…π¶¡À£°");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
