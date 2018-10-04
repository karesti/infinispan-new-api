package org.infinispan.api.concurrent.counter;

import java.util.Collection;

public interface CounterManager {

    boolean defineCounter(String name, CounterConfiguration configuration);

    StrongCounter getStrongCounter(String name);

    StrongCounterAsync getStrongCounterAsync(String name);

    boolean isDefined(String name);

    CounterConfiguration getConfiguration(String counterName);

    void remove(String counterName);

    Collection<String> getCounterNames();
}
