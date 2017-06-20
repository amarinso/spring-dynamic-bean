package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * @author anmas
 *
 */
@org.springframework.context.annotation.Configuration
@Import(MyInterfaceScanRegistrar.class)
public class Configuration {

  @Bean
  public MyInterfaceScanRegistrar createRegistar() {

    return new MyInterfaceScanRegistrar();
  }
}
