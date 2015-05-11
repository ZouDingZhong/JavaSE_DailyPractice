import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

//import com.zoudingzhon.tankwar.PropertyMgr;


public class StatLines {
	
	static int normalLines = 0;
	static int whiteLines = 0;
	static int commentLines = 0;	
	static List<File> fileList = new LinkedList<File>();
	public static void main(String[] args) throws IOException {
		String zb = null;
		Properties props=new Properties();
		props.load(StatLines.class.getClassLoader().getResourceAsStream("config/statLines.properties"));
		zb=props.getProperty("fileName");
//System.out.println(zb);
//		File f = new File("F:\\workspace\\Chat");
		File f = new File(zb);
System.out.println(f);
//		File[] files = f.listFiles();
//		for(int i=0;i<files.length;i++)
//		{
//			if(files[i].getName().matches(".*\\.java$"))
//			{
//				stat(files[i]);
//			}
//		}
		listAllFile(f);
		for(int i=0;i<fileList.size();i++)
		{
			if(fileList.get(i).getName().matches(".*\\.java$"))
			{
				stat((fileList.get(i)));
			}
		}
		System.out.println("注释行数 ： "+commentLines);
		System.out.println("空白行数 ： "+whiteLines);
		System.out.println("正常行数 ： "+normalLines);
	}

	private static void listAllFile(File f) {
		if(f.isFile()) fileList.add(f);
		if(f.isDirectory())
		{
			File[] files = f.listFiles();
			for(int i=0;i<files.length;i++)
			{
				listAllFile(files[i]);
			}
		}
	}

	private static void stat(File file) {
		String str="";
		boolean b = false;
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			while((str=br.readLine())!=null)
			{
//				if(line.matches("^[\\s&&[^\\n]]*$")) {
//					whiteLines ++;
//				} else if (line.startsWith("/*") && !line.endsWith("*/")) {
//					commentLines ++;
//					comment = true;	
//				} else if (line.startsWith("/*") && line.endsWith("*/")) {
//					commentLines ++;
//				} else if (true == comment) {
//					commentLines ++;
//					if(line.endsWith("*/")) {
//						comment = false;
//					}
//				} else if (line.startsWith("//")) {
//					commentLines ++;
//				} else {
//					normalLines ++;
//				}
				str.trim();
				if(str.matches("^[\\s&&[^\\n]]*$"))
				{
					whiteLines++;
				}
				else if(str.startsWith("/*"))
				{
					b = true;
					commentLines++;
				}
				else if(b)
				{
					commentLines++;
					if(str.endsWith("*/"))
					{
						b = false;
					}
				}
				
				else if(str.startsWith("//"))
				{
					commentLines++;
				}
//				else if(str.endsWith("*/"))
//				{
//					b = false;
//					commentLines++;
//				}
				else
				{
					normalLines++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
