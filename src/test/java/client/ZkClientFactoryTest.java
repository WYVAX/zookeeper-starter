package client;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import star.xiaolei.client.ZookeeperClientFactory;
import star.xiaolei.pubsub.Publisher;
import star.xiaolei.pubsub.Subscriber;

import java.util.Arrays;

/**
 * Created by 周高磊
 * Date: 2017/5/9.
 * Email: gaoleizhou@gmail.com
 * Desc: 单元测试
 */
@ActiveProfiles("test")
public class ZkClientFactoryTest extends BaseTest {

    @Autowired
    private ZookeeperClientFactory zookeeperClientFactory;

    @Test
    public void test() throws Exception {
        String topic = "/test";

        Publisher publisher = new Publisher(zookeeperClientFactory, topic);

        Subscriber subscriber = new Subscriber(zookeeperClientFactory, topic);

        subscriber.subscribe(data -> System.out.println(Arrays.toString(data)));

        publisher.publish("test".getBytes());
    }
}
