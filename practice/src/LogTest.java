import java.io.*;
import java.util.*;
public class LogTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			String s ;
			FileWriter fr = new FileWriter("test.log",true);
			PrintWriter bw = new PrintWriter(fr);
			for(s=br.readLine();s!=null;)
			{
				if(s.equalsIgnoreCase("exit")) break;
				bw.println(s.toUpperCase());
				bw.println("--------------");                
				s=br.readLine();
			}
			bw.write("====="+new Date()+"=====");
			bw.println();
			bw.flush();
			bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
