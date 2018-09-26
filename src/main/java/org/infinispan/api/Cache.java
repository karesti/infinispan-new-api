package org.infinispan.api;

public interface Cache<K, V> {

   V put(K key, V value);

   void putAndReturn(K key, V value);
}
