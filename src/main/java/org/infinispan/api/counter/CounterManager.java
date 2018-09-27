package org.infinispan.api.counter;

import org.infinispan.api.ClusteredDataManager;

public interface CounterManager extends ClusteredDataManager {

    StrongCounter getOrCreateStrongCounter(String name);
}
