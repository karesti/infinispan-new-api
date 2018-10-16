package org.infinispan.api.v1.concurrent.counter;

public interface SyncStrongCounter {

   int addAndGet(int increment);
}
