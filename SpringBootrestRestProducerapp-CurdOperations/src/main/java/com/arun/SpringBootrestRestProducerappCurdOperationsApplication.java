package com.arun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringBootrestRestProducerappCurdOperationsApplication {
	
	
	
	private static final Logger log=LoggerFactory.getLogger(SpringBootrestRestProducerappCurdOperationsApplication.class);

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringBootrestRestProducerappCurdOperationsApplication.class, args);
		
		logStartingInfo(ctx.getBean(Environment.class));
		
	}
	
	
	public static void logStartingInfo(Environment env)
	{
		String host=null;
		try {
			host=InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {

			log.error("problem in getting local ip address");
		}
		String completeAddress="http://"+host+":"+env.getProperty("server.port");
		
		log.info("Application running privately in :{}",completeAddress);
		
		
		
		try
		{
			
	    URL url=new URL("http://ipecho.net/plain");
		BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream()));
		host=br.readLine().trim();
		br.close();
		}
		catch(Exception e)
		{
			log.error("problem in getting public ip address");
		}
		
       completeAddress="http://"+host+":"+env.getProperty("server.port");
		
		log.info("Application running publicly in :{}",completeAddress);
		
		
		
	}

}
