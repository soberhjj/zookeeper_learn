package com.hjj.zkcase;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;

/**
 * @author soberhjj  2020/3/8 - 10:29
 */
public class ClientMain {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        Client client=new Client();

        client.connectZK();

        client.getChildren();

        Thread.sleep(Long.MAX_VALUE);//让main线程睡眠，程序不结束
    }
}
