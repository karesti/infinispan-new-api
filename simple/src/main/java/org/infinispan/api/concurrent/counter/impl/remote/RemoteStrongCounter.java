package org.infinispan.api.concurrent.counter.impl.remote;

import java.util.concurrent.CompletableFuture;

import org.infinispan.api.concurrent.counter.StrongCounterAsync;

public class RemoteStrongCounter implements StrongCounterAsync {
   private int value = 0;

   @Override
   public CompletableFuture<Integer> addAndGet(int increment) {
      return CompletableFuture.completedFuture(value + increment);
   }
}
