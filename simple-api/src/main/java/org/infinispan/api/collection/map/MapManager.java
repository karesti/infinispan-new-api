package org.infinispan.api.collection.map;

public interface MapManager {

   boolean defineMapConfig(String configName, MapConfig configuration);

   // Will use default configuration
   <K, V> InfinispanMap<K, V> getOrCreateMap(String name);

   // Will use defined configuration
   <K, V> InfinispanMap<K, V> getOrCreateMap(String name, String configName);

   // Will use a given configuration
   <K, V> InfinispanMap<K, V> getOrCreateMap(String name, MapConfig config);

   <K, V> InfinispanAsyncMap<K, V> getOrCreateAsynMap(String name);

}
