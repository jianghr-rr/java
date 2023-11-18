package com.example.producer.rpc.producerStub;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectEncoder;;
import io.netty.handler.codec.serialization.ObjectDecoder;

public class RPCServer {
    private int port;
    public RPCServer(int port) {
        this.port = port;
    }
    public void start() {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .localAddress(port).childHandler(
                            new ChannelInitializer<SocketChannel>() {
                                @Override
                                protected void initChannel(SocketChannel ch)
                                        throws Exception {
                                    ChannelPipeline pipeline = ch.pipeline();
                                    //编码器
                                    pipeline.addLast("encoder", new ObjectEncoder());
                                    //解码器
                                    pipeline.addLast("decoder", new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
                                    //服务端业务处理类
                                    pipeline.addLast((ChannelHandler) new InvokeHandler());
                                }
                    });
            ChannelFuture future = serverBootstrap.bind(port).sync();
            System.out.println("......Hero RPC is ready......");
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
    public static void main(String[] args) throws Exception {
        new RPCServer(9999).start();
    }
}
