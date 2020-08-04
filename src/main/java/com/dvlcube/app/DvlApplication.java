package com.dvlcube.app;

import com.dvlcube.utils.ConfigUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.dvlcube.app.manager.data.UserBean;
import com.dvlcube.app.conf.ApplicationConfig;

import java.util.Collections;

/**
 * @see ApplicationConfig
 * @see ServletInitializer
 * @since 13 de fev de 2019
 * @author Ulisses Lima
 */
@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = "com.dvlcube")
@EntityScan(basePackageClasses = UserBean.class)
public class DvlApplication {



	public static void main(String[] args) {
		ConfigUtils configUtils = new ConfigUtils();
		SpringApplication app = new SpringApplication(DvlApplication.class);
		//app.setDefaultProperties(Collections.singletonMap("server.port", configUtils.getPort()));
		ConfigurableApplicationContext context = app.run(args);
		int i = 1;
		for (String name : context.getBeanDefinitionNames()) {
			System.out.println(i++ + " scanned. " + name);
		}

	}
}
