package star.xiaolei.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by 周高磊
 * Date: 2017/5/7.
 * Email: gaoleizhou@gmail.com
 * Desc: 属性信息
 */
@ConfigurationProperties(prefix = "zookeeper")
public class ZookeeperProperties {

    //host
    private String host;

    //端口号
    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}