package com.test.database.translate.scoket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAdressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress[] inetAdress = getInetAdress("www.baidu.com");
        for (InetAddress adress : inetAdress) {
            System.out.println(adress);
        }
    }

    // 获取所有的IP地址
    public static InetAddress[] getInetAdress(String host) throws UnknownHostException {
        return InetAddress.getAllByName(host);
    }

}
