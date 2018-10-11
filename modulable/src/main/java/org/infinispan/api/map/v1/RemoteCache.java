package org.infinispan.api.map.v1;

import java.util.concurrent.CompletionStage;
import java.util.function.Function;

public interface RemoteCache<K, V> {

   CompletionStage<V> get(K key);

   CompletionStage<Void> put(K key, V value);

   String getName();

   interface Factory<K, V> extends Function<CacheConfig, RemoteCache<K, V>> {}
}
