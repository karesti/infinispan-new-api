package org.infinispan.api.map.v1;

import java.util.Map;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.reactivestreams.Publisher;

public interface RemoteCache<K, V> {

   CompletionStage<V> get(K key);

   CompletionStage<Void> put(K key, V value);

   CompletionStage<Void> put(K key, V value, long lifespan, TimeUnit unit);

   CompletionStage<Void> put(K key, V value, long lifespan, TimeUnit lifepanUnit, long maxidle, TimeUnit maxidleUnit);

   CompletionStage<V> getAndPut(K key, V value);

   Publisher<K> getKeys();

   Publisher<V> getValues();

   CompletionStage<Void> putMany(Map<K, V> pairs);

   CompletionStage<Void> putMany(Publisher<Map.Entry<K, V>> pairs);

   String getName();

   CompletionStage<Long> size();

   interface Factory<K, V> extends Function<CacheConfig, RemoteCache<K, V>> {}
}
