/**
 * springbootup @ org.reed.server.ReedAdminServerHandler.java
 */
package org.reed.server;

import org.reed.log.ReedLogger;
import org.reed.utils.EnderUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.stereotype.Component;

/**
 * @author chenxiwen
 * @createTime 2021-11-11 11:13
 */
@Component
public class ReedAdminServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
        ReedLogger.debug(EnderUtil.devInfo() + " - channelRegistered ctx: " + ctx.toString());
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx);
        ReedLogger.debug(EnderUtil.devInfo() + " - channelUnregistered ctx: " + ctx.toString());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        ReedLogger.debug(EnderUtil.devInfo() + " - channelActive ctx: " + ctx.toString());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        ReedLogger.debug(EnderUtil.devInfo() + " - channelInactive ctx: " + ctx.toString());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        ReedLogger.debug(EnderUtil.devInfo() + " - channelRead ctx: " + ctx.toString() + ", msg: " + msg.toString());
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
        ReedLogger.debug(EnderUtil.devInfo() + " - channelReadComplete ctx: " + ctx.toString());
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
        ReedLogger.debug(EnderUtil.devInfo() + " - userEventTriggered ctx: " + ctx.toString() + ", evt: " + evt.toString());
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        super.channelWritabilityChanged(ctx);
        ReedLogger.debug(EnderUtil.devInfo() + " - channelWritabilityChanged ctx: " + ctx.toString());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        ReedLogger.debug(EnderUtil.devInfo() + " - exceptionCaught ctx: " + ctx.toString() + ", cause: "+cause.toString());
    }


}
