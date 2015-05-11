import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
public class UDPServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

//		byte [] b = (new String("Hello!")).getBytes();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		long l = 10000L;
		dos.writeLong(l);
		byte[] b=baos.toByteArray();
		DatagramPacket dp = new DatagramPacket(b,b.length,
				new InetSocketAddress("127.0.0.1",6666));
		DatagramSocket ds = new DatagramSocket(9999);
		ds.send(dp);
		ds.close();
	}

}
