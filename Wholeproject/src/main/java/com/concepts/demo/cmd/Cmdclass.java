package com.concepts.demo.cmd;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Cmdclass {
	@Bean
	 CommandLineRunner adddeatials() {
		return args->{
			System.out.println("hello working fine");
		};
	}

}
