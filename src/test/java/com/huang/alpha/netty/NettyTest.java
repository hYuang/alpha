package com.huang.alpha.netty;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class NettyTest {
	private final static Logger LOG = LoggerFactory.getLogger(NettyTest.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerBootstrap b = new ServerBootstrap();
		EventLoopGroup bossGroup =  new NioEventLoopGroup();
		EventLoopGroup childGroup = new NioEventLoopGroup();
		b.group(bossGroup,childGroup).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 100)
		.handler(new LoggingHandler(LogLevel.INFO)).childHandler(new ChannelInitializer<SocketChannel>() {

			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ChannelPipeline pip = ch.pipeline();
				pip.addLast(new LoggingHandler(LogLevel.INFO));
				
			}
			
		});
		try {
			ChannelFuture f = b.bind(10800).sync();
			f.channel().closeFuture().addListener(new ChannelFutureListener() {

				@Override
				public void operationComplete(ChannelFuture future) throws Exception {
					// TODO Auto-generated method stub
					LOG.info(future.channel().toString() + " close the channel");
				}
				
			});
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bossGroup.shutdownGracefully();
			childGroup.shutdownGracefully();
		}

	}

}
