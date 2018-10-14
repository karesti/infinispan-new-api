package org.infinispan.api.search.impl.embedded;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import org.infinispan.api.search.ContinuousQueryPublisher;
import org.infinispan.api.search.Query;
import org.infinispan.api.search.QueryFactory;
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

   @Override
   public CompletionStage<QueryFactory> queryFactory() {
      return null;
   }

   @Override
   public Publisher<V> list(Query query) {
      return null;
   }

   @Override
   public ContinuousQueryPublisher<K, V> addContinuousQuery(Query query) {
      return null;
   }

   @Override
   public ContinuousQueryPublisher<K, V> addContinuousQuery(String ickleQuery) {
      return null;
   }
}