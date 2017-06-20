package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

  // @Autowired
  // Bean1 bean1;

  @Autowired()
  // RestService<HelloService> service1;
  // @Qualifier("RestService")
  HelloService service1;

  @Test
  public void contextLoads() {

    Assert.assertEquals("hello from syntetic service", this.service1.hello());
  }

}
