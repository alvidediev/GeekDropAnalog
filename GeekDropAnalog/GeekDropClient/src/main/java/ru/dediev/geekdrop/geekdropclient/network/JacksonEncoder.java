package ru.dediev.geekdrop.geekdropclient.network;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import ru.dediev.geekdrop.geekdropclient.model.Message;

public class JacksonEncoder extends MessageToByteEncoder<Message> {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Message message, ByteBuf byteBuf) throws Exception {
        byteBuf.writeBytes(mapper.writeValueAsBytes(message));
        System.out.println(new String(mapper.writeValueAsBytes(message)));
    }
}
