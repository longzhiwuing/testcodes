package com.lzwing.testcode.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * Created with IntelliJ IDEA.
 *
 * 初始化各个组件
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/2/11
 * Time: 16:50
 */
public class MyWebSocketChannelHandler extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel e) throws Exception {
        e.pipeline().addLast("http-codec", new HttpServerCodec());
        e.pipeline().addLast("aggregator", new HttpObjectAggregator(65536));
        e.pipeline().addLast("http-chuncked",new ChunkedWriteHandler());
        e.pipeline().addLast("handler", null);
    }
}
