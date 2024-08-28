package com.recykal.API_Gateway;

import io.netty.handler.codec.http.HttpResponseStatus;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Set;

@Component
public class AppFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("Filter Method Called");
        ServerHttpRequest request =exchange.getRequest();
        HttpHeaders httpHeaders=request.getHeaders();
//        Flux<DataBuffer> body = request.getBody();

        Set<String> keySet = httpHeaders.keySet();
        keySet.forEach(key->{
            List<String> values = httpHeaders.get(key);
            System.out.println(key);
            System.out.println(values);
            System.out.println("=========================");
        });
        System.out.println(httpHeaders);
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.BAD_REQUEST);
        response.writeAndFlushWith(null);
        return chain.filter(exchange);
    }
}
