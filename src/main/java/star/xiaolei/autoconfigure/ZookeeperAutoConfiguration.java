package star.xiaolei.autoconfigure;

import star.xiaolei.client.ZookeeperClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import star.xiaolei.properties.ZookeeperProperties;

/**
 * Created by 周高磊
 * Date: 2017/5/8.
 * Email: gaoleizhou@gmail.com
 * Desc:
 */
@Configuration
@EnableConfigurationProperties(ZookeeperProperties.class)
public class ZookeeperAutoConfiguration {

    private static Logger logger = LoggerFactory.getLogger(ZookeeperAutoConfiguration.class);

    @Autowired
    private ZookeeperProperties zookeeperProperties;

    @Bean
    public ZookeeperClientFactory zookeeperClientFactory() throws Exception{
        String connection = zookeeperProperties.getHost() + ":" + zookeeperProperties.getPort();
        return new ZookeeperClientFactory(connection);
    }

}
