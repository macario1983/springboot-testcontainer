package com.springboot.testcontainer.configuration;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class FixtureFactoryConfiguration {

    @Bean
    public void register() {
        FixtureFactoryLoader.loadTemplates("com.springboot.testcontainer.templates");
    }
}
