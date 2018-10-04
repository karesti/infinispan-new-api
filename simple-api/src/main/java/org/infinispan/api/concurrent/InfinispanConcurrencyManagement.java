package org.infinispan.api.concurrent;

import org.infinispan.api.concurrent.counter.CounterManager;

public interface InfinispanConcurrencyManagement {

   CounterManager getCounterManager();
}
