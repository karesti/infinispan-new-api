package org.infinispan.api.data.impl.remote;

import org.infinispan.api.data.InfinispanData;
import org.infinispan.api.data.counter.CounterManager;
import org.infinispan.api.data.counter.impl.remote.RemoteCounterManager;
import org.infinispan.api.data.map.MapManager;
import org.infinispan.api.data.map.impl.remote.RemoteMapManager;

public class RemoteInfinispan implements InfinispanData {

   @Override
   public MapManager getMapManager() {
      return new RemoteMapManager();
   }

   @Override
   public CounterManager getCounterManager() {
      return new RemoteCounterManager();
   }
}
