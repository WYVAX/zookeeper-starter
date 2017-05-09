package star.xiaolei.pubsub;


import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.zookeeper.WatchedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import star.xiaolei.client.ZookeeperClientFactory;

import java.util.concurrent.CountDownLatch;

import static org.apache.zookeeper.Watcher.Event.EventType.NodeDataChanged;

/**
 * Created by 周高磊
 * Date: 2017/5/9.
 * Email: gaoleizhou@gmail.com
 * Desc:
 */
@EnableAutoConfiguration
public class PubSubTest {
    private static Logger logger = LoggerFactory.getLogger(PubSubTest.class);

    @Autowired
    private static ZookeeperClientFactory zookeeperClientFactory;

    static CuratorFramework client = null;

    static final String PATH = "/app/data_config";

    static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void init() throws Exception {
        client = new ZookeeperClientFactory("127.0.0.1:2181").getClient();
    }

    public static void main(String[] args) throws Exception {
        init();
        watcherPath(PATH, curatorWatcher);
    }

    /**
     * 对path节点进行监听
     * @param path
     * @param curatorWatcher
     * @return
     * @throws Exception
     */
    public static String watcherPath(String path, CuratorWatcher curatorWatcher) throws Exception {
        byte[] buffer = client.getData().usingWatcher(curatorWatcher).forPath(path);
        System.out.println(new String(buffer));
        return new String(buffer);
    }

    /**
     * 读取path节点路径下的数据
     * @param path
     * @return
     * @throws Exception
     */
    public static String readPath(String path) throws Exception {
        byte[] buffer = client.getData().forPath(path);
        System.out.println(new String(buffer));
        return new String(buffer);
    }

    /**
     * 重写Watcher事件处理
     */
    static CuratorWatcher curatorWatcher = new CuratorWatcher() {
        @Override
        public void process(WatchedEvent watchedEvent) throws Exception {
            if(watchedEvent.getType() == NodeDataChanged) {
                //获取改节点下面的数据
                String value = readPath(watchedEvent.getPath());
                System.out.println(value);
            }
        }
    };
}
