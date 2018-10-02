package org.infinispan.api.data.counter;

import static org.assertj.core.api.Assertions.assertThat;

public class CounterTest {

//   @Test
//   public void testEmbedded() throws Exception {
//      Infinispan infinispan = InfinispanAccess.getInfinispan();
//      testCounter(infinispan);
//   }
//
//   @Test
//   public void testRemote() throws Exception {
//      Infinispan infinispan = InfinispanRemote.getInfinispan();
//      testCounter(infinispan);
//   }
//
//   private void testCounter(Infinispan infinispan) throws InterruptedException, java.util.concurrent.ExecutionException {
//      CounterManager counterManager = infinispan.getManager(ClusteredDataStructureManager.COUNTER);
//
//      StrongCounter counter1 = counterManager.getOrCreateStrongCounter("counter1");
//      StrongCounter counter2 = counterManager.getOrCreateStrongCounter("counter2");
//
//      CompletableFuture<Integer> value1 = counter1.addAndGet(3);
//      CompletableFuture<Integer> value2 = counter2.addAndGet(5);
//
//      assertThat(value1.get()).isEqualTo(3);
//      assertThat(value2.get()).isEqualTo(5);
//   }
}
