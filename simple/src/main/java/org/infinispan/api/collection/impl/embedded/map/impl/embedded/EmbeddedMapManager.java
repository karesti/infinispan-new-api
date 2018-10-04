package org.infinispan.api.collection.impl.embedded.map.impl.embedded;


import org.infinispan.api.collection.map.InfinispanAsyncMap;
import org.infinispan.api.collection.map.InfinispanMap;
import org.infinispan.api.collection.map.MapManager;

public class EmbeddedMapManager implements MapManager {

   @Override
   public boolean defineMap(String name, Object configuration) {
      return true;
   }

   @Override
   public <K, V> InfinispanMap<K, V> getOrCreateMap(String name) {
      return new EmbeddedCache<>();
   }

   @Override
   public <K, V> InfinispanAsyncMap<K, V> getOrCreateAsynMap(String name) {
      return new EmbeddedAsyncCache<>();
   }
}
