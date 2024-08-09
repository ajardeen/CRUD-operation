package com.teluskopractices.simplewebapp;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;

public class ServierPortCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        String port = System.getenv("X_ZOHO_CATALYST_LISTEN_PORT");
        int listenPort;
        if(port != null  && !port.isEmpty()){
            listenPort = Integer.parseInt(System.getenv("X_ZOHO_CATALYST_LISTEN_PORT"));
        }else{
            listenPort =9000;
        }
        factory.setPort(listenPort);
    }
}