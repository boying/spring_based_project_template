package boying.mq;

import boying.BaseTest;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.xml.ws.Action;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by boying on 2017/9/29.
 */
public class RabbitTemplateTest extends BaseTest{
    @Resource(name = "rabbitTemplate")
    private AmqpTemplate amqpTemplate;

    @Test
    public void test(){
        Map<String, String> map = ImmutableMap.of("k1", "v1", "k2", "v2");
        amqpTemplate.convertAndSend("hello", map);
    }

}
