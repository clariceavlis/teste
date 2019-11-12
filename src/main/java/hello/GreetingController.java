package hello;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/greeting/{id}")
    public Greeting greetingId(@PathVariable(value = "id") int id) {
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("Aprender é a única coisa que a mente nunca se cansa, nunca tem medo e nunca se arrepende");
        lista.add("Aquele que não luta pelo futuro que quer, deve aceitar o futuro que vier");
        lista.add("Não importa o quão devagar você vá, desde que você não pare");
        lista.add("Ter sucesso é falhar repetidamente, mas sem perder o entusiasmo");
        lista.add("Descobri que quanto mais eu estudo, mais sorte eu pareço ter nas provas");
        lista.add("É fazendo que se aprende, aquilo que se deve aprender a fazer");
        lista.add("Nenhum obstáculo é tão grande se sua vontade de vencer for maior");
        lista.add("Há cinco degraus para se alcançar a sabedoria: Calar, ouvir, lembrar, sair, estudar.");
        lista.add("Comece onde está. Use o que você tem. Faça o que puder.");
        lista.add("O sucesso normalmente vem para quem está ocupado demais para pensar nele");
        return new Greeting(counter.incrementAndGet(), lista.get(id));

    }
}