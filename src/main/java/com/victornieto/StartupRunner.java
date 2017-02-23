package com.victornieto;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.boot.CommandLineRunner;

public class StartupRunner implements CommandLineRunner {
	protected final Log logger = LogFactory.getLog(getClass()) ;

	@Override
	public void run(String...args)throws Exception {
		logger.info("Hello") ;
	}
}
