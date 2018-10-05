package org.infinispan.api.concurrent.counter.impl.embedded;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.infinispan.api.concurrent.counter.CounterConfiguration;
import org.infinispan.api.concurrent.counter.CounterManager;
import org.infinispan.api.concurrent.counter.StrongCounter;
import org.infinispan.api.concurrent.counter.StrongCounterAsync;


public class EmbeddedCounterManager implements CounterManager {

   private Map<String, EmbeddedStrongCounterAsync> counters = new HashMap<>();

   @Override
   public boolean defineCounter(String name, CounterConfiguration configuration) {
      return true;
   }

   @Override
   public StrongCounter getStrongCounter(String name) {
      return new EmbeddedStrongCounter();
   }

   @Override
   public StrongCounterAsync getStrongCounterAsync(String name) {
      return new EmbeddedStrongCounterAsync();
   }

   @Override
   public boolean isDefined(String name) {
      return counters.get(name) != null;
   }

   @Override
   public CounterConfiguration getConfiguration(String counterName) {
      return new CounterConfiguration();
   }

   @Override
   public void remove(String counterName) {
      counters.remove(counterName);
   }

   @Override
   public Collection<String> getCounterNames() {
      return counters.keySet();
   }
}
