package org.infinispan.api.concurrent;

import org.infinispan.api.concurrent.counter.CounterManager;
import org.infinispan.api.concurrent.lock.ClusteredLockManager;

public interface InfinispanConcurrencyManagement {

   CounterManager getCounterManager();

   ClusteredLockManager getClusteredLockManager();
}
