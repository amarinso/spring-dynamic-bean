package com.example.demo;

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

  @Autowired
  BeanInterface ba;

  @Test
  public void contextLoads() {

    // System.out.println(this.bean1.hello());

    System.out.println(this.service1);

    // System.out.println(this.ba);
  }

}
