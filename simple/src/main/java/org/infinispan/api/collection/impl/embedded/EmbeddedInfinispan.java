package org.infinispan.api.collection.impl.embedded;

import org.infinispan.api.collection.InfinispanCollectionManagement;
import org.infinispan.api.collection.impl.embedded.map.impl.embedded.EmbeddedMapManager;
import org.infinispan.api.collection.map.MapManager;
import org.infinispan.api.concurrent.InfinispanConcurrencyManagement;
import org.infinispan.api.concurrent.counter.CounterManager;
import org.infinispan.api.concurrent.counter.impl.embedded.EmbeddedCounterManager;

public class EmbeddedInfinispan implements InfinispanCollectionManagement, InfinispanConcurrencyManagement {

   @Override
   public MapManager getMapManager() {
      return new EmbeddedMapManager();
   }

   @Override
   public CounterManager getCounterManager() {
      return new EmbeddedCounterManager();
   }
}
