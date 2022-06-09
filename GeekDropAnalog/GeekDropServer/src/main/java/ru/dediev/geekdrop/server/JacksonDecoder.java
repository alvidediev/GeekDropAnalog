package ru.dediev.geekdrop.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import ru.dediev.geekdrop.model.Message;

import java.io.InputStream;
import java.util.List;

public class JacksonDecoder extends ByteToMessageDecoder {
    private final ObjectMapper mapper = new ObjectMapper();


    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        InputStream byteIntStream = new ByteBufInputStream(byteBuf);
        list.add(mapper.readValue(byteIntStream, Message.class));
    }
}
