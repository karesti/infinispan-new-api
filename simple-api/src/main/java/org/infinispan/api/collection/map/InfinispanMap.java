package org.infinispan.api.collection.map;

public interface InfinispanMap<K, V> {

   void put(K key, V value);

   V get(K key);
}
