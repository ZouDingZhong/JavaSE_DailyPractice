import java.io.*;
import java.net.*;


public class TalkTestClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
    
      String kstr =null;
      BufferedReader keyread = new BufferedReader(new InputStreamReader(System.in));
      
      Socket s = new Socket("127.0.0.1",666);
      OutputStream os = s.getOutputStream();
      DataOutputStream dos = new DataOutputStream(os);
      InputStream is = s.getInputStream();
      DataInputStream dis = new DataInputStream(is);
      String str;
      
      while(true)
      {
      kstr = keyread.readLine();
      if(kstr.equalsIgnoreCase("exit")){System.out.println("你已经下线。");return;}
      System.out.println("Client: "+kstr);
      dos.writeUTF(kstr);
      
      try{
    	  str = dis.readUTF();
    	  }
      catch(IOException e){System.out.println("对方已经下线。");return;}
//      if(str.equalsIgnoreCase("exit")){System.out.println("对方已经下线。");return;}
      System.out.println("Server: "+str);
      
      
      }
	}

}
