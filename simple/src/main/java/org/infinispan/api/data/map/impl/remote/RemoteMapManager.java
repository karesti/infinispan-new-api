package org.infinispan.api.data.map.impl.remote;

import org.infinispan.api.data.map.InfinispanAsyncMap;
import org.infinispan.api.data.map.MapManager;
import org.infinispan.api.data.map.InfinispanMap;
import org.infinispan.configuration.cache.Configuration;

public class RemoteMapManager implements MapManager {

   @Override
   public <K, V> InfinispanMap<K, V> getMap(String name) {
      return new RemoteCache();
   }

   @Override
   public <K, V> InfinispanAsyncMap<K, V> getAsynMap(String name) {
      return new RemoteAsyncCache();
   }
}
