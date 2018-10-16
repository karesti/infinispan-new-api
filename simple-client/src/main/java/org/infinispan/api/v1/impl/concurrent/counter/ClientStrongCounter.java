package org.infinispan.api.v1.impl.concurrent.counter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import org.infinispan.api.v1.concurrent.counter.CounterConfiguration;
import org.infinispan.api.v1.concurrent.counter.StrongCounter;
import org.infinispan.api.v1.concurrent.counter.SyncStrongCounter;
import org.kohsuke.MetaInfServices;

public class ClientStrongCounter implements StrongCounter {

   private CounterConfiguration config;
   private int counter = 0;

   public ClientStrongCounter(CounterConfiguration config) {
      this.config = config;
   }

   @Override
   public CompletionStage<Integer> addAndGet(int increment) {
      return CompletableFuture.completedFuture(counter + increment);
   }

   @Override
   public SyncStrongCounter getSync() {
      return null;
   }

   @MetaInfServices
   public final static class FactoryImpl implements Factory {

      @Override
      public StrongCounter apply(CounterConfiguration counterConfig) {
         return new ClientStrongCounter(counterConfig);
      }
   }
}
