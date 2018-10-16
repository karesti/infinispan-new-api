package org.infinispan.api.v1.concurrent.counter;

import java.util.Collection;

public interface CounterManager {

    boolean defineCounter(String name, CounterConfiguration configuration);

    StrongCounter getStrongCounter(String name);

    boolean isDefined(String name);

    CounterConfiguration getConfiguration(String counterName);

    void remove(String counterName);

    Collection<String> getCounterNames();
}
