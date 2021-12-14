package com.example.hellospringretry;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class MyService {
//  @Retryable(
//    value = ArithmeticException.class,
//    maxAttempts = 2,
//    backoff = @Backoff(delay = 5001))
  int doSomething1(int a) {
    try {
      System.out.println("---------------- Doing");
      int i = a/0;
      return i;
    } catch (ArithmeticException ex) {
      throw ex;
    }
  }

//  @Retryable(
//    value = Exception.class,
//    maxAttempts = 2,
//    backoff = @Backoff(delay = 1001))
  int doSomething(int a) {
    try {
      System.out.println("---------------- Doing");
      int i = a/0;
      return i;
    } catch (Exception ex) {
      throw ex;
    }
  }

  @Recover
  public int recover(Exception ex, int a) {
    System.out.println("---------------- Recovering for ex " + ex.getMessage());
    return a;
  }
}
