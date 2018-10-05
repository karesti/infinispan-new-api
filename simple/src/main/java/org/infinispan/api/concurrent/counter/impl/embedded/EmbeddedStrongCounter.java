package org.infinispan.api.concurrent.counter.impl.embedded;

import org.infinispan.api.concurrent.counter.StrongCounter;

public class EmbeddedStrongCounter implements StrongCounter {
   private int value = 0;

   @Override
   public int addAndGet(int increment) {
      return ++value;
   }
}
