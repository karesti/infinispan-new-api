package org.infinispan.api.concurrent.counter.impl.embedded;

import java.util.concurrent.CompletableFuture;

import org.infinispan.api.concurrent.counter.StrongCounter;
import org.infinispan.api.concurrent.counter.SyncStrongCounter;

public class EmbeddedStrongCounterAsync implements StrongCounter {
   private int value = 0;

   @Override
   public CompletableFuture<Integer> addAndGet(int increment) {
      return CompletableFuture.completedFuture(value + increment);
   }

   @Override
   public SyncStrongCounter getSync() {
      return new EmbeddedStrongCounter(value);
   }
}
