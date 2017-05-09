package client;

import org.apache.curator.framework.CuratorFramework;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import star.xiaolei.client.ZookeeperClientFactory;

/**
 * Created by 周高磊
 * Date: 2017/5/9.
 * Email: gaoleizhou@gmail.com
 * Desc:
 */
public class ZkClientFactoryTest extends BaseTest {

    @Autowired
    private ZookeeperClientFactory zookeeperClientFactory;

    @Before
    public void init() throws Exception {
        zookeeperClientFactory.getClient().create().forPath("/test");
    }

    @Test
    public void testGet() throws Exception {

    }
}
