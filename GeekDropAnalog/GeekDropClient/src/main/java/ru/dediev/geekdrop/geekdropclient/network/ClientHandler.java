package ru.dediev.geekdrop.geekdropclient.network;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import ru.dediev.geekdrop.geekdropclient.model.UsersDataFromClient;

import java.util.function.Consumer;

public class ClientHandler extends ChannelInboundHandlerAdapter {

    private final UsersDataFromClient message;
    private final Consumer<String> consumer;

    public ClientHandler(UsersDataFromClient message, Consumer<String> consumer) {
        this.message = message;
        this.consumer = consumer;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(message);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String response = (String) msg;
        consumer.accept(response);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
