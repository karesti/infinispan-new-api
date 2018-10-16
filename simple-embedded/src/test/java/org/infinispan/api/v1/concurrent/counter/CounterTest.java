package org.infinispan.api.v1.concurrent.counter;

import org.infinispan.api.Infinispan;
import org.junit.jupiter.api.Test;

public class CounterTest {

   @Test
   public void embedded_counter() throws Exception {
      StrongCounter counter = Infinispan.get(StrongCounterApi.instance(), new CounterConfiguration());
      counter.addAndGet(1).whenComplete((v, ex) -> System.out.println(v));
   }
}
