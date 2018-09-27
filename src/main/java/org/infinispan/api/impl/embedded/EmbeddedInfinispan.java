package org.infinispan.api.impl.embedded;

import org.infinispan.api.ClusteredDataManager;
import org.infinispan.api.ClusteredDataStructures;
import org.infinispan.api.Infinispan;
import org.infinispan.api.counter.impl.embedded.EmbeddedCounterManager;
import org.infinispan.api.map.impl.embedded.EmbeddedMapManager;
import org.infinispan.api.map.impl.remote.RemoteMapManager;

public class EmbeddedInfinispan implements Infinispan {

   @Override
   public ClusteredDataManager getManager(ClusteredDataStructures type) {
      ClusteredDataManager clusteredDataManager;
      switch (type){
         case MAP:
            clusteredDataManager = new EmbeddedMapManager();
            break;
         case COUNTER:
            clusteredDataManager = new EmbeddedCounterManager();
            break;
         default:
            throw new IllegalArgumentException("No manager");
      }
      return clusteredDataManager;
   }
}
