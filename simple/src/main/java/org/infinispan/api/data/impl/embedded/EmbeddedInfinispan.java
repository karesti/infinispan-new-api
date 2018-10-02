package org.infinispan.api.data.impl.embedded;

import org.infinispan.api.data.InfinispanData;
import org.infinispan.api.data.counter.CounterManager;
import org.infinispan.api.data.counter.impl.embedded.EmbeddedCounterManager;
import org.infinispan.api.data.map.MapManager;
import org.infinispan.api.data.map.impl.embedded.EmbeddedMapManager;

public class EmbeddedInfinispan implements InfinispanData {

   @Override
   public MapManager getMapManager() {
      return new EmbeddedMapManager();
   }

   @Override
   public CounterManager getCounterManager() {
      return new EmbeddedCounterManager();
   }
}
