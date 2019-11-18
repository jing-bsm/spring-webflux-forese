package hello;

import com.foresee.platform.eventbus.client.kafka.spring.config.EnableEventBus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEventBus
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        GreetingWebClient gwc = new GreetingWebClient();
        System.out.println(gwc.getResult("/foo"));
        System.out.println(gwc.getResult("/bar"));
//        new Thread(()->{
//            try {
//                Thread.sleep(1000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.exit(0);
//        }).start();

    }
}
