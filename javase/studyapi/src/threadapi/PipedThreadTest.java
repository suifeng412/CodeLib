package threadapi;

import java.io.*;

/*
 * 管道输入输出流
 * 管道输入/输出流主要用于线程之间的数据传输，而且传输的媒介为内存
 * 
 * 面向字节： PipedOutputStream、 PipedInputStream
 * 面向字符: PipedWriter、 PipedReader
 * 
 * */
public class PipedThreadTest {
	public static void main(String[] args) {

		try {
			WriteData writeData = new WriteData();
			ReadData readData = new ReadData();

			PipedInputStream inputStream = new PipedInputStream();
			PipedOutputStream outputStream = new PipedOutputStream();

			// inputStream.connect(outputStream);
			outputStream.connect(inputStream);

			ThreadRead threadRead = new ThreadRead(readData, inputStream);
			threadRead.start();

			Thread.sleep(2000);

			ThreadWrite threadWrite = new ThreadWrite(writeData, outputStream);
			threadWrite.start();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

class ThreadRead extends Thread {

	private ReadData read;
	private PipedInputStream input;

	public ThreadRead(ReadData read, PipedInputStream input) {
		super();
		this.read = read;
		this.input = input;
	}

	@Override
	public void run() {
		read.readMethod(input);
	}

}

class ThreadWrite extends Thread {

	private WriteData write;
	private PipedOutputStream out;

	public ThreadWrite(WriteData write, PipedOutputStream out) {
		super();
		this.write = write;
		this.out = out;
	}

	@Override
	public void run() {
		write.writeMethod(out);
	}

}

class WriteData {

	public void writeMethod(PipedOutputStream out) {
		try {
			System.out.println("write :");
			for (int i = 0; i < 300; i++) {
				String outData = "" + (i + 1);
				out.write(outData.getBytes());
				System.out.print(outData);
			}
			System.out.println();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ReadData {

	public void readMethod(PipedInputStream input) {
		try {
			System.out.println("read  :");
			byte[] byteArray = new byte[20];
			int readLength = input.read(byteArray);
			while (readLength != -1) {
				String newData = new String(byteArray, 0, readLength);
				System.out.print(newData);
				readLength = input.read(byteArray);
			}
			System.out.println();
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}