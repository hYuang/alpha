package com.huang.alpha.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileUtil {
	private final static int size = 1024;

	public static String getFileContent(String filename, String charset) throws IOException {
		FileInputStream fis = new FileInputStream(
				Thread.currentThread().getContextClassLoader().getResource("").getPath() + filename);
		FileChannel fileChannel = fis.getChannel();
		ByteBuffer bf = ByteBuffer.allocate(size);
		fileChannel.read(bf);
		bf.flip();
		Charset charSet = Charset.forName(charset);
		CharsetDecoder decoder = charSet.newDecoder();
		CharBuffer charBuffer = decoder.decode(bf);
		while (bf.hasRemaining()) {
			bf.flip();
			charBuffer.append(bf.getChar());
		}
		fileChannel.close();
		fis.close();
		return charBuffer.toString();
	}
}
