package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class GreetingController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting") // mapeando a requisicao na rota /greeting para o metodo
	public Greeting greeting(
			@RequestParam(value="name", defaultValue="World") // parametro opcional do request
			String name) {
		
		// retorno da requisicao:
		// return new Greeting(0, String.format(template, name));
		return new Greeting(counter.incrementAndGet(), String.format(template, name)); 
		// quero incrementar a cada chamada. 
		// Exemplo:
		// GET -> localhost:8080/greeting?name=Julio
		// Returns -> {id: 1, content: "Hello, Julio"} 
		
	}
}
