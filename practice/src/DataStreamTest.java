import java.io.*;


public class DataStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		
		Double d = Math.random();
		boolean b = true;
		try {
			dos.writeDouble(d);	
			dos.writeBoolean(b);
			
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			DataInputStream dis = new DataInputStream(bis);
			System.out.println(dis.readDouble());
			System.out.println(dis.readBoolean());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
	}

}
