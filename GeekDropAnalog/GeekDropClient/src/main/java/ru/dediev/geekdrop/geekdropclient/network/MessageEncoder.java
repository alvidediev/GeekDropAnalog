package ru.dediev.geekdrop.geekdropclient.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import ru.dediev.geekdrop.geekdropclient.model.UsersDataFromClient;

import java.nio.charset.StandardCharsets;

public class MessageEncoder extends MessageToByteEncoder<UsersDataFromClient> {
    @Override
    protected void encode(ChannelHandlerContext ctx, UsersDataFromClient msg, ByteBuf out) throws Exception {
        out.writeInt(msg.getName().length());
        out.writeCharSequence(msg.getName(), StandardCharsets.UTF_8);
        out.writeInt(msg.getLogin().length());
        out.writeCharSequence(msg.getLogin(), StandardCharsets.UTF_8);
        out.writeInt(msg.getPassword().length());
        out.writeCharSequence(msg.getPassword(), StandardCharsets.UTF_8);
    }
}
