package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));

    }

    @RequestMapping("/greeting/time")
    public Greeting greetingTime(@RequestParam(value = "hour", defaultValue = "0") int hora) {
        if (hora >= 0 && hora < 12) {
            return new Greeting(counter.incrementAndGet(), "Bom Dia!");
        } else if (hora >= 12 && hora < 18) {
            return new Greeting(counter.incrementAndGet(), "Boa Tarde!");
        } else {
            return new Greeting(counter.incrementAndGet(), "Boa Noite!");
        }

    }
}