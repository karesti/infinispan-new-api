package org.infinispan.api.search;

import java.util.concurrent.CompletionStage;

import org.reactivestreams.Publisher;

public interface SearchableMap<K, V> {

   CompletionStage<V> putAndGet(K key, V value);

   CompletionStage<Void> put(K key, V value);

   Publisher<V> list(String ickleQuery);
}
