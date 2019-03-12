package com.huang.alpha.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpContentDecompressor;
import io.netty.handler.ssl.SslContext;

public class HttpInitializer extends ChannelInitializer<SocketChannel>{

	
	private final SslContext sslCtx;

    public HttpInitializer(SslContext sslCtx) {
        this.sslCtx = sslCtx;
    }
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline channelPipeline =  ch.pipeline();
		if(sslCtx != null) {
			channelPipeline.addFirst(sslCtx.newHandler(ch.alloc()));
		}
		channelPipeline.addLast(new HttpClientCodec());

		channelPipeline.addLast(new HttpContentDecompressor());
		channelPipeline.addLast(new HttpClientHandler());
		
	}

}
