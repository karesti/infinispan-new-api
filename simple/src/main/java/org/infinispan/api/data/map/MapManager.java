package org.infinispan.api.data.map;

public interface MapManager {

   <K, V> InfinispanMap<K, V> getMap(String name);

   <K, V> InfinispanAsyncMap<K, V> getAsynMap(String name);
}
