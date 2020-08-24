package com.lzwing.testcode.utils.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Optional;

public class ByteUtils {

    private static final Logger log = LoggerFactory.getLogger(ByteUtils.class);

    public static<T> Optional<byte[]> objectToBytes(T obj){
        if (obj == null) {
            throw new NullPointerException("待转换byte数组的obj对象为空，请检查!");
        }

        byte[] bytes = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream sOut;
        try {
            sOut = new ObjectOutputStream(out);
            sOut.writeObject(obj);
            sOut.flush();
            bytes= out.toByteArray();
        } catch (NotSerializableException e) {
            log.error("请把object对象实现Serializable接口");
        } catch (Exception e) {
            log.error("object转byte数组失败!",e);
        }
        return Optional.ofNullable(bytes);
    }

    public static<T> Optional<T> bytesToObject(byte[] bytes) {
        T t = null;
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        ObjectInputStream sIn;
        try {
            sIn = new ObjectInputStream(in);
            t = (T)sIn.readObject();
        } catch (Exception e) {
            log.error("byte数组转Object失败!",e);
        }
        return Optional.ofNullable(t);

    }
}