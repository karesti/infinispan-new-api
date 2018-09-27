package org.infinispan.api.counter.impl.remote;

import java.util.HashMap;
import java.util.Map;

import org.infinispan.api.counter.CounterManager;
import org.infinispan.api.counter.StrongCounter;
import org.infinispan.api.counter.impl.embedded.EmbeddedStrongCounter;

public class RemoteCounterManager implements CounterManager {

   private Map<String, EmbeddedStrongCounter> counters = new HashMap<>();

   @Override
   public StrongCounter getOrCreateStrongCounter(String name) {
      EmbeddedStrongCounter newStrongCounter = new EmbeddedStrongCounter();
      EmbeddedStrongCounter existingCounter = counters.putIfAbsent(name, newStrongCounter);
      return existingCounter == null ? newStrongCounter : existingCounter;
   }
}
