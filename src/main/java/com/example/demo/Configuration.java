package com.example.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 * @author anmas
 *
 */
@org.springframework.context.annotation.Configuration
@Import(MyInterfaceScanRegistrar.class)
public class Configuration {

  @Bean
  public BeanInterface createBeanWithInterface() {

    return new BeanInterface() {

      @Override
      public String hello() {

        // TODO Auto-generated method stub
        return "new generated bean on config";
      }
    };
  }

  @Bean
  @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.INTERFACES)
  public RestService createRestService() {

    return new RestService() {
    };
  }

  @Bean
  public MyInterfaceScanRegistrar createRegistar() {

    return new MyInterfaceScanRegistrar();
  }
}
