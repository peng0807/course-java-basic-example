package chapter6.example6_11;

import java.io.*;

public class TestDataStream {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("C:/FileTest.data");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		DataOutputStream dos = new DataOutputStream(bos);
		dos.writeByte(75);
		dos.writeLong(10000);
		dos.writeChar('a');
		dos.writeUTF("中");
		dos.close();
		bos.close();
		fos.close();
		FileInputStream fis = new FileInputStream("C:/FileTest.data");
		BufferedInputStream bis = new BufferedInputStream(fis);
		DataInputStream dis = new DataInputStream(bis);
		System.out.print(dis.readByte() + " ");
		System.out.print(dis.readLong() + " ");
		System.out.print(dis.readChar() + " ");
		System.out.print(dis.readUTF() + " ");
		dis.close();
	}

}
