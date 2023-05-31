/**
 * springbootup @ org.reed.server.ReedAdminServer.java
 */
package org.reed.server;

import org.reed.log.ReedLogger;
import org.reed.utils.EnderUtil;
import org.reed.utils.StringUtil;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

/**
 * @author chenxiwen
 * @createTime 2021-11-11 14:13
 */
@Component
public class ReedAdminServer extends ChannelInitializer<SocketChannel> {

    @Autowired
    private ReedAdminServer serverHandler;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast("decoder", new StringDecoder(StringUtil.DEFAULT_CHARSET));
        ch.pipeline().addLast("encoder", new StringDecoder(StringUtil.DEFAULT_CHARSET));
        ch.pipeline().addLast(serverHandler);
    }

    public void start(InetSocketAddress socketAddress){
        EventLoopGroup mainGroup = new NioEventLoopGroup(1);
        EventLoopGroup workGroup = new NioEventLoopGroup(200);
        ServerBootstrap bootstrap = new ServerBootstrap()
                .group(mainGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(this)
                .localAddress(socketAddress)
                .option(ChannelOption.SO_BACKLOG, 1024) //队列大小
                .childOption(ChannelOption.SO_KEEPALIVE, true) //默认两个小时没有童心就发送一个活动探测报文
                ;

        try{
            ChannelFuture future = bootstrap.bind(socketAddress).sync();
            ReedLogger.info("ReedAdminServer start listening port at " + socketAddress.getPort());
            future.channel().closeFuture().sync();
        }catch(InterruptedException e){
            ReedLogger.error(EnderUtil.devInfo() + " - " + e.getMessage());
            e.printStackTrace();
        }finally {
            mainGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }
}
