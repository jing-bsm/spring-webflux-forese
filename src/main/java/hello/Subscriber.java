package hello;

import com.foresee.platform.eventbus.client.BusSubscriber;
import com.foresee.platform.eventbus.data.BusNotification;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Log4j2
public class Subscriber {

    @Autowired
    private BusSubscriber busSubscriber;

    @Value("${event-bus.function.fun1.topic}")
    protected String topicName;

    @Value("${event-bus.function.fun1.consumer-group}")
    protected String consumerGroup;

    @PostConstruct
    protected void subscribeToTopic() {
        String[] topics = {topicName};
        busSubscriber.subscribe(topics, consumerGroup, this::processDeploy, String.class);
    }

    private void processDeploy(BusNotification<String> notification) {
        String receivedEvent = notification.getEvent().getEventName();
//        String eventData = notification.getEventData();
//        log.info("got {}", receivedEvent);
        System.out.print("sub: " + receivedEvent);
    }
}