package org.infinispan.api.counter.impl.remote;

import java.util.concurrent.CompletableFuture;

import org.infinispan.api.counter.StrongCounter;

public class RemoteStrongCounter implements StrongCounter {
   private int value = 0;

   @Override
   public CompletableFuture<Integer> addAndGet(int increment) {
      return CompletableFuture.completedFuture(value + increment);
   }
}
