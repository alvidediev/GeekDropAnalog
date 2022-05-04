package ru.dediev.geekdrop.geekdropclient.Controllers;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class NetworkConnector {
    private static final int PORT = 9999;
    private static final String LOCAL_HOST = "localhost";


    SocketChannel channel;

    public NetworkConnector() {
        new Thread(() -> {
            EventLoopGroup workerGroup = new NioEventLoopGroup();
            try{
                Bootstrap bootstrap = new Bootstrap();
                bootstrap.group(workerGroup)
                        .channel(NioSocketChannel.class)
                        .handler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel socketChannel) throws Exception {
                                channel = socketChannel;
                                socketChannel.pipeline().addLast(new StringDecoder(), new StringEncoder());
                            }
                        });
                ChannelFuture future = bootstrap.connect(LOCAL_HOST, PORT).sync();
                future.channel().closeFuture().sync();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                workerGroup.shutdownGracefully();
            }

        }).start();
    }

    public void sendMessage(String str){
        channel.writeAndFlush(str);
    }
}
