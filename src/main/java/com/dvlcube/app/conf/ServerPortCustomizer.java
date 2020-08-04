package com.dvlcube.app.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ServerPortCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

    @Autowired
    private ApplicationConfig applicationConfig;


    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        factory.setPort(Integer.parseInt(applicationConfig.getPort()));

    }
}
