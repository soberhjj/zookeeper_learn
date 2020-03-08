package com.hjj.zookeeperlearn;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * @author soberhjj  2020/3/7 - 21:42
 *
 * 在ZK上创建节点
 */
public class TestMakeZKNode {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        String connectString = "192.168.254.101:2181,192.168.254.102:2181,192.168.254.103:2181";

        int sessionTimeout = 2000;  //连接zk集群的时间，超过2秒连接不上的话则连接失败

        Watcher watcher = new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                //监听回调，这里先不写，这里只是用来测试连接zk集群
            }
        };


        ZooKeeper zkclient = new ZooKeeper(connectString, sessionTimeout, watcher);

        //创建Zknode
        zkclient.create("/TestMakeZKNode","hello".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);


    }
}
