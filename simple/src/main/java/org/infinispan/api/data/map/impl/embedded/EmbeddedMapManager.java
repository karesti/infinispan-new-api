package org.infinispan.api.data.map.impl.embedded;


import org.infinispan.api.data.map.InfinispanAsyncMap;
import org.infinispan.api.data.map.InfinispanMap;
import org.infinispan.api.data.map.MapManager;

public class EmbeddedMapManager implements MapManager {

   @Override
   public <K, V> InfinispanMap<K, V> getMap(String name) {
      return new EmbeddedCache<>();
   }

   @Override
   public <K, V> InfinispanAsyncMap<K, V> getAsynMap(String name) {
      return new EmbeddedAsyncCache<>();
   }

}
