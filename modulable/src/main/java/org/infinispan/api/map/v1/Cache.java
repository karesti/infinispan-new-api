package org.infinispan.api.map.v1;

import java.util.function.Function;

public interface Cache<K, V> {

   V get(K key);

   V put(K key, V value);

   String getName();

   interface Factory<K, V> extends Function<CacheConfig, Cache<K, V>> {}

   interface RemoteFactory<K, V> extends Function<CacheConfig, Cache<K, V>> {}
}
