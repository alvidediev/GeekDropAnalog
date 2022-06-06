package ru.dediev.geekdrop.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import ru.dediev.geekdrop.model.UsersData;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class MessageDecoder extends ReplayingDecoder<UsersData> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        int nick = in.readInt();
        String nickName = in.readCharSequence(nick, StandardCharsets.UTF_8).toString();
        int log = in.readInt();
        String login = in.readCharSequence(log, StandardCharsets.UTF_8).toString();
        int pass = in.readInt();
        String password = in.readCharSequence(pass, StandardCharsets.UTF_8).toString();
        UsersData usersData = new UsersData(login, password, nickName);
        out.add(usersData);
    }
}
