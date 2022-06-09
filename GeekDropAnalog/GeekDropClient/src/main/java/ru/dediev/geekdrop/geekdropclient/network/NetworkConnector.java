package ru.dediev.geekdrop.geekdropclient.network;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import ru.dediev.geekdrop.geekdropclient.model.Message;

import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

public class NetworkConnector {
    private static final int PORT = 8888;
    private static final String LOCAL_HOST = "localhost";

    public void send(Message message, Consumer<String> consumer) {
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap client = new Bootstrap();
            client.group(workerGroup);
            client.channel(NioSocketChannel.class);
            client.option(ChannelOption.SO_KEEPALIVE, true);
            client.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast(
                            new JacksonEncoder(),
                            new LineBasedFrameDecoder(80),
                            new StringDecoder(StandardCharsets.UTF_8),
                            new ClientHandler(message, consumer)
                    );
                }
            });
            ChannelFuture future = client.connect(LOCAL_HOST, PORT).await();
            future.addListener(f -> {
                if (!f.isSuccess()) {
                    consumer.accept("Connection resufed");
                }
            });
        } catch (InterruptedException e) {
            throw new RuntimeException();
        } finally {
            workerGroup.shutdownGracefully();

        }
    }
}
