import java.io.*;
import java.net.*;


public class TalkTestServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(666);
		Socket s = ss.accept();
	    InputStream is = s.getInputStream();
	    OutputStream os = s.getOutputStream();
	    DataInputStream dis = new DataInputStream(is);
        DataOutputStream dos = new DataOutputStream(os);
	    
	    String kstr =null;
	    BufferedReader keyread = new BufferedReader(new InputStreamReader(System.in));
	    
	    String str=null;
	    while(true)
	    {
	    
	    try{
	    	str=dis.readUTF();
	    	}
	    catch(IOException e){System.out.println("对方已经下线。");return;}
	    if(str.equalsIgnoreCase("exit")) {System.out.println("对方已经下线。");return;}
	    System.out.println("Client :"+str);
	    
	    kstr = keyread.readLine();
//	    if(kstr.equalsIgnoreCase("exit")){System.out.println("你已经下线。");return;}
	    System.out.println("Server :"+kstr);
	    
	    dos.writeUTF(kstr);
	    }

	}

}
