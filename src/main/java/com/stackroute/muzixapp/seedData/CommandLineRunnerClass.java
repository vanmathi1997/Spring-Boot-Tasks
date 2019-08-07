package com.stackroute.muzixapp.seedData;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;

public class CommandLineRunnerClass implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        final Log logger = LogFactory.getLog(getClass());
        logger.info("Application Started ..............!");
    }

}
