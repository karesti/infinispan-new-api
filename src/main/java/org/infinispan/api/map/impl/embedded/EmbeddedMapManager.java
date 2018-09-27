package org.infinispan.api.map.impl.embedded;

import org.infinispan.api.map.InfinispanMap;
import org.infinispan.api.map.MapManager;
import org.infinispan.configuration.cache.Configuration;

public class EmbeddedMapManager implements MapManager {

   @Override
   public <K, V> InfinispanMap<K, V> getMap(String name) {
      return new EmbeddedCache<>();
   }

   @Override
   public <K, V> InfinispanMap<K, V> getMap(Configuration configuration) {
      return new EmbeddedCache<>();
   }
}
