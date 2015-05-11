import java.io.IOException;
import java.net.*;
import java.io.*;
public class TCPServer {

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub

		ServerSocket server = new ServerSocket(6666);
		while(true)
		{
			Socket s = server.accept();
			InputStream is = s.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			System.out.println(dis.readUTF());
			
			OutputStream os = s.getOutputStream();
			DataOutputStream sout = new DataOutputStream(os);
			sout.writeUTF("ByeBye"+s.getPort()+"   "+s.getInetAddress());
            sout.flush();
            sout.close();
            is.close();
            s.close();
            
            
		}
	}

}
