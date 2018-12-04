package cn.com.lioan.zk;

import org.apache.zookeeper.*;

public class TestZk {

    public static final String ROOT = "/root-lixx";

    public static void main(String[] args) throws Exception {
        ZooKeeper zk = new ZooKeeper("192.168.1.8", 50000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("状态:" + event.getState() + ":" + event.getType() + ":" + event.getWrapper() + ":" + event.getPath());
            }
        });

        zk.create(ROOT, ROOT.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.create(ROOT + "/root-liss", "root-liss".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        zk.create(ROOT + "/root-lisn", "root-lisn".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }
}
