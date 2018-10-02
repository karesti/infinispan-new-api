package org.infinispan.api.data.counter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.CompletableFuture;

import org.infinispan.api.data.InfinispanData;
import org.infinispan.api.data.InfinispanDataAccess;
import org.junit.jupiter.api.Test;

public class CounterTest {

   @Test
   public void testEmbedded() throws Exception {
      InfinispanData infinispan = InfinispanDataAccess.getInfinispanRemote();

      CounterManager counterManager = infinispan.getCounterManager();
      StrongCounter counter1 = counterManager.getOrCreateStrongCounter("counter1");
      StrongCounter counter2 = counterManager.getOrCreateStrongCounter("counter2");

      CompletableFuture<Integer> value1 = counter1.addAndGet(3);
      CompletableFuture<Integer> value2 = counter2.addAndGet(5);

      assertThat(value1.get()).isEqualTo(3);
      assertThat(value2.get()).isEqualTo(5);
   }

   @Test
   public void testRemote() throws Exception {
      InfinispanData infinispan = InfinispanDataAccess.getInfinispanRemote();

      CounterManager counterManager = infinispan.getCounterManager();
      StrongCounter counter1 = counterManager.getOrCreateStrongCounter("counter1");

      CompletableFuture<Integer> value1 = counter1.addAndGet(3);

      assertThat(value1.get()).isEqualTo(3);
   }
}
