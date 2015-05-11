import java.io.Flushable;
import java.io.IOException;
import java.net.*;
import java.io.*;


public class TCPClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub

		Socket client = new Socket("127.0.0.1",6666);
		OutputStream os = client.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		dos.writeUTF("Hello Server!");
        
        InputStream is = client.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        System.out.println(dis.readUTF());

        dos.flush();
        dos.close();
        dis.close();
        
        client.close();
        
		client.close();
	}

}
