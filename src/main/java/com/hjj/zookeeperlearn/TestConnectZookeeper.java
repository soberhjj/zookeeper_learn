package com.hjj.zookeeperlearn;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @author soberhjj  2020/3/7 - 21:21
 *
 * 访问 （连接）zookeeper集群
 */
public class TestConnectZookeeper {
    public static void main(String[] args) {
        String connectString="192.168.254.101:2181,192.168.254.102:2181,192.168.254.103:2181";

        int sessionTimeout=2000;  //连接zk集群的时间，超过2秒连接不上的话则连接失败

        Watcher watcher=new Watcher() {
            public void process(WatchedEvent watchedEvent) {

            }
        };

        try {
            ZooKeeper zkclient=new ZooKeeper(connectString,sessionTimeout,watcher);
        } catch (IOException e) {
            System.out.println("连接失败");
        }
    }
}
