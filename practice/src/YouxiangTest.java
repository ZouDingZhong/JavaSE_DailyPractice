import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class YouxiangTest {

	public static void main(String[] args) throws IOException {
		File f = new File("C:/Users/USER/Desktop/youxiang.html");
		FileReader fr = new FileReader(f);
		BufferedReader dr = new BufferedReader(fr);
		Pattern p = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+");
//		Matcher m ;
		String s="";
//		Matcher m = p.matcher(s);
		while((s=dr.readLine())!=null)
		{
//			s = dr.readLine();
//			System.out.println(s);
			Matcher	m = p.matcher(s);
			while(m.find())
			{
				System.out.println(m.group());
			}
		}
	}

}
