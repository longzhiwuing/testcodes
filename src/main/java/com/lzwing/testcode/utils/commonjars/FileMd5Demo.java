package com.lzwing.testcode.utils.commonjars;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/4/24
 * Time: 17:16
 */
public class FileMd5Demo {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\test.txt");

        String md5 = getFileMD5(file);

        System.out.println(md5);
    }

    /**
     * 针对普通文件计算md5方法
     * 若文件较大(大于30M)，请使用getLargeFileMD5速度会比较快一点
     * @param file
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String getFileMD5(File file) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(file);
        String md5 = DigestUtils.md5Hex(IOUtils.toByteArray(fis));
        IOUtils.closeQuietly(fis);
        return md5;
    }

    /**
     *  针对大文件计算md5值的方法
     * @param file
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String getLargeFileMD5(File file) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[8192];
        MessageDigest md5 = DigestUtils.getMd5Digest();
        int len;
        while ((len = fis.read(buffer)) != -1) {
            md5.update(buffer, 0, len);
        }
        IOUtils.closeQuietly(fis);
        return Hex.encodeHexString(md5.digest());
    }
}
