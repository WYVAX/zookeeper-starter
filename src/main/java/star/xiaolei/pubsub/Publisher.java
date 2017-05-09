package star.xiaolei.pubsub;

import org.apache.curator.framework.CuratorFramework;
import star.xiaolei.client.ZookeeperClientFactory;

/**
 * Created by 周高磊
 * Date: 2017/5/9.
 * Email: gaoleizhou@gmail.com
 * Desc: Publisher
 */
public class Publisher {

    private final CuratorFramework client;

    private final Paths paths;

    public Publisher(final ZookeeperClientFactory zookeeperClientFactory, final String topic) {
        this.client = zookeeperClientFactory.getClient();
        this.paths = new Paths(topic);
    }

    /**
     * publish
     * @param data 数据
     * @throws Exception 异常
     */
    public void publish(byte[] data) throws Exception {
        if(client.checkExists().forPath(paths.getTopicBase()) == null) {
            client.create().creatingParentsIfNeeded().forPath(paths.getTopicBase());
        }
        client.setData().forPath(paths.getTopicBase(), data);
    }
}
