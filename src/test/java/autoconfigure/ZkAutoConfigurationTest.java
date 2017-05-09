package autoconfigure;

import org.junit.Test;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.test.util.EnvironmentTestUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import star.xiaolei.autoconfigure.ZookeeperAutoConfiguration;
import star.xiaolei.client.ZookeeperClientFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by 周高磊
 * Date: 2017/5/9.
 * Email: gaoleizhou@gmail.com
 * Desc:
 */
@ActiveProfiles("test")
public class ZkAutoConfigurationTest {

    private AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

    @Test
    public void testWithFullConfig() {
        EnvironmentTestUtils.addEnvironment(this.context,
                "zookeeper.host: 127.0.0.1",
                "zookeeper.post: 2181\n");
        this.context.register(
                ZookeeperAutoConfiguration.class,
                PropertyPlaceholderAutoConfiguration.class
        );
        this.context.refresh();
        assertThat(this.context.getBeanNamesForType(ZookeeperClientFactory.class).length, is(1));
    }
}
