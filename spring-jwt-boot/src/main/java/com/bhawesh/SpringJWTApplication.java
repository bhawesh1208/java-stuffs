package com.bhawesh;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
public class SpringJWTApplication {

	public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringJWTApplication.class, args);
    }
	
	
	@Bean
	@Primary
	MessageSource getMessageSource()
	
	{
		ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
		source.setBasenames("classpath:resources/message");
		source.setCacheSeconds(60);
		source.setConcurrentRefresh(true);
		source.setUseCodeAsDefaultMessage(true);
		return source;
	}
	
	@Bean(destroyMethod="shutdown",name="cachedThreadPool")
	ExecutorService executorService()
	{
		return Executors.newCachedThreadPool();
	}
}
