package org.infinispan.api.search.impl.embedded;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import org.infinispan.api.search.SearchableMap;
import org.reactivestreams.Publisher;

public class EmbeddedSearchableMapImpl<K, V> implements SearchableMap<K, V> {
   private Map<K, V> values = new HashMap<>();

   @Override
   public CompletionStage<V> putAndGet(K key, V value) {
      return CompletableFuture.completedFuture(values.put(key, value));
   }

   @Override
   public CompletionStage<Void> put(K key, V value) {
      values.put(key, value);
      return CompletableFuture.completedFuture(null);
   }

   @Override
   public Publisher<V> list(String ickleQuery) {
      List<V> searchResult = new ArrayList<>();
      searchResult.addAll(values.values());
      return s -> System.out.println("subscribed");
   }
}