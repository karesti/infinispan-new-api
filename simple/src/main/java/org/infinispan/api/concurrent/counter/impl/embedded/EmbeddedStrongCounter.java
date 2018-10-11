package org.infinispan.api.concurrent.counter.impl.embedded;

import org.infinispan.api.concurrent.counter.SyncStrongCounter;

public class EmbeddedStrongCounter implements SyncStrongCounter {
   private int value = 0;

   public EmbeddedStrongCounter(int value) {
      this.value = value;
   }

   @Override
   public int addAndGet(int increment) {
      return ++value;
   }
}
