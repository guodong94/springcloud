package com.gd.servicehi;

import brave.sampler.Sampler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceHiApplication.class, args);
	}

	private static Logger logger = LoggerFactory.getLogger(ServiceHiApplication.class);

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@RequestMapping("/hi")
	public String callHome(){
		logger.info( "calling trace service-hi  ");
		return restTemplate.getForObject("http://localhost:8300/miya", String.class);
	}
	@RequestMapping("/info")
	public String info(){
		logger.info("calling trace service-hi ");

		return "i'm service-hi";

	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

	@Value("${server.port}")
	String port;

	@RequestMapping("/h1")
	public String home(@RequestParam(value = "name",defaultValue = "gd") String name){

		return "name:"+name+",port:"+port;
	}


}
