package com.msb.zookeeper.config;

import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author: thirteenmj
 * @date: 2022-10-11 17:05
 */
public class ZkUtils {

    private static ZooKeeper zk;

    private static String address = "150.158.188.28：2181/testConf";

    private static DefaultWatch watch = new DefaultWatch();

    private static CountDownLatch init = new CountDownLatch(1);

    public static ZooKeeper getZk() {
        try {
            zk = new ZooKeeper(address, 1000, watch);
            init.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return zk;
    }
}
