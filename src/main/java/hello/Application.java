package hello;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String args[]) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	private String testes;

	public String getTestes() {
		return testes;
	}

	public void setTestes(String testes) {
		this.testes = testes;
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		Quote woeid = new Quote();

		String url = "https://www.metaweather.com/api/location/search/?lattlong=-23.5489,-46.6388"; // lista

		//Object[] objects = restTemplate.getForObject(url, Object[].class);
	

		ResponseEntity<List<Quote2>> rateResponse = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Quote2>>() {
				});
		List<Quote2> quotes = rateResponse.getBody();
		
		for (Quote2 quote1 : quotes) {
			System.out.println(quote1 + " latitude");
			woeid.setWoeid(quote1.getWoeid());
		}
		String url2 = "https://www.metaweather.com/api/location/" + woeid.getWoeid() + "/"; // objeto
		System.out.println(url + " url1");
		System.out.println(url2 + " url2");
		
		
		
		
		
		return args -> {

			// formas para parse de lista de objetos

			Quote4 quote = restTemplate.getForObject(url2, Quote4.class);
			log.info("" + quote.getConsolidated_weather().size());

			for (Quote3 quote1 : quote.getConsolidated_weather()) {
				log.info(quote1.toString()+" WOEIDDDD");
			}

//			ResponseEntity<List<Quote3>> rateResponse = restTemplate.exchange(url2, HttpMethod.GET, null,
//					new ParameterizedTypeReference<List<Quote3>>() {
//					});
//			List<Quote3> quotes = rateResponse.getBody();
//			log.info("" + quotes.size());
//			for (Quote3 quote1 : quotes) {
//				log.info(quote1.toString());
//			}
		};
	}

}