package org.infinispan.api.map.v1;

import java.util.concurrent.CompletionStage;
import java.util.function.Function;

public interface Cache<K, V> {

   CompletionStage<V> get(K key);

   CompletionStage<Void> put(K key, V value);

   String getName();

   interface Factory<K, V> extends Function<CacheConfig, Cache<K, V>> {}
}
