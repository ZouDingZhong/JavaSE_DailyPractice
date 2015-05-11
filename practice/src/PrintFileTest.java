import java.io.*;
public class PrintFileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     String file = args[0];
     if(file!=null) list(file,System.out);		
	}
	public  static void list(String s ,PrintStream p)
	{
		try {
			FileReader fr = new FileReader(s);
			BufferedReader br = new BufferedReader(fr);
			String str ;
			try {
				for(str=br.readLine();str!=null;)
				{
					p.println(str);
					str=br.readLine();
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
