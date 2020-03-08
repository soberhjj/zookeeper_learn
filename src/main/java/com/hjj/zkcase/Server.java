package com.hjj.zkcase;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * @author soberhjj  2020/3/8 - 9:39
 */
public class Server {

    private String connectString="192.168.254.101:2181,192.168.254.102:2181,192.168.254.103:2181";

    private int sessionTimeout=2000;

    private ZooKeeper zkclient;

    //连接zk
    public void connectZK() throws IOException {
        zkclient=new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }

    //向zk注册节点
    public void register(String hostname) throws KeeperException, InterruptedException {
        String path=zkclient.create("/servers/server",hostname.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(hostname+" is online");
    }

}
