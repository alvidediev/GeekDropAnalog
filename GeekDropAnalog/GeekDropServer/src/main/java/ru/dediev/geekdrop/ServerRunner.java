package ru.dediev.geekdrop;

import io.netty.channel.EventLoopGroup;
import ru.dediev.geekdrop.server.NettyServer;

public class ServerRunner {
    public static void main(String[] args) {
        new NettyServer().start();
    }
}
