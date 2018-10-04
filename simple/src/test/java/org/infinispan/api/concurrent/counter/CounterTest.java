package org.infinispan.api.concurrent.counter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import org.infinispan.api.collection.InfinispanCollectionManagement;
import org.infinispan.api.collection.InfinispanCollectionsAccess;
import org.infinispan.api.concurrent.InfinispanConcurrencyManagement;
import org.infinispan.api.concurrent.InfinispanConcurrencyAccess;
import org.junit.jupiter.api.Test;

public class CounterTest {

   @Test
   public void testLocalSync() throws Exception {
      InfinispanConcurrencyManagement infinispan = InfinispanConcurrencyAccess.getLocalAccess();

      CounterManager counterManager = infinispan.getCounterManager();
      StrongCounter counter1 = counterManager.getStrongCounter("counter1");

      int result = counter1.addAndGet(1);
      assertThat(result).isEqualTo(1);
   }

   @Test
   public void testLocalAsync() throws Exception {
      InfinispanConcurrencyManagement infinispan = InfinispanConcurrencyAccess.getLocalAccess();

      CounterManager counterManager = infinispan.getCounterManager();
      StrongCounterAsync counter1 = counterManager.getStrongCounterAsync("counter1");


      CompletionStage<Integer> value1 = counter1.addAndGet(3);

      assertThat(value1.toCompletableFuture().get()).isEqualTo(3);
   }
}
