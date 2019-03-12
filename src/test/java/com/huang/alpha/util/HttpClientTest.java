package com.huang.alpha.util;

import java.io.IOException;
import java.net.URL;

import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpVersion;

public class HttpClientTest {

	public static void  main(String [] args) throws IOException {
		test();
	}
	
	public static void test() throws IOException {
		String urlpath = "http://localhost:9000/info";
		URL url = new URL(urlpath);
		HttpMethod httpmethod = HttpMethod.POST;
		HttpVersion version = HttpVersion.HTTP_1_1;
		HttpClient.request(url, httpmethod, version);

	}

}
