package star.xiaolei.pubsub;

/**
 * Created by 周高磊
 * Date: 2017/5/9.
 * Email: gaoleizhou@gmail.com
 * Desc:
 */
public class Paths {

    private final String topicBase;

    public Paths(String topic) {
        topicBase = topic;
    }

    public String getTopicBase() {
        return topicBase;
    }
}
