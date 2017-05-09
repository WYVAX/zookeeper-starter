package star.xiaolei.pubsub;

/**
 * Created by 周高磊
 * Date: 2017/5/9.
 * Email: gaoleizhou@gmail.com
 * Desc:
 */
public class Paths {

    //client
    private final String clientBase;

    //subscriber
    private final String subscriberBase;

    //topic
    private final String topicBase;

    public Paths(String basePath, String topic) {
        clientBase = basePath + "/clients";
        subscriberBase = basePath + "subscribers" + topic;
        topicBase = basePath + "topics" + topic;
    }

    public String getClientBase() {
        return clientBase;
    }

    public String getSubscriberBase() {
        return subscriberBase;
    }

    public String getTopicBase() {
        return topicBase;
    }
}
