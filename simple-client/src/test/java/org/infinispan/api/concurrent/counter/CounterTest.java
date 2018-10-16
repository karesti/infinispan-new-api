package org.infinispan.api.concurrent.counter;


import org.infinispan.api.Infinispan;
import org.infinispan.api.v1.concurrent.counter.CounterConfiguration;
import org.infinispan.api.v1.concurrent.counter.StrongCounter;
import org.infinispan.api.v1.concurrent.counter.StrongCounterApi;
import org.junit.jupiter.api.Test;

public class CounterTest {

   @Test
   public void strong_counter() throws Exception {
      StrongCounter counter = Infinispan.get(StrongCounterApi.instance(), new CounterConfiguration());
      System.out.println(counter.getClass());
      counter.addAndGet(1).whenComplete((v, ex) -> System.out.println(v));
   }
}
