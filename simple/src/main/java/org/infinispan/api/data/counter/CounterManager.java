package org.infinispan.api.data.counter;


public interface CounterManager {

    StrongCounter getOrCreateStrongCounter(String name);
}
