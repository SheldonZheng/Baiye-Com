package com.baiye.NettyTest;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by Baiye on 2016/9/21.
 */
public class EchoClientHandler extends ChannelInboundHandlerAdapter{


    private final ByteBuf firstMessage;

    public EchoClientHandler(int firstMessageSize) {

        firstMessage = Unpooled.buffer(firstMessageSize);
        for(int i = 0;i < firstMessage.capacity();i++)
        {
            firstMessage.writeByte((byte)i);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.err.println("EchoClientHandler Exception");
        System.err.println(cause);
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(firstMessage);
        ctx.writeAndFlush(firstMessage);
    }
}
