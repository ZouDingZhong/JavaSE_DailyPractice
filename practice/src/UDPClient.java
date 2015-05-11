import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
public class UDPClient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        byte[] b = new byte[1024];
        DatagramPacket ap = new DatagramPacket(b,b.length);
        DatagramSocket ds = new DatagramSocket(6666);
        while(true)
        {
        ds.receive(ap);
        ByteArrayInputStream dais = new ByteArrayInputStream(b);
        DataInputStream dis = new DataInputStream(dais);
        System.out.println(dis.readLong());
        }
	}

}
