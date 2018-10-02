package org.infinispan.api.data.map;

public interface InfinispanMap<K, V> {

   void put(K key, V value);

   V get(K key);
}
