package hello;

import com.foresee.platform.eventbus.client.BusPublishOptions;
import com.foresee.platform.eventbus.client.BusPublisher;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class Publisher {
    @Autowired
    private BusPublisher busPublisher;

    @Getter
    @Value("${event-bus.function.fun1.topic}")
    protected String topicName;

    public void publishData(String data) {
        BusPublishOptions busPublishOptions = BusPublishOptions.builder()
            .data(data)
            .build();

        log.info("publishing {}", data);
        busPublisher.publishAsync(topicName, "event-name", busPublishOptions, o ->{},
            log::warn);
    }
}
