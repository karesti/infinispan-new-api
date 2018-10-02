package org.infinispan.api.transactions;

public interface TransactionalMap<K, V> {
   void put(K key, V value);
}