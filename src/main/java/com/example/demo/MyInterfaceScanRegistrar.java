package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;

//@org.springframework.context.annotation.Configuration
public class MyInterfaceScanRegistrar implements ImportBeanDefinitionRegistrar, BeanFactoryAware {

  private ApplicationContext applicationContext;

  Map<String, RestService> clients = new HashMap<>();

  private BeanFactory beanFactory;

  @Override
  public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {

    String BASE_PACKAGE = "com.example";

    // using these packages, scan for interface annotated with MyCustomBean
    ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false) {
      // Override isCandidateComponent to only scan for interface
      @Override
      protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {

        return true;
      }
    };
    provider.addIncludeFilter(new AnnotationTypeFilter(MyCustomBean.class));

    for (BeanDefinition beanDefinition : provider.findCandidateComponents(BASE_PACKAGE)) {
      String clazz = beanDefinition.getBeanClassName();
      ((ConfigurableListableBeanFactory) this.beanFactory).registerSingleton("random" + Math.random(),
          createBean(clazz));
    }
  }

  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    this.beanFactory = beanFactory;

  }

  private Object createBean(String clazz) {

    // JAXRSClientFactory.create("http://localhost", Class.forName(beanDefinition.getBeanClassName()));

    if ("com.example.demo.HelloService".equals(clazz)) {
      return new HelloService() {

        @Override
        public String hello() {

          return "hello from registar";
        }
      };
    }
    return null;
  }
}