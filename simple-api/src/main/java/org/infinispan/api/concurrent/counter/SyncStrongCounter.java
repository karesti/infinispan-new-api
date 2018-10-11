package org.infinispan.api.concurrent.counter;

public interface SyncStrongCounter {

   int addAndGet(int increment);
}
