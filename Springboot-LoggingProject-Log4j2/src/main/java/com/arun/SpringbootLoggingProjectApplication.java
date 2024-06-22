package com.arun;

import java.net.Inet4Address;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringbootLoggingProjectApplication {

	public static void main(String[] args) throws UnknownHostException {
		ApplicationContext ctx=SpringApplication.run(SpringbootLoggingProjectApplication.class, args);
		
		Environment env=ctx.getEnvironment();
		
		String port=env.getProperty("server.port");
		
		String host=Inet4Address.getLocalHost().toString();
		String totalAddress="http://"+host.substring(host.lastIndexOf('/')+1)+":"+port;
		
		log.debug("Application  started successfully at address:"+totalAddress);
		
		
		
	}

}
