package org.infinispan.api.data.map.impl.embedded;


import org.infinispan.api.data.map.MapManager;
import org.infinispan.api.data.map.InfinispanMap;

public class EmbeddedMapManager implements MapManager {

   @Override
   public <K, V> InfinispanMap<K, V> getMap(String name) {
      return new EmbeddedCache<>();
   }

}
