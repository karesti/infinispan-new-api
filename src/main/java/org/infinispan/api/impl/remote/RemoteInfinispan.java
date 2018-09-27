package org.infinispan.api.impl.remote;

import org.infinispan.api.ClusteredDataManager;
import org.infinispan.api.ClusteredDataStructures;
import org.infinispan.api.counter.impl.remote.RemoteCounterManager;
import org.infinispan.api.map.MapManager;
import org.infinispan.api.Infinispan;
import org.infinispan.api.map.impl.embedded.EmbeddedMapManager;
import org.infinispan.api.map.impl.remote.RemoteMapManager;
import org.infinispan.api.search.QueryManager;

public class RemoteInfinispan implements Infinispan {

   @Override
   public ClusteredDataManager getManager(ClusteredDataStructures type) {
      ClusteredDataManager clusteredDataManager;
      switch (type){
         case MAP:
            clusteredDataManager = new RemoteMapManager();
            break;
         case COUNTER:
            clusteredDataManager = new RemoteCounterManager();
            break;
         default:
            throw new IllegalArgumentException("No manager");
      }
      return clusteredDataManager;
   }
}
