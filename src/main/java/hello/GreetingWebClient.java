package hello;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class GreetingWebClient {
    private WebClient client = WebClient.create("http://localhost:8080");

    public String getResult(String url) {
        return ">> result = " + client.get()
            .uri(url)
            .accept(MediaType.TEXT_PLAIN)
            .exchange().flatMap(res -> res.bodyToMono(String.class)).block();
    }
}
