package star.xiaolei.pubsub;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.zookeeper.WatchedEvent;
import star.xiaolei.client.ZookeeperClientFactory;

/**
 * Created by 周高磊
 * Date: 2017/5/9.
 * Email: gaoleizhou@gmail.com
 * Desc: Subscriber
 */
public class Subscriber {

    private final CuratorFramework client;

    private final Paths paths;

    /**
     * Constructor
     * @param zookeeperClientFactory 客户端工厂类
     * @param topic 主题
     */
    public Subscriber(final ZookeeperClientFactory zookeeperClientFactory, final String topic) {
        this.client = zookeeperClientFactory.getClient();
        this.paths = new Paths(topic);
    }

    public void subscribe(final SubscriberCallBack subscriberCallBack) throws Exception {
        final CuratorWatcher curatorWatcher = new CuratorWatcher() {
            @Override
            public void process(WatchedEvent watchedEvent) throws Exception {
                byte[] data = client.getData().usingWatcher(this).forPath(paths.getTopicBase());
                subscriberCallBack.fire(data);
            }
        };

        client.getData().usingWatcher(curatorWatcher).forPath(paths.getTopicBase());
    }

    public interface SubscriberCallBack {
        void fire(byte[] data);
    }
}