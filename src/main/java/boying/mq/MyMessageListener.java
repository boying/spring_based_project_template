package boying.mq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * Created by boying on 2017/9/29.
 */
public class MyMessageListener implements MessageListener{
    @Override
    public void onMessage(Message message) {
    }
}
