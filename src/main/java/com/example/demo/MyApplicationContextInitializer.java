package com.example.demo;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

  @Override
  public void initialize(ConfigurableApplicationContext applicationContext) {

    ConfigurableEnvironment springEnvironment = applicationContext.getEnvironment();
    applicationContext.addBeanFactoryPostProcessor(new DataSourcesBeanFactoryPostProcessor(springEnvironment));
  }
}