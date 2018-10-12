package org.infinispan.api.concurrent.counter.impl.remote;

import org.infinispan.api.concurrent.counter.SyncStrongCounter;

public class RemoteStrongCounter implements SyncStrongCounter {
   private int value = 0;


   @Override
   public int addAndGet(int increment) {
      return 0;
   }
}
