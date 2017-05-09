package client;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * Created by 周高磊
 * Date: 2017/5/8.
 * Email: gaoleizhou@gmail.com
 * Desc: Factory
 */
public class ZookeeperClientFactory {

    private final CuratorFramework client;

    /**
     * 打开zookeeper连接
     * @param zookeeperConnection 连接信息,如127.0.0.1:2181
     * @throws Exception 异常
     */
    public ZookeeperClientFactory(String zookeeperConnection) throws Exception {
        client = CuratorFrameworkFactory.newClient(zookeeperConnection, new ExponentialBackoffRetry(1000, 3));
        client.start();
        client.getZookeeperClient().blockUntilConnectedOrTimedOut();
    }

    /**
     * 获取zookeeper client
     * @return client
     */
    public CuratorFramework getClient() {
        return client;
    }

    /**
     * 关闭连接
     */
    public void destroy() {
        client.close();
    }
}
