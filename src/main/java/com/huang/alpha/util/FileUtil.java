package com.huang.alpha.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileUtil {
	private final static int size = 1024;
	public static String getFileContent(String filename) throws IOException {
		FileInputStream fis = new FileInputStream(filename); 
		FileChannel fileChannel = fis.getChannel();
		ByteBuffer bf = ByteBuffer.allocate(size);
		fileChannel.read(bf);
		bf.flip();
		StringBuffer stringBuffer =  new StringBuffer ();
		while(bf.hasRemaining()) {
			stringBuffer.append(bf.getChar());
		}
		fileChannel.close();
		fis.close();
		
		return stringBuffer.toString();
	}
}
