package com.hjj.zkcase;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;

/**
 * @author soberhjj  2020/3/8 - 9:54
 */
public class ServerMain2 {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        Server server=new Server();

        server.connectZK();

        server.register("ip2");

        Thread.sleep(Long.MAX_VALUE);
    }
}
