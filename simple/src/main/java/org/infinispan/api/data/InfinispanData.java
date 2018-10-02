package org.infinispan.api.data;

import org.infinispan.api.data.counter.CounterManager;
import org.infinispan.api.data.map.MapManager;

public interface InfinispanData {

   MapManager getMapManager();

   CounterManager getCounterManager();

}
