package ru.dediev.geekdrop.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import ru.dediev.geekdrop.base.BaseHandler;
import ru.dediev.geekdrop.model.UsersData;

import java.util.Arrays;

/**
 * Для чего служит класс: основновй класс для взаимодействия с фреймворком Netty, для создания конвейера для
 * регистрации пользователей.
 * После наследования ChannelInboundHandlerAdapter выбраны 3 сетода для переопределения, это:
 * channelActive, channelRead, exceptionCaught.
 * <p>
 * Creator: Alvi Dediev.
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
    BaseHandler baseHandler = new BaseHandler();

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client connected");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        UsersData message = (UsersData) msg;
        System.out.println("Message from client " + message);

        ChannelFuture future = ctx.writeAndFlush("ok\n");
        future.addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
