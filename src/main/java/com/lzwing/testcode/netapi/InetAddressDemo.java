package com.lzwing.testcode.netapi;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/30
 * Time: 15:05
 */
public class InetAddressDemo {
    public static void main(String[] args) throws Exception {
//        testInetAddress();
//        demoInetAddress();
        testUrl();
    }

    private static void testUrl() throws IOException, URISyntaxException {
        URL url = new URL("http://172.16.21.133/cecd/sdc/ceccloud/dashboard/index.jsp?name=aaa#ccc");
        System.out.println(url);
        System.out.println(url.getPath());
        System.out.println(url.getAuthority());
        System.out.println(url.getContent());
        System.out.println(url.toURI());
        System.out.println(url.getUserInfo());
        System.out.println(url.getRef());
        System.out.println(url.getQuery());
        System.out.println(url.getProtocol());
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getFile());
        System.out.println(url.getDefaultPort());
    }

    private static void testInetAddress() throws UnknownHostException {
        InetAddress address=InetAddress.getByName("www.baidu.com");
        System.out.println(address.getHostName());
        System.out.println(address.getHostAddress());

//        byte[] baiduAddress = InetAddress.getByName("www.baidu.com").getAddress();
        byte[] baiduAddress = new byte[] { (byte) 192, (byte) 168, 0, 1 };
        InetAddress byAddress = InetAddress.getByAddress(baiduAddress);
        System.out.println(byAddress.getHostName());
    }

    public static void demoInetAddress() {
        InetAddress inetAddress;//声明InetAddress对象
        try {
            inetAddress=InetAddress.getLocalHost();//实例化InetAddress对象，返回本地主机
            String hostName=inetAddress.getHostName();//获取本地主机名
            String canonicalHostName=inetAddress.getCanonicalHostName();//获取此 IP地址的完全限定域名
            byte[] address=inetAddress.getAddress();//获取原始IP地址
            int a=0;
            if(address[3]<0){
                a=address[3]+256;
            }
            String hostAddress=inetAddress.getHostAddress();//获取本地主机的IP地址
            boolean reachable=inetAddress.isReachable(2000);//获取布尔类型，看是否能到达此IP地址
            System.out.println(inetAddress.toString());
            System.out.println("主机名为："+hostName);//输出本地主机名
            System.out.println("此IP地址的完全限定域名："+canonicalHostName);//输出此IP地址的完全限定域名
            System.out.println("原始IP地址为："+address[0]+"."+address[1]+"."+address[2]+"."+a);//输出本地主机的原始IP地址
            System.out.println("IP地址为："+hostAddress);//输出本地主机的IP地址
            System.out.println("是否能到达此IP地址："+reachable);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
