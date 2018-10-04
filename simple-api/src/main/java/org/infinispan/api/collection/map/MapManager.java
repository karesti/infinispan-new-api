package org.infinispan.api.collection.map;

public interface MapManager {

   boolean defineMap(String name, Object configuration);

   <K, V> InfinispanMap<K, V> getOrCreateMap(String name);

   <K, V> InfinispanAsyncMap<K, V> getOrCreateAsynMap(String name);

}
