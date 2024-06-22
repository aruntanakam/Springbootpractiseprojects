package com.arun;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootRestapicallsApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(SpringbootRestapicallsApplication.class, args);
		HttpClient client=HttpClient.newHttpClient();
		HttpRequest request=HttpRequest.newBuilder(URI.create("https://fakestoreapi.com/products/1")).GET().build();
	    HttpResponse<String> response=client.send(request, HttpResponse.BodyHandlers.ofString());
	    System.out.println(response.statusCode());
	    System.out.println(response.body());
	    int disc=16;
	    int price=3792;
	    double d=disc/100.0;
	    
	    System.out.println(d);
	    
	}

}
