package com.lzwing.testcode.netty.chatroom.server;

import com.lzwing.testcode.netty.chatroom.Message;
import com.lzwing.testcode.netty.chatroom.Utils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.StandardCharsets;

public class MessageEncoder extends MessageToByteEncoder<Message> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Message message, ByteBuf out) throws Exception {
        ByteBuf buffer = ctx.alloc().buffer();
        String content = Utils.encodeMsg(message);
        buffer.writeBytes(content.getBytes(StandardCharsets.UTF_8));

        ctx.writeAndFlush(buffer);
    }
}