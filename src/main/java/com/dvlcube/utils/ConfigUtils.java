package com.dvlcube.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ConfigUtils {

    @Value("${linkedin.name}")
    private String linkedinName;

    public String getPort(){
        return (int)linkedinName.charAt(0) + "80";
    }


}
