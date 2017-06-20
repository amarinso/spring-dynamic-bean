package com.example.demo;

/**
 * @author anmas
 *
 */
@RestServiceAnnotation
// @MyInterfaceScan
@MyCustomBean
public interface HelloService extends RestService {
  public String hello();
}
