package org.infinispan.api.concurrent.counter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.CompletionStage;

import org.infinispan.api.concurrent.InfinispanConcurrencyAccess;
import org.infinispan.api.concurrent.InfinispanConcurrencyManagement;
import org.junit.jupiter.api.Test;

public class CounterTest {

   @Test
   public void testLocal() throws Exception {
      InfinispanConcurrencyManagement infinispan = InfinispanConcurrencyAccess.getLocalAccess();

      CounterManager counterManager = infinispan.getCounterManager();
      StrongCounter counter1 = counterManager.getStrongCounter("counter1");

      int result = counter1.getSync().addAndGet(1);
      assertThat(result).isEqualTo(1);
   }

   @Test
   public void testLocalAsync() throws Exception {
      InfinispanConcurrencyManagement infinispan = InfinispanConcurrencyAccess.getLocalAccess();

      CounterManager counterManager = infinispan.getCounterManager();
      StrongCounter counter1 = counterManager.getStrongCounter("counter1");

      CompletionStage<Integer> value1 = counter1.addAndGet(3);

      assertThat(value1.toCompletableFuture().get()).isEqualTo(3);
   }
}
