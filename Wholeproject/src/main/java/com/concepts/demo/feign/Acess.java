package com.concepts.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "get acess with other controller", url = "http://localhost:8989")
public interface Acess {
	@GetMapping("/returnstring")
	public String callservice();

}
