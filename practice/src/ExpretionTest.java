import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ExpretionTest {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("java",Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher("java Java jAVA IloveJava javaissoeasy 2333333");
		StringBuffer buf  = new StringBuffer();
		int i = 0;
		while(m.find())
		{
			if(i%2==0) m.appendReplacement(buf, "JAVA");
			else       m.appendReplacement(buf, "java");
			i++;
		}
		System.out.println(buf);
	}

}
