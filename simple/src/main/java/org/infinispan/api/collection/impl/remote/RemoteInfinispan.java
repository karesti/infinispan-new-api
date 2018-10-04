package org.infinispan.api.collection.impl.remote;

import org.infinispan.api.collection.InfinispanCollectionManagement;
import org.infinispan.api.collection.map.MapManager;
import org.infinispan.api.concurrent.InfinispanConcurrencyManagement;
import org.infinispan.api.concurrent.counter.CounterManager;
import org.infinispan.api.concurrent.counter.impl.remote.RemoteCounterManager;

public class RemoteInfinispan implements InfinispanCollectionManagement, InfinispanConcurrencyManagement {

   @Override
   public MapManager getMapManager() {
      throw new UnsupportedOperationException("no remote implemented yet");
   }

   @Override
   public CounterManager getCounterManager() {
      return new RemoteCounterManager();
   }
}
