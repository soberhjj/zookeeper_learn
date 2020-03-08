package com.hjj.zookeeperlearn;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

/**
 * @author soberhjj  2020/3/7 - 22:02
 *
 * 获取某节点的所有子节点并监听该节点上的变化
 */
public class TestGetDataAndWatch {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        String connectString = "192.168.254.101:2181,192.168.254.102:2181,192.168.254.103:2181";

        int sessionTimeout = 2000;  //连接zk集群的时间，超过2秒连接不上的话则连接失败

        Watcher watcher = new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                //当监听到变化时，要做的事
                System.out.println("监听的节点发生了改变");
            }
        };


        ZooKeeper zkclient = new ZooKeeper(connectString, sessionTimeout, watcher);

        List<String> children= zkclient.getChildren("/",true);

        for (String s:children ) {
            System.out.println(s);
        }

        Thread.sleep(Long.MAX_VALUE);

    }
}
