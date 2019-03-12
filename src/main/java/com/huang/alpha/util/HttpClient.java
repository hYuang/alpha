package com.huang.alpha.util;

import java.io.IOException;
import java.net.URL;

import com.huang.alpha.netty.HttpInitializer;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpVersion;

public class HttpClient {

	public static void request(URL url, HttpMethod httpmethod, HttpVersion version) {

		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(group).channel(NioSocketChannel.class).handler(new HttpInitializer(null));
			Channel channel = bootstrap.connect(url.getHost(), url.getPort()).sync().channel();
			HttpRequest request = new DefaultFullHttpRequest(version, httpmethod, url.toURI().getRawPath());
			request.headers().set(HttpHeaderNames.HOST, url.getHost());
			request.headers().set(HttpHeaderNames.CONNECTION,HttpHeaderValues.CLOSE);
			request.headers().set(HttpHeaderNames.ACCEPT_ENCODING, HttpHeaderValues.GZIP);
			channel.writeAndFlush(request);
			channel.closeFuture().sync();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			group.shutdownGracefully();
		}

	}

	public static void main(String[] args) throws Throwable {
		test();
	}

	public static void test() throws IOException, Throwable {
		String urlpath = "http://localhost:9000/info/porject";
		URL url = new URL(urlpath);
		System.out.println(url.toURI().getRawPath());
		HttpMethod httpmethod = HttpMethod.POST;
		HttpVersion version = HttpVersion.HTTP_1_1;
		HttpClient.request(url, httpmethod, version);

	}
}
