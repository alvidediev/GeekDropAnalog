package ru.dediev.geekdrop.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import ru.dediev.geekdrop.base.BaseHandler;

import java.util.Arrays;

/**
 * Для чего служит класс: основновй класс для взаимодействия с фреймворком Netty, для создания конвейера для
 * регистрации пользователей.
 * После наследования ChannelInboundHandlerAdapter выбраны 3 сетода для переопределения, это:
 * channelActive, channelRead, exceptionCaught.
 *
 * Creator: Alvi Dediev.
 */
public class ClientsRegistrationHandler extends ChannelInboundHandlerAdapter {
    BaseHandler baseHandler = new BaseHandler();

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client connected");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buffer = (ByteBuf) msg;
        while(buffer.isReadable()){
            String s1 = buffer.toString();
            System.out.println(s1);
//            char c = (char) buffer.readByte();
//            String s = String.valueOf(c);
//            String[] split = s.split(" ");
//            System.out.print(Arrays.toString(split));
        }
        buffer.release();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
