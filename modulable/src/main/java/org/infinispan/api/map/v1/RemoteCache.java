package org.infinispan.api.map.v1;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.Flow;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public interface RemoteCache<K, V> {

   CompletionStage<V> get(K key);

   CompletionStage<Void> put(K key, V value);

   CompletionStage<Void> put(K key, V value, long lifespan, TimeUnit unit);

   CompletionStage<Void> put(K key, V value, long lifespan, TimeUnit lifepanUnit, long maxidle, TimeUnit maxidleUnit);

   Flow.Publisher<K> getKeys();

   Flow.Publisher<V> getValues();

   String getName();

   CompletionStage<Long> size();

   interface Factory<K, V> extends Function<CacheConfig, RemoteCache<K, V>> {}
}
