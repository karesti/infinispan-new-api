package org.infinispan.api.counter.impl.embedded;

import java.util.concurrent.CompletableFuture;

import org.infinispan.api.counter.StrongCounter;

public class EmbeddedStrongCounter implements StrongCounter {
   private int value = 0;

   @Override
   public CompletableFuture<Integer> addAndGet(int increment) {
      return CompletableFuture.completedFuture(value + increment);
   }
}
