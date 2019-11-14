package hello;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Log4j2
public class Controller {

    @GetMapping("/foo")
    public Mono<String> get() {
        log.info("got a req");
        return Mono.just("foo " + System.currentTimeMillis());
    }
}
