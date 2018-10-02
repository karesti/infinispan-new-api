package org.infinispan.api.data.counter.impl.embedded;

import java.util.HashMap;
import java.util.Map;

import org.infinispan.api.data.counter.CounterManager;
import org.infinispan.api.data.counter.StrongCounter;

public class EmbeddedCounterManager implements CounterManager {

   private Map<String, EmbeddedStrongCounter> counters = new HashMap<>();

   @Override
   public StrongCounter getOrCreateStrongCounter(String name) {
      EmbeddedStrongCounter newStrongCounter = new EmbeddedStrongCounter();
      EmbeddedStrongCounter existingCounter = counters.putIfAbsent(name, newStrongCounter);
      return existingCounter == null ? newStrongCounter : existingCounter;
   }
}
