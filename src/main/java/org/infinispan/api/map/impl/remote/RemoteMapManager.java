package org.infinispan.api.map.impl.remote;

import org.infinispan.api.map.InfinispanMap;
import org.infinispan.api.map.MapManager;
import org.infinispan.configuration.cache.Configuration;

public class RemoteMapManager implements MapManager {

   @Override
   public <K, V> InfinispanMap<K, V> getMap(Configuration configuration) {
      return new RemoteCache(configuration);
   }

   @Override
   public <K, V> InfinispanMap<K, V> getMap(String name) {
      return new RemoteCache();
   }
}
