package org.infinispan.api.concurrent.counter.impl.embedded;

import java.util.concurrent.CompletableFuture;

import org.infinispan.api.concurrent.counter.StrongCounterAsync;

public class EmbeddedStrongCounterAsync implements StrongCounterAsync {
   private int value = 0;

   @Override
   public CompletableFuture<Integer> addAndGet(int increment) {
      return CompletableFuture.completedFuture(value + increment);
   }
}
