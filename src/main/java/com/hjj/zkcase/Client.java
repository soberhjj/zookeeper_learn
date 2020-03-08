package com.hjj.zkcase;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author soberhjj  2020/3/8 - 10:08
 */
public class Client {

    private String connectString="192.168.254.101:2181,192.168.254.102:2181,192.168.254.103:2181";

    private int sessionTimeout=2000;

    private ZooKeeper zkclient;

    //连接zk
    public void connectZK() throws IOException {
        zkclient=new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                try {
                    getChildren();
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    //注册监听
    public void getChildren() throws KeeperException, InterruptedException {
        List<String> nodes=zkclient.getChildren("/servers",true);

        List<String> allserver=new ArrayList<String>();

        for (String s: nodes) {
            byte[] bytes=zkclient.getData("/servers/"+s,false,null);
            allserver.add(new String(bytes));
        }

        //将所有在线主机名打印到控制台
        System.out.println(allserver);

    }
}
