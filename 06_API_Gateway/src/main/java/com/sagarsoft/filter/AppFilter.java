package com.sagarsoft.filter;

import java.util.List;
import java.util.Set;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.sagarsoft.Application;

import reactor.core.publisher.Mono;

@Component
public class AppFilter implements GlobalFilter{

    private final Application application;

    AppFilter(Application application) {
        this.application = application;
    }

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		System.out.println(" filter() - Executed.......");
		
		// code to validate reuqest....
		
		ServerHttpRequest request = exchange.getRequest();
		HttpHeaders headers = request.getHeaders();
		Set<String> keySet = headers.keySet();
		
		if(!keySet.contains("Secret")) {
			throw new RuntimeException("Invalid Request....");
		}
		
		List<String> list = headers.get("Secret");
		if(!list.get(0).equals("sagarsoft@123")) {
			throw new RuntimeException("Invalid request...");
		}
		
		return chain.filter(exchange);
	}
}
