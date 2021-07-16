package com.nextconnect.NextConnect;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@SpringBootApplication
@EnableJpaRepositories("com.nextconnect")
@ComponentScan("com.nextconnect")
@EntityScan("com.nextconnect")
@EnableScheduling
public class NextConnectApplication {
	
	@Value("${proxy.host}")
	private String proxyHost;
	
	@Value("${proxy.port}")
	private String proxyPort;

	public static void main(String[] args) {
		SpringApplication.run(NextConnectApplication.class, args);
	}
	
	@Bean
    public SseEmitter myEmitter() {
    	return new SseEmitter(Long.MAX_VALUE);
    }
	
	@Bean(name = "myRestClient")
	public RestTemplate restApiConsumer() {
		
		return new RestTemplate(getClientHttpRequestFactory());
	}
	
	private ClientHttpRequestFactory getClientHttpRequestFactory() {
		Proxy proxy= null;
		
		System.out.println(proxyHost);
		System.out.println(proxyPort);
		
		if(proxyHost != null) {
			proxy = new Proxy(Type.HTTP, new InetSocketAddress(proxyHost, Integer.parseInt(proxyPort)));
		}
	    
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
	
		requestFactory.setProxy(proxy);
	    return requestFactory;
	}

}
